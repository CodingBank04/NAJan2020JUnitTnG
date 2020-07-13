package main.java.junitClass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstJUnitSelectMulti {

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
    public void multiaa_SelectEach() throws InterruptedException {
        System.out.println("@dropSelectEach - executed test");
        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);
        sel.selectByValue("orange"); // selects using the value attribute of the option tag element
        Thread.sleep(5000);
        sel.selectByVisibleText("Apple"); // selects using the text of the option tag element
        Thread.sleep(5000);
        sel.selectByIndex(2); //selects BMW because its the first option at index 0
        Thread.sleep(5000);
    }

    @Test
    public void multiab_DeSelectEach() throws InterruptedException {
        System.out.println("@dropSelectEach - executed test");
        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);
        sel.deselectByValue("orange"); // deselects using the value attribute of the option tag element
        Thread.sleep(5000);
        sel.deselectByVisibleText("Apple"); // deselects using the text of the option tag element
        Thread.sleep(5000);
        sel.deselectByIndex(2); //deselects BMW because its the first option at index 0
        Thread.sleep(5000);
    }

    @Test
    public void multiac_SelectAll() throws InterruptedException {
        System.out.println("@dropSelectAll - executed test");
        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);
        List<WebElement> opts = sel.getOptions(); // returns a list of WebElements of all the option tags inside select
        for(WebElement ele: opts) {
            System.out.println("Option is: "+ele.getText()); //get the visible text of the element
            sel.selectByVisibleText(ele.getText()); // selects using the text of the option tag element
            Thread.sleep(5000);
        }

        for(WebElement ele: opts) {
            System.out.println("deselection Option is: "+ele.getText()); //get the visible text of the element
            sel.deselectByVisibleText(ele.getText()); // deselects using the text of the option tag element
            Thread.sleep(5000);
        }
    }

    @Test
    public void multiac_getSelected() throws InterruptedException {
        System.out.println("@dropSelectAll - executed test");
        WebElement multiEle = driver.findElement(By.name("multiple-select-example"));
        Select sel = new Select(multiEle);
        List<WebElement> opts = sel.getOptions(); // returns a list of WebElements of all the option tags inside select
        for(WebElement ele: opts) {
            System.out.println("Option is: "+ele.getText()); //get the visible text of the element
            sel.selectByVisibleText(ele.getText()); // selects using the text of the option tag element
            Thread.sleep(5000);
        }

        sel.deselectByIndex(1); //de selects Orange option
        // returns a list of WebElements of all the "selected" option tags inside select
        List<WebElement> selOpts = sel.getAllSelectedOptions();
        for(WebElement ele: selOpts) {
            System.out.println("Selected Option is: "+ele.getText()); //get the visible text of the element
        }

        sel.deselectAll();
        Thread.sleep(5000);
        selOpts = sel.getAllSelectedOptions();
        System.out.println("selected options count: "+selOpts.size());

        System.out.println("isMultiple:"+sel.isMultiple());
    }

}
