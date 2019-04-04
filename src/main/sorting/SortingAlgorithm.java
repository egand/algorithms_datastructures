package sorting;

import java.util.ArrayList;

public interface SortingAlgorithm<T> {

    /**
     * Sorts the given array
     * @param array The array to be sorted
     */
    void sort(ArrayList<T> array);
}