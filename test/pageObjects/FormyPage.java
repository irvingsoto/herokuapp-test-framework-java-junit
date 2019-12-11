package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormyPage {

    protected WebDriver driver;

    public FormyPage (WebDriver driver) {

        this.driver = driver;
    }

    public String getPageTitle(){ return driver.getTitle();  }

    public WebElement getHeader() { return driver.findElement(By.xpath("/html/body/div/h1")); }

    public WebElement getForm1(){ return driver.findElement(By.id("first-name")); }

    public  WebElement getConfirmMsj (){
        return(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div")));

    }

}
