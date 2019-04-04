package sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public abstract class AbstractSortingTest {

    private SortingAlgorithm<Integer> sorter;
    private ArrayList<Integer> test, expected;

    @Before
    public void setUp() {
        test = new ArrayList<>();
        expected = new ArrayList<>();
        sorter = getSortingAlgorithm();
    }

    protected abstract SortingAlgorithm<Integer> getSortingAlgorithm();


    @Test
    public void testSortEmptyArray() {
        sorter.sort(test);
        assertEquals(expected,test);
    }


    @Test
    public void testSortOneElemArray() {
        Collections.addAll(test, 1);
        Collections.addAll(expected, 1);
        sorter.sort(test);
        assertEquals(expected,test);

    }


    @Test
    public void testSortArray() {
        Collections.addAll(test, 5,9,2,12,40,3);
        Collections.addAll(expected,2,3,5,9,12,40);
        sorter.sort(test);
        assertEquals(expected,test);
    }


    @Test
    public void testSortReversedArray() {
        Collections.addAll(test, 20,18,15,7,3,0);
        Collections.addAll(expected, 0,3,7,15,18,20);
        sorter.sort(test);
        assertEquals(expected,test);
    }


    @Test
    public void testSortSortedArray() {
        Collections.addAll(test, 1,3,7,9,10);
        Collections.addAll(expected, 1,3,7,9,10);
        sorter.sort(test);
        assertEquals(expected, test);
    }


    @Test
    public void testSortRepeatedElemArray() {
        Collections.addAll(test, 3,3,3,3,3,8,8,5);
        Collections.addAll(expected, 3,3,3,3,3,5,8,8);
        sorter.sort(test);
        assertEquals(expected,test);
    }


    @Test
    public void testSortRelativeNumArray() {
        Collections.addAll(test, -5,3,-27,12,0);
        Collections.addAll(expected, -27,-5,0,3,12);
        sorter.sort(test);
        assertEquals(expected,test);
    }
}
