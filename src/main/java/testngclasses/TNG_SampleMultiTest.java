package main.java.testngclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TNG_SampleMultiTest {

    WebDriver driver;
    String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Button']")).click();
        driver.switchTo().frame(0);
    }

    @AfterClass
    public void quitter() {
        driver.quit();
    }

    @Test
    public void buttonsclick () {
        WebElement buttonEle = driver.findElement(By.xpath("(//button[text()='A button element'])[position()=1]"));
        buttonEle.click();
    }

    @Test
    public void submitClick() {
        WebElement submit = driver.findElement(By.xpath("(//input[@value='A submit button'])[position()=1]"));
        submit.click();
    }

    @Test
    public void anchorclick() {
        WebElement anchor = driver.findElement(By.xpath("(//a[text()='An anchor'])[position()=1]"));
        anchor.click();
    }

    @Test
    public void buttonsclick2 () {
        WebElement buttonEle = driver.findElement(By.xpath("(//button[text()='A button element'])[position()=2]"));
        buttonEle.click();
    }

    @Test
    public void submitClick2() {
        WebElement submit = driver.findElement(By.xpath("(//input[@value='A submit button'])[position()=2]"));
        submit.click();
    }

    @Test
    public void anchorclick2() {
        WebElement anchor = driver.findElement(By.xpath("(//a[text()='An anchor'])[position()=2]"));
        anchor.click();
    }
}
