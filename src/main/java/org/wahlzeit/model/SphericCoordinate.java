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

public class SphericCoordinate extends AbstractCoordinate {
    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        setPhi(phi);
        setTheta(theta);
        setRadius(radius);
    }

    public SphericCoordinate(Coordinate coordinate) {
        assertClassInvariants();
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        this.phi = sphericCoordinate.getPhi();
        this.theta = sphericCoordinate.getTheta();
        this.radius = sphericCoordinate.getRadius();
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        assertValidPhi(phi);
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        assertValidTheta(theta);
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        assertValidRadius(radius);
        this.radius = radius;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        return new CartesianCoordinate(
                radius * Math.sin(theta) * Math.cos(phi),
                radius * Math.sin(theta) * Math.sin(phi),
                radius * Math.cos(theta)
        );
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    protected void assertClassInvariants() {
        assertValidPhi(phi);
        assertValidTheta(theta);
        assertValidRadius(radius);
    }

    private void assertValidRadius(double radius) {
        assert(Double.isFinite(radius));
        assert(!Double.isNaN(radius));
        assert(radius >= 0);
    }

    private void assertValidPhi(double phi) {
        assertValidAngle(phi);
    }

    private void assertValidTheta(double theta) {
        assertValidAngle(theta);
    }

    private void assertValidAngle(double angle) {
        assert(!Double.isNaN(angle));
        assert(Double.isFinite(angle));
        assert(Math.abs(angle) < (Math.PI * 2));
    }
}
