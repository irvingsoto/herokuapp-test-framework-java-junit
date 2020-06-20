package TestCases;

import actions.FormyPageActions;
import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestCase_02 extends TestBase {

    private String testCaseName = this.getClass().getSimpleName();

    @Before
    public void beforeTest() {

        beforeClass("chrome", testCaseName);
    }

    @Test
    public void testMain() throws Exception {

        FormyPageActions formyPage = new FormyPageActions (driver);

        //Step 1.- Oppen App
        System.out.println("Step 1.- Oppen App");
        formyPage.verifyApp();
        takeSnapShot(testCaseName+"1");
        //Step 2.- Set First Name
        System.out.println("Step 2.- Set First Name");
        formyPage.setFirstname("Irving");
        takeSnapShot(testCaseName+"2");
        driver.findElement(By.linkText("Submit")).click();
        //Step 3.- Set First Name
        System.out.println("Step 3.- Validate form is submitted");
        formyPage.validateConfirmation();
        takeSnapShot(testCaseName+"3");

    }

    @After
    public void tearDown() {

        afterClass(testCaseName);
    }

}
