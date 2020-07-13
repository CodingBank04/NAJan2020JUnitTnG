package main.java.junitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstJUnitWebDriverWait {

    static WebDriver driver;
    static String baseUrl;
    static JavascriptExecutor jse;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://www.bankofamerica.com/";
        System.setProperty("webdriver.gecko.driver","C:\\IJProjs\\NAAutoBoot\\geckodriver.exe");
        driver = new FirefoxDriver();
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
        WebDriverWait wait = new WebDriverWait(driver, 5);
        //WebElement academy= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'khanacademy')]")));
        WebElement academy= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'khanacademy')]")));
        //wait.until(ExpectedConditions.invisibilityOf(academy)); //used to elements like spinners, loaders
        academy.click();
        System.out.println("@Test1 - executed test");
    }
}
