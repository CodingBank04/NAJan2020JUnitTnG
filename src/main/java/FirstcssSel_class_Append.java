package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstcssSel_class_Append {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("https://www.bankofamerica.com/");

        // tag.class1.class2.class3 and so on
        driver1.findElement(By.cssSelector("span.spa-btn.spa-btn--primary.spa-btn--medium.masthead-cta-btn")).click();
    }

}
