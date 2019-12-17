package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Map;
import org.apache.commons.io.FileUtils;

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

    public void takeSnapShot(String testCaseName) throws Exception{
    try {
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(".\\results\\"+ testCaseName +".png");

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
    catch (Exception e){
        System.out.println("Not possible to take SS " + e);
    }

    }

}


