package main.java.junitClass;

import main.java.utils.RandomString;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class FirstJUnitActions {

    static WebDriver driver;
    static String baseUrl;
    static Actions action; // create an object of type Actions class

    @BeforeAll
    public static void setUP() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver); // initializing the actions class object by passing driver object to Actions class constructor
        driver.manage().window().maximize();
        driver.get(baseUrl);
        System.out.println("@BeforeAll - initiated and navigated to web page");
    }

    @AfterAll
    public static void tearDown() throws IOException {
        RandomString rString = new RandomString();
        String fileNm = System.getProperty("user.dir")+"\\src\\snippets\\"+rString.genRandom(5)+".png";
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(fileNm));
        driver.quit();
        System.out.println("@AfterAll - closed browser session");
    }

    @Test
    public void aHover_Click() throws InterruptedException {
        Thread.sleep(5000);
        WebElement hovSupport = driver.findElement(By.xpath("//section//a[text()='Support']"));
        WebElement forums = driver.findElement(By.xpath("//a[text()='Forums']"));
        action.moveToElement(hovSupport).perform(); // to hover on a given WebElement
        Thread.sleep(5000);
        action.moveToElement(forums).click().perform(); // to click on a given WebElement
       // action.click(forums).perform();// to click on a given WebElement

        Thread.sleep(5000);
        String currUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://foru.jquery.com/",currUrl,"url mismatch!!!");
        System.out.println("@Test1 - currUrl is:"+currUrl);
    }

    @Test
    public void bDoubleClick_ContextClick() throws InterruptedException {
        driver.navigate().to("https://jqueryui.com/button/");
        Thread.sleep(5000);

        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);// switch inside iframe to interact with elements

        WebElement anchor = driver.findElement(By.xpath("//div[@class='widget']//a[text()='An anchor']"));
        //action.moveToElement(anchor).doubleClick().perform(); // to double click
        action.doubleClick(anchor).perform(); // to double click
        Thread.sleep(5000);
        action.contextClick(anchor).perform(); // to right click

        Thread.sleep(5000);
        System.out.println("@Test2 - executed test");
        driver.switchTo().defaultContent(); // switch out of all iframes
    }

    @Test
    public void cDragDrop() throws InterruptedException {
        driver.navigate().to("https://jqueryui.com/droppable/");
        Thread.sleep(5000);

        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame); // switch inside iframe to interact with elements

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // use actions class dragAndDrop method to drag from one element to another element
        action.dragAndDrop(draggable, droppable).build().perform();
        Thread.sleep(5000);

        String actualTxt = droppable.findElement(By.tagName("p")).getText();
        Assertions.assertEquals("Droppd!", actualTxt);

        System.out.println("@Test3 - executed test");
        driver.switchTo().defaultContent(); // switch out of all iframes
    }

    @Test
    public void dClickHoldRelease() throws InterruptedException {
        driver.navigate().to("https://jqueryui.com/droppable/");
        Thread.sleep(5000);

        WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // use actions class clickAndHold and release methods to drag from one element to another element
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        Thread.sleep(5000);

        String actualTxt = droppable.findElement(By.tagName("p")).getText();
        Assertions.assertEquals("Droppd!", actualTxt);

        System.out.println("@Test3 - executed test");
        driver.switchTo().defaultContent(); // switch out of all iframes
    }

    @Test
    public void eSlider() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com/cars/PHL-a1458/2020-06-27/2020-07-22?sort=rank_a");
        Thread.sleep(10000);
        WebElement totPrice = driver.findElement(By.xpath("//div[text()='Total price']"));
        totPrice.click();
        Thread.sleep(5000);

        WebElement minPrice = driver.findElement(By.className("cars-results-filters-PriceFilterSection__Header__Min"));
        WebElement maxPrice = driver.findElement(By.className("cars-results-filters-PriceFilterSection__Header__Max"));

        System.out.println("Min price before slide:"+minPrice.getText());
        System.out.println("Max price before slide:"+maxPrice.getText());

        WebElement startingSlider = driver.findElement(By.xpath("//div[@aria-label='Minimum price' and @role='slider']"));
        WebElement endSlider = driver.findElement(By.xpath("//div[@aria-label='Maximum price' and @role='slider']"));

        action.dragAndDropBy(startingSlider, 100, 0).perform(); // drags and drops a slider element by offset given
        Thread.sleep(5000);
        action.dragAndDropBy(endSlider, -50, 0).perform(); // drags and drops a slider element by offset given

        System.out.println("Min price after slide:"+minPrice.getText());
        System.out.println("Max price after slide:"+maxPrice.getText());

        // Note to student - Add Assertions.assertNotEquals as an exercise for the test case assertions part!

        Thread.sleep(10000);
    }

    @Test
    public void fKeyPress() throws InterruptedException {
        driver.navigate().to("https://www.kayak.com/cars/PHL-a1458/2020-06-27/2020-07-22?sort=rank_a");
        Thread.sleep(5000);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
    }
}




















