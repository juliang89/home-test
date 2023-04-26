package POM.TestCases;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ LoginTest.class, CheckOutTest.class, GridTest.class, SearchTest.class })
public class AllTests {

}
