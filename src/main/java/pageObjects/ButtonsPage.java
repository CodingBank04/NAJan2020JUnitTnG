package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ButtonsPage {

    private WebDriver buttonsDriver;

    //Create a constructor to instantiate the webelements in the given class
    public ButtonsPage (WebDriver driver) {
        //pass the driver instance to this class
        buttonsDriver = driver;
        //initElements static method used from PageFactory class that takes driver instance and class instance as parameters
        PageFactory.initElements(buttonsDriver, this);
    }

    // below 4 lines to show the traditional way before moving to Page Object Model
    //WebElement buttonEle = driver.findElement(By.xpath("(//button[text()='A button element'])[position()=1]"));
    //WebElement submit = driver.findElement(By.xpath("(//input[@value='A submit button'])[position()=1]"));
    //WebElement anchor = driver.findElement(By.xpath("(//a[text()='An anchor'])[position()=1]"));
    //List<WebElement> listofButtons = driver.findElements(By.xpath("//button[text()='A button element']"));

    //Declare list of web elements
    @FindBys(@FindBy(xpath = "//button[text()='A button element']"))
    private List<WebElement> listofButtons;

    //Declare list of web elements --> Simpler way
    @FindBy(xpath = "//input[@value='A submit button']")
    private List<WebElement> listSubmit;

    //Declare web element with how and using parameters in FindBy
    @FindBy(how = How.XPATH, using = "(//button[text()='A button element'])[position()=1]")
    private WebElement buttonEle;

    @FindBy(how = How.XPATH, using = "(//input[@value='A submit button'])[position()=1]")
    private WebElement submit;

    //Declare web element with direct locator type and value
    @FindBy(xpath = "(//a[text()='An anchor'])[position()=1]")
    private WebElement anchor;

    @FindBy(how = How.LINK_TEXT, using = " view source")
    private WebElement viewSource;

    @FindBy(how = How.ID, using = "content")
    private WebElement content;

    @FindBy(linkText = "Default functionality")
    private WebElement defaultFunct;

    //method to interact with the element
    public void buttonEleClick() {
        buttonEle.click();
    }

    //method to interact with the element
    public void submitClick() {
        submit.click();
    }

    //method to interact with the element
    public int listSize () {
        return listSubmit.size();
    }
}
