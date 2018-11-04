package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.handlers.*;
import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;
import org.wahlzeit.services.*;
import org.wahlzeit.utils.*;

/**
 * Test suite for all wahlzeit tests
 * @see: <a href="http://home.edvsz.fh-osnabrueck.de/skleuker/CSI/Werkzeuge/Junit/Junit4.4/TestSuites/TestSuiteDoku.html">TestSuiteDoku Uni Osnabrück</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TellFriendTest.class,
        DatastoreAdapterTest.class,
        AccessRightsTest.class,
        CoordinateTest.class,
        FlagReasonTest.class,
        GenderTest.class,
        GuestTest.class,
        PhotoFilterTest.class,
        TagsTest.class,
        UserStatusTest.class,
        ValueTest.class,
        LogBuilderTest.class,
        EmailServiceTestSuite.class,
        StringUtilTest.class,
        VersionTest.class})
public class AllTests { }