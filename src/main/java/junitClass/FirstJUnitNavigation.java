package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitNavigation {

    static WebDriver driver;
    static String baseUrl;
    static String currentUrl;
    static String pageTitle;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://letskodeit.teachable.com/";
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.navigate().to(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
        getTitleUrl(" - BeforeAll :");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void init() throws InterruptedException {
        driver.navigate().refresh();
        System.out.println("@BeforeEach - refreshed the page");
        Thread.sleep(5000);
        getTitleUrl(" - BeforeEach :");
    }

    @AfterEach
    public void done() throws InterruptedException {
        driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
        Thread.sleep(5000);
        getTitleUrl(" - AfterEach :");
    }

    @Test
    public void browserNavigation() throws InterruptedException {
        getTitleUrl(" - @browserNavigation - before clicking practice :");
        driver.findElement(By.xpath("//a[contains(text(),'Practice')]")).click();
        System.out.println("@Test1 - clicking directly on Practice button");
        Thread.sleep(5000);
        getTitleUrl(" - @browserNavigation - after clicking practice :");
        driver.navigate().back();
        System.out.println("@Test1 - navigated back to home page");
        Thread.sleep(5000);
        getTitleUrl(" - @browserNavigation - after navigating back :");
        driver.navigate().forward();
        System.out.println("@Test1 - navigated forward from home page to practice page");
        Thread.sleep(5000);
        getTitleUrl(" - @browserNavigation - after navigating forward :");
    }

    private static void getTitleUrl(String whereRU) {
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current url "+whereRU+currentUrl);
        pageTitle = driver.getTitle();
        System.out.println("page title "+whereRU+pageTitle);
    }
}
