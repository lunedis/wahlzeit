/*
 * Copyright (c) 2018 by Karl Werner
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 *
 */

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
