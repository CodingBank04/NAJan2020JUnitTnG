package main.java.testngclasses;

import main.java.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TNG_Dependency {
    static WebDriver driver;
    static String baseUrl;
    static Actions action; // create an object of type Actions class

    @BeforeClass //similar to @BeforeAll in junit
    public void setUP() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver); // initializing the actions class object by passing driver object to Actions class constructor
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeClass - initiated and navigated to web page");
    }

    @AfterClass //similar to @AfterAll in junit
    public void tearDown() throws IOException {
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir")+"\\src\\snippets\\"+rString.genRandom(5)+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(5000);
        WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums = driver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hovSupport).perform(); // to hover on a given WebElement
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform(); // to click on a given WebElement
        // action.click(forums).perform();// to click on a given WebElement

        Thread.sleep(5000);
        String currUrl = driver.getCurrentUrl();
        Assert.assertEquals(currUrl, "https://forum.jquery.com/","url mismatch!!!");
        System.out.println("@Test1 - currUrl is:"+currUrl);
    }

    @Test(dependsOnMethods = {"test1"}, enabled = false)
    public void test2() {
        WebElement getStarted = driver.findElement(By.xpath("//a[text()='Getting Started']"));
        getStarted.click();
        System.out.println("@Test2 method");
        Assert.assertTrue(driver.getCurrentUrl().contains("getting-started1"));
    }

    @Test(dependsOnMethods = {"test1"}, timeOut = 1000)
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Class1 - @Test3 method");
    }
}
