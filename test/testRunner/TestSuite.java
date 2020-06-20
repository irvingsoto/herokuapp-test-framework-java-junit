package testRunner;

import TestCases.TestCase_02;
import TestCases.FirstJunitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            TestCase_02.class,
            FirstJunitTest.class
            })

    public class TestSuite {
}
