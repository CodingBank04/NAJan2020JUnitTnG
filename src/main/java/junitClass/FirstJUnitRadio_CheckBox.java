package main.java.junitClass;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstJUnitRadio_CheckBox {

    static WebDriver driver;
    static String baseUrl;

    boolean benzSelected;
    boolean bmwSelected;
    boolean hondaSelected;

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

    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach - refreshed the page");
    }

    @AfterEach
    public void done() {
      //  driver.navigate().refresh();
        System.out.println("@AfterEach - refreshed the page");
    }

    @Test
    public void radiotest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='benzradio']")).click();
        System.out.println("@Test1 - clicked on benz radio");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
        System.out.println("@Test1 - clicked on bmw radio");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='hondaradio']")).click();
        System.out.println("@Test1 - clicked on honda radio");
        Thread.sleep(5000);

        benzSelected = driver.findElement(By.xpath("//input[@id='benzradio']")).isSelected();
        bmwSelected = driver.findElement(By.xpath("//input[@id='bmwradio']")).isSelected();
        hondaSelected = driver.findElement(By.xpath("//input[@id='hondaradio']")).isSelected();

        System.out.println("Radio benzSelected:"+benzSelected);
        System.out.println("Radio bmwSelected:"+bmwSelected);
        System.out.println("Radio hondaSelected:"+hondaSelected);
    }

    @Test
    public void checkboxtest() throws InterruptedException {
        WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
        WebElement benzCheck = driver.findElement(By.id("benzcheck"));
        WebElement hondaCheck = driver.findElement(By.id("hondacheck"));
        hondaCheck.click();
        Thread.sleep(5000);
        bmwCheck.click();
        Thread.sleep(5000);
        benzCheck.click();
        Thread.sleep(5000);
        benzSelected = driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected();
        bmwSelected = driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected();
        hondaSelected = driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected();

        System.out.println("check benzSelected:"+benzSelected);
        System.out.println("check bmwSelected:"+bmwSelected);
        System.out.println("check hondaSelected:"+hondaSelected);

        hondaCheck.click();
        Thread.sleep(5000);
        bmwCheck.click();
        Thread.sleep(5000);
        benzCheck.click();
        Thread.sleep(5000);

        benzSelected = driver.findElement(By.xpath("//input[@id='benzcheck']")).isSelected();
        bmwSelected = driver.findElement(By.xpath("//input[@id='bmwcheck']")).isSelected();
        hondaSelected = driver.findElement(By.xpath("//input[@id='hondacheck']")).isSelected();

        System.out.println("check benzSelected:"+benzSelected);
        System.out.println("check bmwSelected:"+bmwSelected);
        System.out.println("check hondaSelected:"+hondaSelected);
    }
}
