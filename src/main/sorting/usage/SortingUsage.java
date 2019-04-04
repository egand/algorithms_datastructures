package sorting.usage;

import comparators.LongComparator;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.SortingAlgorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SortingUsage {

    public static void main(String[] args) throws Exception {

        if(args.length < 1) throw new Exception("Usage: java SortingUsage <dataset_file_path>\n");

        ArrayList<Long> array = null;
        System.out.println("Loading data from file");
        try {
            array = Utils.loadArrayListFromFile(args[0], 20000000);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Data loaded successfully");

        Scanner reader = new Scanner(System.in);

        int command;
        System.out.println("(1) Merge sort\n(2) Insertion sort\n\nWhich algorithm do you want to use?");
        command = reader.nextInt();

        switch(command) {
            case 1:
                sortArrayList(new MergeSort<>(new LongComparator()), array);
                break;
            case 2:
                sortArrayList(new InsertionSort<>(new LongComparator()), array);
                break;
            default:
                throw new Exception("Use 1 or 2 accordingly to the instructions");
        }



    }

    private static void sortArrayList(SortingAlgorithm<Long> sorter, ArrayList<Long> array) {

        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double seconds = (double)elapsedTime / 1000000000.0;
        System.out.println("The time taken by the sorting algorithm to sort the array is " + elapsedTime + "ns (" + seconds + "s)\n");
    }
}
