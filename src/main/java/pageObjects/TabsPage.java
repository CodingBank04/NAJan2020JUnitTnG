package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TabsPage {

    private WebDriver tabsDriver;

    public TabsPage(WebDriver driver) {
        tabsDriver = driver;
        PageFactory.initElements(tabsDriver, this);
    }

    @FindBy(xpath = "//ul[@role='tablist']//a")
    public static List<WebElement> allTabs;

}
