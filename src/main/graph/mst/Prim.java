package graph.mst;

import graph.WeightedGraph;
import graph.SparseWeightedGraph;
import priorityqueue.HeapPriorityQueue;
import priorityqueue.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class implements the prim's algorithm to find the minimum spanning tree of a generic graph.
 * The MST starts from a root vertex and develops to cover all the vertices in the graph.
 * At each step, a light arc that connect the MST T with an isolated vertex is added,
 * so when the algorithm end the arc in T form the minimum spanning tree.
 * @param <T>
 */
public class Prim<T> implements MinimumSpanningTree<T> {

    class Node {
        T value;
        double key;
        T parent;

        private Node(T value, double key, T parent) {
            this.value = value;
            this.key = key;
            this.parent = parent;
        }

        private Node(T value) {
            this.value = value;
            this.key = Double.MAX_VALUE;
            this.parent = null;
        }
        @Override
        public boolean equals(Object obj) {
            if(obj == null) return false;
            if(!Node.class.isAssignableFrom(obj.getClass())) return false;
            final Node other = (Node) obj;
            return this.value.equals(other.value);
        }
    }

    /**
     * Node comparator that compares the key nodes in the reverse order
     */
    class ReverseNodeComparator implements Comparator<Node> {

        @Override
        public int compare(Prim.Node node, Prim.Node t1) {
            return Double.compare(t1.key, node.key);
        }
    }


    /**
     * This methods returns the minimum spanning tree of the given graph,
     * starting from a random vertex from the given graph.
     * It uses a MinHeapPriorityQueue to store all the vertices among with their Edge's weight from their parents.
     * The type of the graph returned is the same of the given graph.
     * @param graph The graph used to create the minimum spanning tree
     * @return A minimum spanning tree
     */
    public WeightedGraph<T> mst(WeightedGraph<T> graph) {
        if(graph == null) return null;
        WeightedGraph<T> mstGraph = new SparseWeightedGraph<>(graph.getGraphType());
        HeapPriorityQueue<Node> pq = new HeapPriorityQueue<>(new ReverseNodeComparator());
        ArrayList<T> vertices = graph.getVertices();
        if(graph.getTotalVertices() > 0)
            initPriorityQueue(pq,vertices);

        while(!pq.isEmpty()) {
            Node node = pq.extract();
            addToGraph(mstGraph, node);

            ArrayList<T> adjVert = graph.getAdjacentVertices(node.value);
            for(T vertex : adjVert) {
                Node n = new Node(vertex, graph.getWeightOfEdge(node.value,vertex), node.value);
                int index = pq.indexOf(new Node(vertex));
                if(index != -1)
                    pq.changePriority(index, n);
            }
        }

        return mstGraph;
    }

    /**
     * This method initializes the priority queue
     * @param pq The priority queue to initialize
     * @param vertices The vertices to store into the priority queue
     */
    private void initPriorityQueue(PriorityQueue<Node> pq, ArrayList<T> vertices) {
        pq.insert(new Node(vertices.get(0), 0.0, null));
        for(int i = 1; i < vertices.size(); i++) {
            pq.insert(new Node(vertices.get(i)));
        }
    }

    /**
     * This method add to the MST the vertex and the light edge
     * found through the algorithm
     * @param graph The minimum spanning tree
     * @param node The node that store the vertex and their weight from their parent
     */
    private void addToGraph(WeightedGraph<T> graph, Node node) {
        graph.addVertex(node.value);
        if(node.parent != null)
            graph.addEdge(node.parent, node.value, node.key);
    }


}
