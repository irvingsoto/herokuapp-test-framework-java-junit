package testRunner;

import TestCases.BaseTestWithJunit;
import TestCases.FirstJunitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            BaseTestWithJunit.class,
            FirstJunitTest.class
            })

    public class TestSuite {
}
