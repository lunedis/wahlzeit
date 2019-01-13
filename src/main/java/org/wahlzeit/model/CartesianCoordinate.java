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

import org.wahlzeit.utils.PatternInstance;

import java.util.HashMap;

@PatternInstance(
    patternName = "Value Object",
    participants = {
        "CartesianCoordinate"
    }
)
public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    protected final static HashMap<Integer, CartesianCoordinate> instances = new HashMap<Integer, CartesianCoordinate>();

    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariants();
        return this;
    }

    /**
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        double radius = Math.sqrt(Math.pow(x,2) + Math.pow(y, 2) + Math.pow(z,2));
        return SphericCoordinate.create(
                Math.atan(y / x),
                Math.acos(z / radius),
                radius
        );
    }

    @Override
    protected void assertClassInvariants() {
        assertValidDouble(x);
        assertValidDouble(y);
        assertValidDouble(z);
    }

    private void assertValidDouble(double d) {
        assert(!Double.isNaN(d));
        assert(Double.isFinite(d));
    }

    public static CartesianCoordinate create(double x, double y, double z) {
        int hash = hash(x,y,z);
        if(instances.containsKey(hash)) {
            return instances.get(hash);
        } else {
            CartesianCoordinate coordinate = new CartesianCoordinate(x,y,z);
            instances.put(hash, coordinate);
            return coordinate;
        }
    }
}
