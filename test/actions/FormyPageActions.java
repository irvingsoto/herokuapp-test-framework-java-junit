package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.FormyPage;

public class FormyPageActions {

    protected WebDriver driver = null;
    FormyPage formyPage = null;

    public FormyPageActions (WebDriver driver){

        this.driver = driver;
        formyPage = new FormyPage(driver);

    }

    public void setForm1(String firstName){

        formyPage.getForm1().sendKeys(firstName);
    }




}
