package base;

import util.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;

public class TestBase {

    protected WebDriver driver;

    protected Map <String, String> configData = ExcelUtil.getSpecifySheet(".\\test\\data\\data.xls", "Config", "config");

    public void beforeClass(String driverType, String testCaseName) {

        System.out.println("Starting Test Case " + testCaseName);
        driver = getChromeDriver(driverType);
        driver.manage().window().maximize();
        driver.get(configData.get("URL"));
    }

        public WebDriver getChromeDriver(String driverType) {
            System.out.println("Initializing " + driverType);
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }

    public void afterClass(String testCaseName){

        System.out.println("End Of TestCase:  " + testCaseName);
        driver.quit();
    }


    //    public void initWebDriver(String driverType) {

    //      switch (driverType.trim()) {
    //        case "chrome":
    //          driver = getChromeDriver();
    //        break;
    //}
    //}
}

