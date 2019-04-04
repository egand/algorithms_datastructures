package graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Sparse Weighted graph implementation based on adjacency lists.
 * This implementation use a HashMap to store vertices and their adjacency list.
 * The adjacency list use a built-in SinglyLinkedList that stores the Edges.
 * @param <T>
 */
public class SparseWeightedGraph<T> implements WeightedGraph<T> {

    /**
     * Built-in implementation of SinglyLinkedList where the Edges are stored.
     */
    private class SinglyLinkedList {

        /**
         * The size of the SinglyLinkedList
         */
        private int size;
        /**
         * The head of the SinglyLinkedList
         */
        private Edge head;

        private SinglyLinkedList() {
            size = 0;
            head = null;
        }

        /**
         * Insert the specified Edge e in the SinglyLinkedList
         * @param e The specified Edge to be inserted
         */
        private void insert(Edge e) {
            e.next = head;
            head = e;
            size++;
        }

        /**
         * Delete the Edge with the specified value
         * @param value The value of the Edge to delete
         * @return True if the value is found and deleted
         */
        private boolean remove(T value) {
            Edge prev = null;
            Edge current = head;

            while(current != null && !current.destination.equals(value)) {
                prev = current;
                current = current.next;
            }
            if(current == null) return false;
            if(prev == null) head = current.next; // e is head node
            else prev.next = current.next;
            return true;
        }

        /**
         * Search for an Edge with the specified value
         * @param value The value of the Edge to search
         * @return The Edge with the specified value, or null if it does not exists
         */
        private Edge search(T value) {
            Edge current = head;
            while(current != null && !current.destination.equals(value))
                current = current.next;
            return current;
        }

        /**
         * Returns an ArrayList with all the Edges' value
         * @return An ArrayList with all the Edges' value
         */
        private ArrayList<T> toArrayList() {
            ArrayList<T> arrayList = new ArrayList<>(size);
            Edge edge = head;
            while(edge != null) {
                arrayList.add(edge.destination);
                edge = edge.next;
            }
            return arrayList;
        }
    }

    /**
     * Inner class that represent the edges of the graph
     */
    private class Edge {
        /**
         * The vertex where the Edge end
         */
        private T destination;
        /**
         * The Edge's weight
         */
        private double weight;
        /**
         * The next edge node of the SinglyLinkedList
         */
        private Edge next;

        private Edge(T destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    /**
     * The adjacent list of the Graph
     */
    private HashMap<T, SinglyLinkedList> adjList = new HashMap<>();
    /**
     * The type of the graph
     */
    private GraphType graphType;
    /**
     * The total weight of the graph
     */
    private double totalWeight;
    /**
     * The total edges of the graph
     */
    private int totalEdges;


    public SparseWeightedGraph(GraphType graphType) {
        this.graphType = graphType;
        this.totalWeight = 0;
        this.totalEdges = 0;
    }

    @Override
    public boolean addVertex(T vertex) {
        if(adjList.containsKey(vertex))
            return false;
        adjList.put(vertex, new SinglyLinkedList());
        return true;
    }

    @Override
    public boolean addEdge(T v1, T v2, double weight) {
        if(!adjList.containsKey(v1)) addVertex(v1);

        if(!hasEdge(v1,v2)) {
            SinglyLinkedList v1edges = adjList.get(v1);
            v1edges.insert(new Edge(v2, weight));
            totalEdges = totalEdges + 1;
            totalWeight = totalWeight + weight;
        }
        addVertex(v2);
        if(graphType == GraphType.UNDIRECTED) {
            if(!hasEdge(v2,v1)) {
                SinglyLinkedList v2edges = adjList.get(v2);
                v2edges.insert(new Edge(v1, weight));
            }
        }
        return true;
    }

    @Override
    public boolean hasVertex(T vertex) {
        return adjList.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(T v1, T v2) {
        if(!hasVertex(v1))
            return false;
        SinglyLinkedList v1edges = adjList.get(v1);
        return v1edges.search(v2) != null;
    }

    @Override
    public ArrayList<T> getVertices() {
        ArrayList<T> array = new ArrayList<>(adjList.size());
        adjList.forEach((k,v) -> array.add(k));
        return array;
    }

    @Override
    public ArrayList<T> getAdjacentVertices(T vertex) {
        if(!adjList.containsKey(vertex))
            return null;
        ArrayList<T> array = new ArrayList<>();
        SinglyLinkedList adjVert = adjList.get(vertex);
        return adjVert.toArrayList();
    }

    @Override
    public double getWeightOfEdge(T v1, T v2) {
        SinglyLinkedList sll = adjList.get(v1);
        Edge edge = sll.search(v2);

        return edge != null ? edge.weight : Double.MIN_VALUE;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public int getTotalVertices() {
        return adjList.size();
    }

    @Override
    public int getTotalEdges() {
        return totalEdges;
    }

    @Override
    public boolean removeVertex(T vertex) {
        if(!adjList.containsKey(vertex)) return false;
        SinglyLinkedList adjVert = adjList.get(vertex);
        if(graphType == GraphType.UNDIRECTED) {
            Edge e = adjVert.head;
            while(e != null) {
                removeEdge(e.destination, vertex);
                e = e.next;
            }
        }
        if(graphType == GraphType.DIRECTED) totalEdges = totalEdges - adjVert.size;
        adjList.remove(vertex);
        return true;
    }

    @Override
    public boolean removeEdge(T v1, T v2) {
        if(!adjList.containsKey(v1)) return false;
        SinglyLinkedList adjVert = adjList.get(v1);
        if(graphType == GraphType.UNDIRECTED) {
            SinglyLinkedList adjVert2 = adjList.get(v2);
            adjVert2.remove(v1);
        }
        totalEdges = totalEdges - 1;
        return adjVert.remove(v2);
        
    }
    
    @Override
    public GraphType getGraphType() {
        return graphType;
    }
}
