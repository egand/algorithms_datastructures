package priorityqueue;

import comparators.IntegerComparator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class HeapPriorityQueueTest {

    private HeapPriorityQueue<Integer> pq;
    private ArrayList<Integer> actual;
    private ArrayList<Integer> expected;

    @Before
    public void setUp() throws Exception {
        pq = new HeapPriorityQueue<>(new IntegerComparator());
        actual = new ArrayList<>();
        expected = new ArrayList<>();
    }

    @Test
    public void insert() {
        pq.insert(5);
        assertEquals(1,pq.size());
    }

    @Test
    public void extractZeroEl() {
        assertNull(pq.extract());
    }

    @Test
    public void extractOneEl() {
        pq.insert(5);
        int expected = pq.extract();
        assertEquals(5, expected);
    }

    @Test
    public void extractTwoEl() {
        pq.insert(5);
        pq.insert(3);
        int expected = pq.extract();
        assertEquals(5, expected);
    }

    @Test
    public void peekZeroEl() {
        assertNull(pq.peek());
    }

    @Test
    public void peekOneEl() {
        pq.insert(5);
        int expected = pq.peek();
        assertEquals(5, expected);
    }

    @Test
    public void changePriorityGreater() {
        pq.insert(5);
        pq.changePriority(0,7);
        int expected = pq.extract();
        assertEquals(7, expected);
    }

    @Test
    public void changePriorityLess() {
        pq.insert(5);
        assertFalse(pq.changePriority(0,3));
    }


    @Test
    public void isEmptyZeroEl() {
        assertTrue(pq.isEmpty());
    }

    @Test
    public void isEmptyOneEl() {
        pq.insert(5);
        assertFalse(pq.isEmpty());
    }

    @Test
    public void isEmptyAfterExtract() {
        pq.insert(5);
        pq.extract();
        assertTrue(pq.isEmpty());
    }

    @Test
    public void sizeZeroEl() {
        assertEquals(0, pq.size());
    }

    @Test
    public void sizeOneEl() {
        pq.insert(5);
        assertEquals(1, pq.size());
    }

    @Test
    public void priorityQueueTest() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers,3,9,27,5,9,18);
        for(Integer number : numbers) {
            pq.insert(number);
        }

        Collections.addAll(expected,27,18,9,9,5,3);
        for(int i = pq.size(); i > 0; i--) {
            actual.add(pq.extract());
        }
        assertEquals(expected, actual);
    }

    @Test
    public void buildHeapFromArray() {
        ArrayList<Integer> array = new ArrayList<>();
        Collections.addAll(array, 8,2,5,220,4,1);
        HeapPriorityQueue<Integer> pq2 = new HeapPriorityQueue<>(new IntegerComparator(), array);
        Collections.addAll(expected, 220,8,5,4,2,1);
        for(int i = pq2.size(); i > 0; i--) {
            actual.add(pq2.extract());
        }
        assertEquals(expected,actual);
    }
}