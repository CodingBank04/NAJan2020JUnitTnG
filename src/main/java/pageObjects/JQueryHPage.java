package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JQueryHPage {

    private WebDriver hpageDriver;

    public JQueryHPage(WebDriver driver) {
        hpageDriver = driver;
        PageFactory.initElements(hpageDriver, this);
    }

    @FindBy(linkText = "Button")
    WebElement buttons;

    @FindBy(linkText = "Menu")
    WebElement menu;

    @FindBy(linkText = "Checkboxradio")
    WebElement checkboxradio;

    @FindBy(linkText = "Selectmenu")
    WebElement selectMenu;

    @FindBy(linkText = "Tabs")
    WebElement tabs;

    @FindBy(how = How.CLASS_NAME, using = "demo-frame")
    private WebElement frame;

    public void clicks(String buttonNm) {
        System.out.println("button is:"+buttonNm);
        switch (buttonNm) {
            case "buttons" -> buttons.click();
            case "menu" -> menu.click();
            case "selectMenu" -> selectMenu.click();
            case "tabs" -> tabs.click();
            case "checkboxradio" -> checkboxradio.click();
        }
    }

    public void switchFrame() {
        hpageDriver.switchTo().frame(frame);
    }
}
