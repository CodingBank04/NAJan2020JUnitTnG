package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTagName {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("http://na.edu/");

        driver1.findElement(By.tagName("a")).click();

    }

}
