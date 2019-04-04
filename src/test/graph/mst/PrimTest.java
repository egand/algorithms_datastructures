package graph.mst;

import graph.WeightedGraph;
import graph.SparseWeightedGraph;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimTest {
    private SparseWeightedGraph<String> sparseGraph;
    private Prim<String> prim;

    @Before
    public void setUp() throws Exception {
        prim = new Prim<>();
        sparseGraph = new SparseWeightedGraph<>(WeightedGraph.GraphType.UNDIRECTED);
        sparseGraph.addEdge("a","b",5.0);
        sparseGraph.addEdge("a","c",9.0);
        sparseGraph.addEdge("b","c",7.0);
        sparseGraph.addEdge("b","g",6.0);
        sparseGraph.addEdge("b","e",15.0);
        sparseGraph.addEdge("b","c",7.0);
        sparseGraph.addEdge("c","e",7.0);
        sparseGraph.addEdge("c","d",8.0);
        sparseGraph.addEdge("d","e",5.0);
        sparseGraph.addEdge("e","g",8.0);
        sparseGraph.addEdge("e","f",11.0);
        sparseGraph.addEdge("f","g",9.0);
    }

    @Test
    public void mstWeight() {
        WeightedGraph<String> actual = prim.mst(sparseGraph);
        assertEquals(39.0, actual.getTotalWeight(), 0.001);
    }

    @Test
    public void mstEdges() {
        WeightedGraph<String> actual = prim.mst(sparseGraph);
        assertEquals(6, actual.getTotalEdges());
    }

    @Test
    public void mstVertices() {
        WeightedGraph<String> actual = prim.mst(sparseGraph);
        assertEquals(7, actual.getTotalVertices());
    }

    @Test
    public void mstNoGraph() {
        assertNull(prim.mst(null));
    }

    @Test
    public void mstGraphEmpty() {
        SparseWeightedGraph<String> wg = new SparseWeightedGraph<>(WeightedGraph.GraphType.DIRECTED);
        assertEquals(0,prim.mst(wg).getTotalVertices());
    }
}