package main.java.testngclasses;

import main.java.pageObjects.ButtonsPage;
import main.java.pageObjects.JQueryHPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TNG_ButtonPg {

    WebDriver driver;
    String baseUrl;

    //Create instances of page object classes we created before
    JQueryHPage jPage;
    ButtonsPage bPage;

    @BeforeClass
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //Instantiate the page objects by passing driver instance to the constructors
        bPage = new ButtonsPage(driver);
        jPage = new JQueryHPage(driver);
        driver.manage().window().maximize();

        //invokes the methods inside the page object class
        jPage.clicks("buttons");
        jPage.switchFrame();
    }

    @AfterClass
    public void quitter() {
        driver.quit();
    }

    @Test
    public void testButtonsPage() {
        //invokes the methods inside the page object class
        Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/button/");
    }

    @Test
    public void clickButtons() {
        //invokes the methods inside the page object class
        bPage.buttonEleClick();
        Assert.assertEquals(bPage.listSize(), 2);
    }

}
