package graph.usage;

import graph.WeightedGraph;
import graph.SparseWeightedGraph;
import graph.mst.Prim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SparseGraphUsage {

    public static void main(String [] args) throws Exception {
        if(args.length < 1) throw new Exception("Usage: java SparseGraphUsage <data_filepath>\n");
        SparseWeightedGraph<String> graph = null;
        try {
            graph = loadGraphFromFile(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.printf("Graph loaded\nTotal weight: %.3f \n", graph.getTotalWeight() / 1000);
        System.out.println("Total vertices: " + graph.getTotalVertices());
        System.out.println("Total edges: " + graph.getTotalEdges() + "\n");

        Prim<String> prim = new Prim<>();
        long startTime = System.nanoTime();
        WeightedGraph<String> mstGraph = prim.mst(graph);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        double seconds = (double)time / 1000000000.0;
        System.out.println("Time taken by prim's algorithm: "  + seconds + "s");
        System.out.printf("Total weight: %.3f \n", mstGraph.getTotalWeight() / 1000);
        System.out.println("Total vertices: " + mstGraph.getTotalVertices());
        System.out.println("Total edges: " + mstGraph.getTotalEdges());

    }

    private static SparseWeightedGraph<String> loadGraphFromFile(String filepath) throws IOException {
        SparseWeightedGraph<String> graph = new SparseWeightedGraph<>(WeightedGraph.GraphType.UNDIRECTED);
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                graph.addEdge(temp[0],temp[1],Double.parseDouble(temp[2]));
            }
        }
        return graph;
    }
}
