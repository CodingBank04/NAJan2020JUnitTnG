package main.java.testngclasses;

import main.java.pageObjects.JQueryHPage;
import main.java.pageObjects.TabsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TNG_TabsPg {

    WebDriver driver;
    String baseUrl;

    JQueryHPage jPage;
    TabsPage tPage;

    @BeforeClass
    public void setup() {
        baseUrl = "https://jqueryui.com/";
        System.setProperty("webdriver.chrome.driver", "C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //Instantiate the page objects by passing driver instance to the constructors
        tPage = new TabsPage(driver);
        jPage = new JQueryHPage(driver);
        driver.manage().window().maximize();
        //invokes the methods inside the page object class
        jPage.clicks("tabs");
        jPage.switchFrame();
    }

    @AfterClass
    public void quitter() {
        driver.quit();
    }

    @Test
    public void testTabsPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://jqueryui.com/tabs/");
    }

    @Test
    public void clickTabs() { //example of accessing page objects outside of the page object class
        Assert.assertEquals(TabsPage.allTabs.size(), 3);
        for(WebElement eachTab: TabsPage.allTabs) {
            System.out.println("tab name:"+eachTab.getText());
            eachTab.click();
        }
    }
}
