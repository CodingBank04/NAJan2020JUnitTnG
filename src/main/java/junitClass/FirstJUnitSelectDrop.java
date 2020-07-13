package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstJUnitSelectDrop {

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

    @Test
    public void dropSelectEach() throws InterruptedException {
        System.out.println("@dropSelectEach - executed test");
        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        sel.selectByValue("honda"); // selects using the value attribute of the option tag element
        Thread.sleep(5000);
        sel.selectByVisibleText("Benz"); // selects using the text of the option tag element
        Thread.sleep(5000);
        sel.selectByIndex(0); //selects BMW because its the first option at index 0
        Thread.sleep(5000);
    }

    @Test
    public void dropSelectAll() throws InterruptedException {
        System.out.println("@dropSelectAll - executed test");
        WebElement dropEle = driver.findElement(By.id("carselect"));
        Select sel = new Select(dropEle);
        List<WebElement> opts = sel.getOptions(); // returns a list of WebElements of all the option tags inside select
        for(WebElement ele: opts) {
            System.out.println("Option is: "+ele.getText()); //get the visible text of the element
            sel.selectByVisibleText(ele.getText()); // selects using the text of the option tag element
            Thread.sleep(5000);
        }
        System.out.println("isMultiple:"+sel.isMultiple());
    }


}
