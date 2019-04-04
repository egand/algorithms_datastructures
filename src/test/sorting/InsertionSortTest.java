package sorting;

import comparators.IntegerComparator;

public class InsertionSortTest extends AbstractSortingTest {


    @Override
    protected SortingAlgorithm<Integer> getSortingAlgorithm() {
        return new InsertionSort<Integer>(new IntegerComparator());
    }
}