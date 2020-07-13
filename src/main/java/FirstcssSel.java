package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstcssSel {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("https://www.bankofamerica.com/");


        // syntax: tag[attribute='value']
        driver1.findElement(By.cssSelector("a[aria-controls='navCheckingContent']")).click();

    }

}
