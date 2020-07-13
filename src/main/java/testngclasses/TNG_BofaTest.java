package main.java.testngclasses;

import main.java.pageObjects.BofaHomepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TNG_BofaTest {

    WebDriver driver;
    String baseUrl;
    BofaHomepage bofaPage;

    @BeforeMethod
    public void setup (){
        baseUrl="https://www.bankofamerica.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        bofaPage = new BofaHomepage(driver);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void linkTest() {
        System.out.println(bofaPage.clickStarted());
    }
}
