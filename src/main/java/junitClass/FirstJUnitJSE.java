package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class FirstJUnitJSE {

    static WebDriver driver;
    static String baseUrl;
    static JavascriptExecutor jse;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.gecko.driver","C:\\IJProjs\\NAAutoBoot\\geckodriver.exe");
        driver = new FirefoxDriver();
       // driver.manage().window().maximize();
       // driver.get(baseUrl);

        jse = (JavascriptExecutor) driver;

        //window.location='<url>'
       // jse.executeScript("window.location='https://letskodeit.teachable.com/p/practice'");
        jse.executeScript("window.location=arguments[0]",baseUrl);

        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @Test
    public void clicking() throws InterruptedException {//replacement of driver click
        Thread.sleep(10000);
        WebElement checking = driver.findElement(By.xpath("//a[@aria-controls='navCheckingContent']"));
        jse.executeScript("arguments[0].click();",checking);
        System.out.println("@Test1 - executed test");
    }

    @Test
    public void sendingKeys() throws InterruptedException { // replacement of driver sendKeys
        WebElement onlineID = driver.findElement(By.xpath("//input[@aria-labelledby='labelForonlineId1']"));
        jse.executeScript("arguments[0].value='tester1'",onlineID);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].value=arguments[1]",onlineID," tester2");

        System.out.println("@Test2 - executed test");
    }

    @Test
    public void scrollBy() throws InterruptedException {
        Thread.sleep(10000);
        jse.executeScript("window.scrollBy(0,1800)"); //scroll down
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0,-1000)"); //scroll up
        Thread.sleep(5000);
        System.out.println("@Test3 - executed test");
    }

    @Test
    public void scrollView() throws InterruptedException {//scroll in to a given element view instead of hard coded x, y co-ordinate
        Thread.sleep(20000);
       // WebElement agree = driver.findElement(By.xpath("//a[text()='Online Banking Service Agreement']"));
        WebElement agree =
                (WebElement) jse.executeScript("return document.getElementById(arguments[0])","footer_bofa_online_banking_service_agreement");
        jse.executeScript("arguments[0].scrollIntoView(true)",agree);
    }

    @Test
    public void windowSize() throws InterruptedException { // returns window size
        Thread.sleep(20000);
        long height = (Long) jse.executeScript("return window.innerHeight");
        long width = (Long) jse.executeScript("return window.innerWidth");
        System.out.println("Window dimensions are:"+height+"x"+width);
        jse.executeScript("window.scrollBy(0,arguments[0])",height-150);
    }

}
