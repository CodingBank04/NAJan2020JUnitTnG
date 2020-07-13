package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class FirstJUnitHandle {

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
    public void test1() throws InterruptedException {
        String parentHandle = driver.getWindowHandle();
        System.out.println("@Test1 - Current Window Handle before clicking:" + parentHandle);
        driver.findElement(By.id("openwindow")).click();
        Thread.sleep(5000);

        //return all window handles for windows open by driver
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of windows:" + handles.size()); // returns number of window handles
        for (String handle : handles) { // Loop through window handles one by one
            if (handle.equals(parentHandle)) {
                System.out.println("handle is parent handle:" + handle);
            } else {
                driver.switchTo().window(handle); // switched to child window
                System.out.println("Switched to child window:" + driver.getWindowHandle());

                List<WebElement> findCourse = driver.findElements(By.xpath("//input[@placeholder='Find a course']"));

                if (findCourse.size() == 1) {
                    findCourse.get(0).sendKeys("my proper course");
                    System.out.println("Found the correct child window and entered given value in webElement inside it");
                    Thread.sleep(5000);
                    driver.close(); // closes current focus window only. Not all windows!
                    break;
                } else {
                    System.out.println("Not the child window we are looking for");
                }
            }
        }
        driver.switchTo().window(parentHandle); // switch back to the parent window
        driver.findElement(By.id("bmwradio")).click(); // click on an element no the parent window
        Thread.sleep(5000);

    }
}
