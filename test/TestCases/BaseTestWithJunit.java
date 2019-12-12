package TestCases;

import actions.FormyPageActions;
import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

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

        driver.findElement(By.linkText("Submit")).click();
        //Step 2.- Set First Name
        System.out.println("Step 3.- Validate form is submitted");
        formyPage.validateConfirmation();








    }

    @After
    public void tearDown() {

        afterClass(testCaseName);
    }

}
