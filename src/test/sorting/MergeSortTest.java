package sorting;

import comparators.IntegerComparator;

public class MergeSortTest extends AbstractSortingTest {
    @Override
    protected SortingAlgorithm<Integer> getSortingAlgorithm() {
        return new MergeSort<Integer>(new IntegerComparator());
    }
}
