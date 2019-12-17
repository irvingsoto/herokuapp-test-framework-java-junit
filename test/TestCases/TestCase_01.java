package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ExcelUtil;

import java.util.Map;

public class TestCase_01 {

    public static void main(String[] args) {

        Map <String, String> configData = ExcelUtil.getSpecifySheet(".\\test\\data\\data.xls", "Config", "config");
        Map <String, String> testData = ExcelUtil.getSpecifySheet(".\\test\\data\\data.xls", "TestData", "TestCase_01");

        //Initialize Driver
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(configData.get("URL"));
        driver.findElement(By.id("first-name")).sendKeys(testData.get("First_name"));
        driver.findElement(By.id("last-name")).sendKeys(testData.get("LastName"));

        driver.findElement(By.id(testData.get("Radiobttn"))).click();

        System.out.println(testData.get("Radiobttn"));



    }

}
