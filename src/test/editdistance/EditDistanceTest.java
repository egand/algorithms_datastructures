package editdistance;

import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

    @Test
    public void testEditDistanceRec() {
        assertEquals(2,EditDistance.editDistanceRec("casa","cara"));
    }

    @Test
    public void testEditDistanceRecZeroDistance() {
        assertEquals(0,EditDistance.editDistanceRec("pioppo","pioppo"));
    }

    @Test
    public void testEditDistanceRecEmptyString() {
        assertEquals(0,EditDistance.editDistanceRec("",""));
    }

    @Test
    public void testEditDistanceRecAllDiff() {
        assertEquals(14,EditDistance.editDistanceRec("aaaaaaa","bbbbbbb"));
    }

    @Test
    public void testEditDistanceDyn() {
        assertEquals(2,EditDistance.editDistanceDyn("casa","cara"));
    }

    @Test
    public void testEditDistanceDynZeroDistance() {
        assertEquals(0,EditDistance.editDistanceDyn("pioppo","pioppo"));
    }

    @Test
    public void testEditDistanceDynEmptyString() {
        assertEquals(0,EditDistance.editDistanceDyn("",""));
    }

    @Test
    public void testEditDistanceDynAllDiff() {
        assertEquals(14,EditDistance.editDistanceDyn("aaaaaaa","bbbbbbb"));
    }


}