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
 * Test cases for the CartesianCoordinate class
 */
public class CoordinateTest {

    @Test
    public void testCartesianDistance() {
        Coordinate c1 = new CartesianCoordinate(2.0, 3.0, -1.0);
        Coordinate c2 = new CartesianCoordinate(4.0, 1.0, -2.0);

        double distance = c1.getCartesianDistance(c2);
        assertEquals(distance, 3.0);
    }

    @Test
    public void testCartesianEquals() {
        Coordinate c1 = new CartesianCoordinate(4.0, 3.0, 25.0);
        Coordinate c2 = new CartesianCoordinate(4.0, 3.0, 25.0);

        assertTrue(c2.isEqual(c1));
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testSphericEquals() {
        Coordinate c1 = new SphericCoordinate(Math.PI, Math.PI / 2, 1.0);
        Coordinate c2 = new SphericCoordinate(Math.PI, Math.PI / 2, 1.0);

        assertTrue(c2.isEqual(c1));
        assertTrue(c1.isEqual(c2));
    }

    @Test
    public void testConversions() {
        Coordinate c1 = new CartesianCoordinate(1.0, 1.0, 0.0);
        Coordinate c2 = new CartesianCoordinate(5.0, -4.0, 2.0);
        assertTrue(c1.isEqual(c1.asSphericCoordinate().asCartesianCoordinate()));
        assertTrue(c2.isEqual(c2.asSphericCoordinate().asCartesianCoordinate()));

        Coordinate c3 = new SphericCoordinate(Math.PI / 3, Math.PI / 3, 1.0);
        Coordinate c4 = new SphericCoordinate(0.232181528, 0.8248124812, 22.0);
        assertTrue(c3.isEqual(c3.asCartesianCoordinate().asSphericCoordinate()));
        assertTrue(c4.isEqual(c4.asCartesianCoordinate().asSphericCoordinate()));
    }
}
