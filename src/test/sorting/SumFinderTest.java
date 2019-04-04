package sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class SumFinderTest {

    private ArrayList<Long> arrayList;

    @Before
    public void setUp() {
        arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 8L,16L,4L,5L,0L,-5L);
    }

    @Test
    public void testFindSumFound() {
        assertNotNull(SumFinder.findSum(arrayList,8));
    }

    @Test
    public void testFindSumNull() {
        assertNull(SumFinder.findSum(arrayList,7));
    }
}