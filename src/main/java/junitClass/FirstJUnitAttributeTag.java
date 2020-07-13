package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstJUnitAttributeTag {

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
    public void test1() {
        // getAttribute method returns the value of the attribute passed in the method.
        WebElement openTab = driver.findElement(By.xpath("//legend[text()='Switch Tab Example']//following-sibling::a"));
        System.out.println("@Test1 - class name is:"+openTab.getAttribute("class"));
        System.out.println("@Test1 - id value is:"+openTab.getAttribute("id"));
        System.out.println("@Test1 - href value is:"+openTab.getAttribute("href"));
        System.out.println("@Test1 - target value is:"+openTab.getAttribute("target"));
    }

    @Test
    public void test2() {
        // getTagName method retunrs the tag name of the element in use.
        WebElement tagExample = driver.findElement(By.xpath("//*[text()='Switch Tab Example']"));
        System.out.println("@Test2 - tabExample tagName:"+tagExample.getTagName());
    }

    @Test
    public void test3() throws InterruptedException{
        // Refactoring the previous list example radios test to give attribute value so we know which radio the program clicks
        List<WebElement> listEle = driver.findElements(By.xpath("//div[@id='radio-btn-example']//input"));
        for (WebElement ele : listEle) {
            ele.click();
            System.out.println("Radio button selected is:"+ele.getAttribute("value"));
            System.out.println("radio button isSelected:" + ele.isSelected());
            Thread.sleep(5000);
        }
    }
}
