package graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SparseWeightedGraphTest {

    private SparseWeightedGraph<Integer> ugraph;
    private SparseWeightedGraph<Integer> dgraph;


    @Before
    public void setUp() throws Exception {
        ugraph = new SparseWeightedGraph<>(WeightedGraph.GraphType.UNDIRECTED);
        dgraph = new SparseWeightedGraph<>(WeightedGraph.GraphType.DIRECTED);
    }

    @Test
    public void addVertex() {
        assertTrue(ugraph.addVertex(5));
    }

    @Test
    public void addExistingVertex() {
        ugraph.addVertex(5);
        assertFalse(ugraph.addVertex(5));
    }

    @Test
    public void addEdge() {
        ugraph.addEdge(5,2,3.0);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        assertEquals(expected,ugraph.getAdjacentVertices(5));

    }

    @Test
    public void addExistingEdge() {
        ugraph.addEdge(5,2,3.0);
        int expected = ugraph.getTotalEdges();
        ugraph.addEdge(5,2,3.0);
        assertEquals(expected, ugraph.getTotalEdges());
    }

    @Test
    public void addMultipleExistingEdges() {
        ugraph.addEdge(5,2,3.0);
        ugraph.addEdge(5,3,3.0);
        ugraph.addEdge(5,4,3.0);
        ugraph.addEdge(4,5,3.0);
        ugraph.addEdge(2,5,3.0);
        ugraph.addEdge(8,5,3.0);
        assertEquals(4, ugraph.getTotalEdges());
    }

    @Test
    public void hasVertex() {
        ugraph.addVertex(5);
        assertTrue(ugraph.hasVertex(5));
    }

    @Test
    public void hasEdge() {
        ugraph.addEdge(5,2,3.0);
        assertTrue(ugraph.hasEdge(5,2));
    }

    @Test
    public void graphWeight() {
        ugraph.addEdge(5,2,3.0);
        assertEquals(3.0, ugraph.getTotalWeight(),0.0001);
    }

    @Test
    public void graphWeighComparison() {
        ugraph.addEdge(5,2,3.0);
        dgraph.addEdge(5,2,3.0);
        assertEquals(dgraph.getTotalWeight(), ugraph.getTotalWeight(),0.0001);
    }

    @Test
    public void graphEdgeComparison() {
        ugraph.addEdge(5,2,3.0);
        dgraph.addEdge(5,2,3.0);
        assertEquals(dgraph.getTotalEdges(), ugraph.getTotalEdges());
    }

    @Test
    public void removeEdgeDGraph() {
        dgraph.addEdge(5,3,2.0);
        dgraph.removeEdge(5,3);
        assertEquals(0, dgraph.getTotalEdges());
    }

    @Test
    public void removeEdgeUGraph() {
        ugraph.addEdge(5,3,2.0);
        ugraph.removeEdge(5,3);
        assertEquals(0, ugraph.getTotalEdges());
    }

    @Test
    public void removeUndefinedEdge() {
        assertFalse(dgraph.removeEdge(5,3));
    }

    @Test
    public void removeVertexDGraph() {
        dgraph.addEdge(5,3,2.0);
        dgraph.removeVertex(5);
        assertEquals(1, dgraph.getTotalVertices());
    }

    @Test
    public void removeVertexUGraphEnsureEdgeRemoved() {
        dgraph.addEdge(5,3,2.0);
        dgraph.removeVertex(5);
        assertFalse(dgraph.hasEdge(3,5));
    }

    @Test
    public void removeUndefinedVertex() {
        assertFalse(dgraph.removeVertex(5));
    }
}