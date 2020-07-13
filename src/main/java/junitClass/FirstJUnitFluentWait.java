package main.java.junitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstJUnitFluentWait {

    static WebDriver driver;
    static String baseUrl;
    static JavascriptExecutor jse;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.gecko.driver","C:\\IJProjs\\NAAutoBoot\\geckodriver.exe");
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); if you are using explicit wait, avoid using implicit wait and vice-versa
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @Test
    public void test1() {
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) //how much total wait time
                .pollingEvery(Duration.ofSeconds(2)) //how much frequency of each wait
                .ignoring(NoSuchElementException.class); //ignore exception classes

        WebElement academy= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'ahanacademy')]")));
        academy.click();
        System.out.println("@Test1 - executed test");
    }

    @Test
    public void test2() {
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) //how much total wait time
                .pollingEvery(Duration.ofSeconds(5)) //how much frequency of each wait
                .ignoring(NoSuchElementException.class); //ignore exception classes

        WebElement academy1= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'ahanacademy')]")));
        academy1.click();
        System.out.println("@Test1 - executed test");
    }
}
