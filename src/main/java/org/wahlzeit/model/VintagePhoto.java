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

import java.util.Calendar;
import java.util.logging.Logger;

public class VintagePhoto extends Photo {

    private static final Logger log = Logger.getLogger(VintagePhoto.class.getName());

    private String brand = "BMW";
    private String model = "E9 3.0 CSL";
    private int year = 1971;

    /**
     * @methodtype get
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @methodtype set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @methodtype get
     */
    public String getModel() {
        return model;
    }

    /**
     * @methodtype set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @methodtype get
     */
    public int getYear() {
        return year;
    }

    /**
     * @methodtype set
     * @throws IllegalArgumentException
     */
    public void setYear(int year) throws IllegalArgumentException {
        if(year > Calendar.getInstance().get(Calendar.YEAR)) {
            throw new IllegalArgumentException("Year cannot be in the future.");
        }
        this.year = year;
    }

    /**
     * @methodtype constructor
     */
    public VintagePhoto(String brand, String model, int year) {
        super();
        setBrand(brand);
        setModel(model);
        setYear(year);
    }

    /**
     * @methodtype constructor
     */
    public VintagePhoto(PhotoId id, String brand, String model, int year) {
        super(id);
        setBrand(brand);
        setModel(model);
        setYear(year);
    }

    /**
     * @methodtype constructor
     */
    public VintagePhoto() {
        super();
    }

    /**
     * @methodtype constructor
     */
    public VintagePhoto(PhotoId id) {
        super(id);
        log.info("VintagePhoto class instantiated");
    }
}
