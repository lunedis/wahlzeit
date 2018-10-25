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
