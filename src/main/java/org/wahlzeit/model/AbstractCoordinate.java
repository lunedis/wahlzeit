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

public abstract class AbstractCoordinate implements Coordinate {

    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        CartesianCoordinate me = this.asCartesianCoordinate();
        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();

        return Math.sqrt(
                Math.pow(otherCoordinate.getX() - me.getX(), 2) +
                        Math.pow(otherCoordinate.getY() - me.getY(), 2) +
                        Math.pow(otherCoordinate.getZ() - me.getZ(), 2)
        );
    }

    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate me = this.asSphericCoordinate();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        return Math.acos(
                Math.sin(me.getPhi()) * Math.sin(sphericCoordinate.getPhi()) +
                        Math.cos(me.getPhi()) * Math.cos(me.getPhi()) * Math.cos(Math.abs(sphericCoordinate.getTheta() - me.getTheta()))
        );
    }


    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        final double EPSILON = 0.000001;

        CartesianCoordinate me = coordinate.asCartesianCoordinate();
        CartesianCoordinate otherCoordinate = coordinate.asCartesianCoordinate();

        return Math.abs(otherCoordinate.getX() - me.getX()) < EPSILON &&
                Math.abs(otherCoordinate.getY() - me.getY()) < EPSILON &&
                Math.abs(otherCoordinate.getZ() - me.getZ()) < EPSILON;
    }


    @Override
    public abstract CartesianCoordinate asCartesianCoordinate();

    @Override
    public abstract SphericCoordinate asSphericCoordinate();
}
