package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitSendKeys {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void init() {
        driver.navigate().refresh();
        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
        driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void test1() {
        driver.findElement(By.name("enter-name")).sendKeys("somemail@amail.com");
        //driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys();
        System.out.println("@Test1 - entered text directly on Email Address");
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement nameField= driver.findElement(By.name("enter-name"));
        nameField.sendKeys("userPass");
        System.out.println("@Test2 - performed operation with objects");
        Thread.sleep(5000);
    }
}
