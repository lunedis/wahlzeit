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

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public CartesianCoordinate(Coordinate coordinate) {
        CartesianCoordinate cartesianCoordinate = coordinate.asCartesianCoordinate();
        this.x = cartesianCoordinate.getX();
        this.y = cartesianCoordinate.getY();
        this.z = cartesianCoordinate.getZ();
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

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(x,2) + Math.pow(y, 2) + Math.pow(z,2));
        return new SphericCoordinate(
                Math.atan(y / x),
                Math.acos(z / radius),
                radius
        );
    }
}
