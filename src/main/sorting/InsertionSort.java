package sorting;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implements the Insertion Sort algorithm
 * @author Enrico Gandaglia
 * @param <T> Type of the array elements
 */
public class InsertionSort<T> extends AbstractSortingWithComparator<T> {

    public InsertionSort(Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(ArrayList<T> array) {
        for(int i = 1; i < array.size(); i++) {
            int j = i-1;
            T key = array.get(i);
            while(j >= 0 && comparator.compare(array.get(j), key) > 0) {
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1,key);

        }
    }

    
}