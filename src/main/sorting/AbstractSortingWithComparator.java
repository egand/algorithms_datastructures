package sorting;

import java.util.Comparator;

public abstract class AbstractSortingWithComparator<T> implements SortingAlgorithm<T> {

    /**
     * Object used to compare two T objects.
     */
    protected Comparator<T> comparator;

    /**
     *
     * @param comparator The object to be used to compare two elements of the array
     */
    protected AbstractSortingWithComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Set a new comparator of type T
     * @param comparator The new comparator to use
     */
    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }


}
