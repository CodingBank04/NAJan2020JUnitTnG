package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitDisplay {

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
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @BeforeEach
    public void clickTravellers() {
        driver.findElement(By.xpath("//div[@id='traveler-selector-hlp']//button[@data-gcw-component='gcw-traveler-amount-select']")).click();
        System.out.println("@BeforeEach - clicking on Travellers");
    }
    @AfterEach
    public void clickClose() {
        driver.findElement(By.xpath("//div[@id='traveler-selector-hlp']//button[@class='close btn-text']")).click();
        System.out.println("@AfterEach - clicking on Close");
    }


    @Test
    public void DisplayedTest() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='traveler-selector-room-data']//div[@class='children-wrapper']//button[@class='uitk-step-input-button uitk-step-input-plus']")).click();
        verifyHidden("//div[@class='traveler-selector-room-data']//span[text()='Child 1 age']");
        Thread.sleep(5000);
    }

    @Test
    public void aHiddenTest() throws InterruptedException {
        Thread.sleep(5000);
        verifyHidden("//div[@class='traveler-selector-room-data']//span[text()='Child 1 age']");
        Thread.sleep(5000);
    }

    private void verifyHidden(String locat) {
        WebElement childfield= driver.findElement(By.xpath(locat));
        boolean displ = childfield.isDisplayed();
        if(displ) {
            System.out.println("Element displayed");
        } else {
            System.out.println("Element Hidden");
        }
    }
}
