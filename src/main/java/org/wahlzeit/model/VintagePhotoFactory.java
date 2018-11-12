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

import org.wahlzeit.services.LogBuilder;

import java.util.logging.Logger;

public class VintagePhotoFactory extends PhotoFactory {
    private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    private static VintagePhotoFactory instance = null;

    /**
     *
     */
    protected VintagePhotoFactory() {
        // do nothing
    }

    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized VintagePhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new VintagePhotoFactory());
        }

        return instance;
    }

    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(VintagePhotoFactory vintagePhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }

        instance = vintagePhotoFactory;
    }

    /**
     * @methodtype factory
     */
    public Photo createPhoto() {
        return new VintagePhoto();
    }

    /**
     * Creates a new photo with the specified id
     */
    public Photo createPhoto(PhotoId id) {
        return new VintagePhoto(id);
    }
}
