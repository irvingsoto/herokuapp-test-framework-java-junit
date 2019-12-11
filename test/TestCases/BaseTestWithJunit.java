package TestCases;

import actions.FormyPageActions;
import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTestWithJunit extends TestBase {

    private String testCaseName = this.getClass().getSimpleName();

    @Before
    public void beforeTest() {

        beforeClass("chrome", testCaseName);
    }

    @Test
    public void testMain(){

        FormyPageActions formyPage = new FormyPageActions (driver);

        //Step 1.- Oppen App
        System.out.println("Step 1.- Oppen App");
        formyPage.verifyApp();
        //Step 2.- Set First Name
        System.out.println("Step 2.- Set First Name");
        formyPage.setFirstname("Irving");

    }

    @After
    public void tearDown() {

        afterClass(testCaseName);
    }

}
