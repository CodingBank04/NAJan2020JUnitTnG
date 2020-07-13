package main.java.testngclasses;

import com.relevantcodes.extentreports.LogStatus;
import main.java.listeners.CustomITestListener1;
import main.java.listeners.CustomListener1;
import main.java.listeners.CustomSuiteListener1;
import main.java.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Listeners({CustomITestListener1.class, CustomListener1.class, CustomSuiteListener1.class})
public class TNG_Extent1 extends TNG_ExtentSuite {

    @Parameters({"linknm"})
    @BeforeClass
    public void beforeClass(String linknm) {
        report = ExtentFactory.getExTentInstance();
        eTest = report.startTest(linknm+":Extent1");
    }

    @AfterClass
    public void afterClass() {
        driver.navigate().back();
        report.endTest(eTest);
        report.flush();
    }

    @Parameters({"linknm"})
    @Test
    public void eventsTest(String linknm) {
        eTest.log(LogStatus.INFO, linknm + "inside eventsTest");
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
        eTest.log(LogStatus.INFO, clickLink + "insideValidations");
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

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir") + "\\src\\snippets\\" + rString.genRandom(5) + ".PNG";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        String imgPath = eTest.addScreenCapture(fileNm);

        if(result.getStatus() == ITestResult.FAILURE){
            eTest.log(LogStatus.FAIL, result.getName()+"==>Test method Failed: "+result.getThrowable(),imgPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            eTest.log(LogStatus.PASS, result.getName()+"==>Test method passed: "+result.getThrowable(),imgPath);
            eTest.log(LogStatus.INFO, eTest.addScreenCapture(fileNm)+"result.getName()"+"==>Test method passed");
        }
    }
}
