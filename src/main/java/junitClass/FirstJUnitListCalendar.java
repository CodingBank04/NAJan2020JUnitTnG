package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitListCalendar {

    static WebDriver driver;
    static String baseUrl;

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://www.expedia.com/Hotels";
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() {
       // driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void clickCheckIn() {
        driver.findElement(By.xpath("//*[@id='hotel-checkin-hlp']")).click();
        System.out.println("@BeforeEach - clicking on check-in");
    }

     @Test
    public void test1() {
        //find all the dates in the date picker in expedia
         List<WebElement> datesEle = driver.findElements(By.xpath("//div[@class='datepicker-cal-month']//button"));

         //loop through each date element
         for(WebElement ele: datesEle) {

             //Find if date is enabled or not
             boolean enabl = ele.isEnabled();

             //get the date value by getText() method
             String dateVal = ele.getText();

             //from the button element, reach to span which is child to button element
             WebElement spanEle = ele.findElement(By.tagName("span"));

             //Using span element, find the text of it which holds the month value
             String monthVal = spanEle.getText();

             if(enabl) {//if button element is enabled, print enabled date and month value
                 System.out.println("Date is enabled:"+monthVal+dateVal);
             } else {//if button element is disabled, print disabled date and month value
                 System.out.println("Date is disabled:"+monthVal+dateVal);
             }
         }
    }
}
