package main.java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BofaHomepage {

    WebDriver bofaDriver;

    public BofaHomepage (WebDriver abc) {
        bofaDriver = abc;
        PageFactory.initElements(bofaDriver, this);
    }

    //For Dynamic elements, use FindAll annotation to define all locators your element can have
    @FindAll({@FindBy(xpath = "//span[text()='Get started']"),
            @FindBy(xpath = "//span[text()='Click to get started']"),
            @FindBy(xpath = "//span[text()='Open']"),
            @FindBy(xpath = "//span[text()='See options']"),
            @FindBy(xpath = "//span[text()='Click to see options']"),
            @FindBy(xpath = "//span[text()='Learn more']"),
            @FindBy(xpath = "//span[text()='Continue']"),
            @FindBy(xpath = "//span[text()='Click to open']")
    })
    WebElement homeclick1;

    //Method to interact with the element within the page object class
    public String clickStarted() {
        WebDriverWait wait = new WebDriverWait(bofaDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(homeclick1));
        String text = homeclick1.getText();
        homeclick1.click();
        return text;
    }
}
