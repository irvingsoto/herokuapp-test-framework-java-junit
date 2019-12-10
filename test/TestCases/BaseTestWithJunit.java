package TestCases;

import actions.FormyPageActions;
import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObjects.FormyPage;

public class BaseTestWithJunit extends TestBase {

    private String testCaseName = this.getClass().getSimpleName();

    @Before
    public void beforeTest() {

        beforeClass("chrome", testCaseName);
    }

    @Test
    public void testMain(){

        FormyPageActions formyPage = new FormyPageActions (driver);

        //Step 1.- Set First Name
        System.out.println("Step 1.- Set First Name");
        formyPage.setForm1("First Name");

    }

    @After
    public void tearDown() {

        //afterClass(testCaseName);
    }

}
