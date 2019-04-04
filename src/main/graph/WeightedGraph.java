package graph;

import java.util.ArrayList;

/**
 * Interface of a generic weighted graph.
 * The weighted graph can store vertex and edges, where the latter have weights or values.
 * @param <T>
 */
public interface WeightedGraph<T> {
    /**
     * The GraphType constants are used to create a graph directed or undirected.
     * In an undirected graph, the adjacency relation is symmetrical,
     * so for example given 2 vertex A and D, A -> D and D -> A are the same edge
     */
    enum GraphType {DIRECTED, UNDIRECTED}

    /**
     * Insert the specified vertex into the graph
     * @param vertex The vertex to be inserted
     * @return True if the vertex wasn't already inserted before
     */
    boolean addVertex(T vertex);

    /**
     * Insert the specified weighted edge into the graph.
     * If the specified weighted edge exists, it won't be inserted
     * @param v1 The vertex where the edge begins
     * @param v2 The vertex where the edge ends
     * @param weight The weight of the Edge
     * @return True
     */
    boolean addEdge(T v1, T v2, double weight);

    /**
     * Check if the specified vertex is into the weighted graph
     * @param vertex The vertex to search
     * @return True if the vertex is into the weighted graph
     */
    boolean hasVertex(T vertex);

    /**
     * Check if the specified edge is into the weighted graph
     * @param v1 The vertex where the edge begins
     * @param v2 The vertex where the edge ends
     * @return True if the edge is into the weighted graph
     */
    boolean hasEdge(T v1, T v2);

    /**
     * Returns an arrayList containing all the weighted graph's vertices
     * @return An arrayList containing all the weighted graph's vertices
     */
    ArrayList<T> getVertices();

    /**
     * Returns an arrayList containing all the adjacent vertices of vertex
     * @param vertex The vertex from which to look for its adjacent vertices
     * @return An arrayList containing all the adjacent vertices of vertex
     */
    ArrayList<T> getAdjacentVertices(T vertex);

    /**
     * Returns the weight of the specified edge
     * @param v1 The vertex where the edge begins
     * @param v2 The vertex where the edge ends
     * @return The weight of the specified edge
     */
    double getWeightOfEdge(T v1, T v2);

    /**
     * Return the graph's total weight
     * @return The graph's total weight
     */
    double getTotalWeight();

    /**
     * Returns the number of vertices stored into the graph
     * @return The number of vertices stored into the graph
     */
    int getTotalVertices();

    /**
     * Returns the number of edges stored into the graph
     * @return The number of edges stored into the graph
     */
    int getTotalEdges();

    /**
     * Remove the specified vertex from the graph
     * @param vertex The specified vertex to remove
     * @return True if the specified vertex is found and removed
     */
    boolean removeVertex(T vertex);

    /**
     * Remove the specified edge from the graph
     * @param v1 The vertex where the edge begins
     * @param v2 The vertex where the edge ends
     * @return True if the specified edge is found and removed
     */
    boolean removeEdge(T v1, T v2);

    /**
     * Returns the type of the graph
     * @return The type of the graph
     */
    GraphType getGraphType();
}
