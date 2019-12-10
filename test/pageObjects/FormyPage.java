package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormyPage {

    protected WebDriver driver;

    public FormyPage (WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getForm1(){

        return driver.findElement(By.id("first-name"));
    }
}
