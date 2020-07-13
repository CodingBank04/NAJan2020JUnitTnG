package main.java.testngclasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TNG_ExtentSuite {

    static WebDriver driver;
    String baseUrl;
    static ExtentReports report;
    static ExtentTest eTest;

    @BeforeSuite
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        report = ExtentFactory.getExTentInstance();
        eTest = report.startTest("Reporter Demo");
        eTest.log(LogStatus.INFO, "Test started...");

        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        eTest.log(LogStatus.INFO, "Opened browser, maximized...");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        report.endTest(eTest);
        report.flush();

    }
}
