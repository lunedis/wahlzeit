/*
 * Copyright (c) 2019 by Karl Werner
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
import java.util.Map;

public class VintageManager {
    private Map<Integer, Vintage> vintages = new HashMap<Integer, Vintage>();
    private Map<String, VintageType> vintageTypes = new HashMap<String, VintageType>();

    protected VintageManager() {
        super();
    }

    public Vintage createVintage(String type) {
        VintageType typeObject = vintageTypes.get(type);
        if (typeObject == null) {
            typeObject = new VintageType(this);
            vintageTypes.put(type, typeObject);
        }

        Vintage vintage = typeObject.createInstance();
        vintages.put(vintage.hashCode(), vintage);
        return vintage;
    }

}
