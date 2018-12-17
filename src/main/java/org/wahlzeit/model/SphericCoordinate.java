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

import java.util.HashMap;
import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {
    private final double phi;
    private final double theta;
    private final double radius;

    protected final static HashMap<Integer, SphericCoordinate> instances = new HashMap<Integer, SphericCoordinate>();

    private SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
        assertClassInvariants();
    }

    public double getPhi() {
        return phi;
    }

    public double getTheta() {
        return theta;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        return CartesianCoordinate.create(
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

    public static SphericCoordinate create(double x, double y, double z) {
        int hash = hash(x,y,z);
        if(instances.containsKey(hash)) {
            return instances.get(hash);
        } else {
            SphericCoordinate coordinate = new SphericCoordinate(x,y,z);
            instances.put(hash, coordinate);
            return coordinate;
        }
    }
}
