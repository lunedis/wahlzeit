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

import java.util.Objects;

public class Coordinate {
    protected double x;
    protected double y;
    protected double z;

    public Coordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean isEqual(Coordinate otherCoordinate) {
        return Double.compare(otherCoordinate.x, x) == 0 &&
            Double.compare(otherCoordinate.y, y) == 0 &&
            Double.compare(otherCoordinate.z, z) == 0;
    }

    /**
     * Calculates the cartesian distance between two coordinates
     */
    public double getDistance(Coordinate otherCoordinate) {
        return Math.sqrt(
                Math.pow(otherCoordinate.x - x, 2) +
                Math.pow(otherCoordinate.y - y, 2) +
                Math.pow(otherCoordinate.z - z, 2)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return this.isEqual(that);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);
    }



    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
