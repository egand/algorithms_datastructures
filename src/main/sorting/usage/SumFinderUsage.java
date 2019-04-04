package sorting.usage;

import sorting.SumFinder;

import java.io.IOException;
import java.util.ArrayList;

public class SumFinderUsage {

    public static void main(String[] args) throws Exception {
        if(args.length < 1) throw new Exception("Usage: java SumFinderUsage <dataset_file_path> <numToFind_file_path>\n");

        ArrayList<Long> numToFind = null;
        ArrayList<Long> array = null;
        System.out.println("Loading data from file");
        try {
            array = Utils.loadArrayListFromFile(args[0],20000000);
            numToFind = Utils.loadArrayListFromFile(args[1], 11);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Data loaded successfully");
        for(Long num: numToFind) {
            long start = System.nanoTime();
            long[] found = SumFinder.findSum(array, num);
            long end = System.nanoTime();
            double timeInSec = (end - start)/1000000000.0;
            if(found != null) System.out.println("Found sum for the number: " + num + " in " + timeInSec+ "s" + "\nn1 = " + found[0] + ", n2 = " + found[1]);
            else System.out.println("Sum not found for number: " + num + " - Time taken: " + timeInSec + "s");
        }
    }
}
