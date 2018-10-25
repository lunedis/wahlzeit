package org.wahlzeit.model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Test cases for the Coordinate class
 */
public class CoordinateTest {

    @Test
    public void testDistance() {
        Coordinate c1 = new Coordinate(2.0, 3.0, -1.0);
        Coordinate c2 = new Coordinate(4.0, 1.0, -2.0);

        double distance = c1.getDistance(c2);
        assertEquals(distance, 3.0);
    }

    @Test
    public void testEquals() {
        Coordinate c1 = new Coordinate(4.0, 3.0, 25.0);
        Coordinate c2 = new Coordinate(4.0, 3.0, 25.0);

        assertTrue(c2.equals(c1));
        assertTrue(c1.equals(c2));
        assertTrue(c2.isEqual(c1));
        assertTrue(c1.isEqual(c2));
    }
}
