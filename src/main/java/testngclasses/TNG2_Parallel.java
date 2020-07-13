package main.java.testngclasses;

import main.java.listeners.CustomITestListener1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TNG2_Parallel {

    WebDriver driver;
    Actions action;
    String baseUrl;

    @BeforeTest
    public void setUp() {
        baseUrl = "https://jqueryui.com/";
        //create browser driver instance.
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Parameters({"linkNm"})
    @Test //Hover on Contribute button and click on each of the menu items
    public void test1(String linkNm) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //hover on a given element Contribute
        WebElement hovContri = driver.findElement(By.xpath("//a[text()='Contribute']"));
        wait.until(ExpectedConditions.visibilityOf(hovContri));
        action.moveToElement(hovContri).perform();

        //click on the given element
        WebElement eachEle = driver.findElement(By.xpath("//a[text()='"+linkNm+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(eachEle)).click();
    }

    @Parameters({"header", "urlLink", "linkNm"})
    @Test //validate landing url and page element
    public void test2(String header, String urlLink, String linkNm) {
        String currUrl = driver.getCurrentUrl();
        String actualHead;

        if(linkNm.contains("CLA")) {
            actualHead = driver.findElement(By.xpath("//img[@class='stnd ']")).getAttribute("alt");
        } else {
            actualHead = driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
        }

        Assert.assertTrue(currUrl.contains(urlLink));
        Assert.assertEquals(actualHead, header);
    }

}














