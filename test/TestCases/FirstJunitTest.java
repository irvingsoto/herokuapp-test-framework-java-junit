package TestCases;

import base.TestBase;
import util.ExcelUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class FirstJunitTest extends TestBase {

    protected Map <String, String> configData = ExcelUtil.getSpecifySheet(".\\test\\data\\data.xls", "Config", "config");

    @Before
    public void beforeTest() {
        beforeClass("chrome" , this.getClass().getSimpleName());
    }

    @Test
    public void testMain() {

        System.out.println("Starting Test" + this.getClass().getSimpleName());
    }

    @After
    public void tearDown() {

        afterClass(this.getClass().getSimpleName());

    }

}
