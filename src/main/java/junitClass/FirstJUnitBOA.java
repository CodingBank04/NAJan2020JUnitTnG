package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitBOA {

    static WebDriver driver;
    static String baseUrl;
    static JavascriptExecutor jse;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        jse = (JavascriptExecutor) driver;
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

     @Test
    public void test1() throws InterruptedException{
        Thread.sleep(10000);
         WebElement pass = driver.findElement(By.xpath("//input[@aria-labelledby='labelForpasscode1']"));
         jse.executeScript("arguments[0].value='tester1'",pass);
         Thread.sleep(5000);
        System.out.println("@Test1 - executed test");
    }

    @Test
    public void test2() {
        System.out.println("@Test2 - executed test");
    }

    @Test
    public void test3() {
        System.out.println("@Test3 - executed test");
    }

}
