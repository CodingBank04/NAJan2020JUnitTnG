package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitList {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://letskodeit.teachable.com/p/practice";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
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
    public void radios() throws InterruptedException {
        List<WebElement> listEle = driver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("radio button isSelected:" + ele.isSelected());
            Thread.sleep(5000);
        }
    }

    @Test
    public void checks() throws InterruptedException {
        List<WebElement> listEle = driver.findElements(By.xpath("//legend[text()='Checkbox Example']/following-sibling::label/input"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("checkbox: isSelected:" + ele.isSelected());
            Thread.sleep(5000);
        }
    }

    @Test
    public void tableEx() {
        List<WebElement> listHead = driver.findElements(By.xpath("//table[@class='table-display']//th"));
        List<WebElement> listauthor = driver.findElements(By.xpath("//table[@class='table-display']//td[1]"));
        List<WebElement> listCourse = driver.findElements(By.xpath("//table[@class='table-display']//td[2]"));
        List<WebElement> listPrice = driver.findElements(By.xpath("//table[@class='table-display']//td[3]"));
        List<WebElement> listLocation = driver.findElements(By.xpath("//table[@class='table-display']//td[4]"));

        for (WebElement hele : listHead) {
            System.out.println("Table Header is:" + hele.getText());
        }
        for (WebElement aele : listauthor) {
            System.out.println("author is:" + aele.getText());
        }
        for (WebElement cele : listCourse) {
            System.out.println("Course is:" + cele.getText());
        }
        for (WebElement pele : listPrice) {
            System.out.println("Price is:" + pele.getText());
        }


        int headSize = listHead.size();
        System.out.println("header element size:"+headSize);
        if(headSize > 0) {
            for (WebElement hele : listHead) {
                System.out.println("Table Header is:" + hele.getText());
            }
        } else {
            System.out.println("Header element not found");
        }

        int locationSize = listLocation.size();
        System.out.println("Location element size:"+locationSize);
        if(locationSize > 0) {
            for (WebElement locationEle : listLocation) {
                System.out.println("4th column is:" + locationEle.getText());
            }
        } else {
            System.out.println("4th column element not found");
        }
    }
}
