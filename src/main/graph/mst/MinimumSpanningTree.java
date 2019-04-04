package graph.mst;

import graph.WeightedGraph;

/**
 * Interface of a minimum spanning tree
 * @param <T>
 */
public interface MinimumSpanningTree<T> {

    /**
     * Returns the minimum spanning tree of the given graph
     * @param graph The graph used to create the minimum spanning tree
     * @return A minimum spanning tree
     */
    WeightedGraph<T> mst(WeightedGraph<T> graph);
}
