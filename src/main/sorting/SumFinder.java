package sorting;

import comparators.IntegerComparator;
import comparators.LongComparator;

import java.util.ArrayList;

public class SumFinder {

    /**
     * Search in the arrayList if there are 2 elements which sum equals the given value sum
     * @param arrayList Array containing the elements to search
     * @param sum Value of the sum of a pair of integers
     * @return An array containing the pair of numbers which sum equals the given value sum,
     * or null if there aren't any
     */
    public static long[] findSum(ArrayList<Long> arrayList, long sum) {
        long[] found = new long[2];
        if(arrayList != null && arrayList.size() > 0) {
            SortingAlgorithm<Long> sorter = new MergeSort<>(new LongComparator());
            sorter.sort(arrayList);

            int left = 0, right = arrayList.size() -1;
            while(left < right) {

                if(arrayList.get(left) + arrayList.get(right) == sum) {
                    found[0] = arrayList.get(left);
                    found[1] = arrayList.get(right);
                    return found;
                }

                else if(arrayList.get(left) + arrayList.get(right) < sum)
                    left++;

                else right--;
            }
        }
        return null;
    }
}
