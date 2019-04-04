package sorting;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implements the Merge Sort algorithm
 * @author Enrico Gandaglia
 * @param <T> type of the array elements
 */
public class MergeSort<T> extends AbstractSortingWithComparator<T> {

    public MergeSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(ArrayList<T> array) {
        mergeSort(array, 0, array.size() - 1);
    }

    private void mergeSort(ArrayList<T> array, int left, int right) {
        if(left < right) {
            int center = (left+right) / 2;
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);
            merge(array, left, center, right);
        }
    }

    private void merge(ArrayList<T> array, int left, int center, int right) {
        ArrayList<T> temp = new ArrayList<>(right - left + 1);
        int i = left, j = center + 1;

        while(i <= center && j <= right) {
            if(comparator.compare(array.get(i), array.get(j)) <= 0)
                temp.add(array.get(i++));
            else 
                temp.add(array.get(j++));
        }

        while(i <= center)
            temp.add(array.get(i++));

        while(j <= right)
            temp.add(array.get(j++));

        for(int k = left; k <= right; k++) {
            array.set(k,temp.get(k-left));
        }
    }


}