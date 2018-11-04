/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
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
 */

package org.wahlzeit.services;

import junit.framework.TestCase;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	public static String[] validEmails = {"bingo@bongo", "bingo@bongo.com", "bingo.bongo@bongo.com", "bingo+bongo@bango.com"};

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google
		for(String validEmail : validEmails) {
			assertTrue(createEmailAddressIgnoreException(validEmail));
		}
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

	/**
	 * Test isEqual function on EmailAddress
	 */
	public void testEmailAdressEquals() {
	    for(String validEmail : validEmails) {
	        assertTrue(EmailAddress.getFromString(validEmail).isEqual(EmailAddress.getFromString(validEmail)));
        }
        assertTrue(EmailAddress.getFromString("").isEqual(EmailAddress.EMPTY));
	}

}

