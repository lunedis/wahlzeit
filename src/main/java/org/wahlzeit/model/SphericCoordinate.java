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

public class SphericCoordinate implements Coordinate {
    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public SphericCoordinate(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        this.phi = sphericCoordinate.getPhi();
        this.theta = sphericCoordinate.getTheta();
        this.radius = sphericCoordinate.getRadius();
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return new CartesianCoordinate(
                radius * Math.sin(theta) * Math.cos(phi),
                radius * Math.sin(theta) * Math.sin(phi),
                radius * Math.cos(theta)
        );
    }

    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        return Math.acos(
                Math.sin(phi) * Math.sin(sphericCoordinate.phi) +
                Math.cos(phi) * Math.cos(phi) * Math.cos(Math.abs(sphericCoordinate.theta - theta))
        );
    }

    /**
     * @param coordinate
     * @methodtype query
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        final double EPSILON = 0.000001;

        SphericCoordinate otherCoordinate = coordinate.asSphericCoordinate();

        return Math.abs(otherCoordinate.getPhi() - phi) < EPSILON &&
                Math.abs(otherCoordinate.getTheta() - theta) < EPSILON &&
                Math.abs(otherCoordinate.getRadius() - radius) < EPSILON;
    }
}
