package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

    public static void main(String[] args) {
        String path = "C:\\Users\\isoto\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();

        //Step 1.- Open app
        System.out.println("Step 1.- Open app");
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.linkText("Submit")).click();

    }

}
