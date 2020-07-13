package main.java.testngclasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import main.java.listeners.CustomITestListener1;
import main.java.listeners.CustomListener1;
import main.java.listeners.CustomSuiteListener1;
import main.java.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners({CustomITestListener1.class, CustomListener1.class, CustomSuiteListener1.class})
public class TNG_Extent {

    WebDriver driver;
    String baseUrl;
    ExtentReports report;
    ExtentTest eTest;

    @BeforeTest
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        report = new ExtentReports("C:\\IJProjs\\NAAutoBoot\\src\\main\\java\\reports\\ereport.html");
        eTest = report.startTest("Reporter Demo");
        eTest.log(LogStatus.INFO, "Test started...");

        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        eTest.log(LogStatus.INFO, "Opened browser, maximized...");
    }

    @AfterTest
    public void tearDown() throws IOException {
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir")+"\\src\\snippets\\"+rString.genRandom(5)+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        String imgPath = eTest.addScreenCapture(fileNm);
        eTest.log(LogStatus.ERROR, "some error screenshot", imgPath);

        driver.quit();
        report.endTest(eTest);
        report.flush();

    }

    //  @AfterTest
    public void navBack() {
        driver.navigate().back();
    }

    @Parameters({"linknm"})
    @Test
    public void eventsTest(String linknm) {
        eTest.log(LogStatus.INFO, "inside eventsTest");
        WebElement desiredLink = driver.findElement(By.linkText(linknm));
        desiredLink.click();
        String currUrl = driver.getCurrentUrl();
        if (linknm.equals("Events")) {
            Assert.assertEquals(currUrl, "https://openjsf.org/");
        } else {
            Assert.assertEquals(currUrl, "https://plugins.jquery.com/");
        }
        eTest.log(LogStatus.PASS, "eventsTest: PASS");
    }

    @Parameters({"linknm"})
    @Test
    public void insideValidations(String clickLink) {
        eTest.log(LogStatus.INFO, "insideValidations");
        WebElement logo, headerText;
        if (clickLink.equals("Events")) {
            logo = driver.findElement(By.xpath("//img[@alt='OpenJS Foundation']/parent::a"));
        } else {
            logo = driver.findElement(By.linkText("jQuery Plugin Registry"));
        }
        logo.click();

        if (clickLink.equals("Events")) {
            headerText = driver.findElement(By.xpath("//div[contains(@class, 'instance-1')]//div[@class='nectar-gradient-text']/h3"));
            Assert.assertTrue(headerText.getText().equals("Welcome Electron!"));
            eTest.log(LogStatus.PASS, "insideValidations PASS");
        } else {
            headerText = driver.findElement(By.cssSelector("#banner-secondary>h1"));
            Assert.assertTrue(headerText.getText().equals("The jQuery Plugin Registry"));
            eTest.log(LogStatus.PASS, "insideValidations PASS");
        }
    }

}
