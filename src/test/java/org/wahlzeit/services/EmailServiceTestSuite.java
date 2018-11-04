package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.services.mailing.EmailServiceTest;

/**
 * Test suite for all email related tests
 * @see: <a href="http://home.edvsz.fh-osnabrueck.de/skleuker/CSI/Werkzeuge/Junit/Junit4.4/TestSuites/TestSuiteDoku.html">TestSuiteDoku Uni Osnabrück</a>
 */
@RunWith(Suite.class)
@SuiteClasses({EmailAddressTest.class, EmailServiceTest.class})
public class EmailServiceTestSuite { }