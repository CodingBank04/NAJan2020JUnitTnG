package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstcssSel_Class {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        driver1.get("https://www.bankofamerica.com/");

        // .classvalue
        driver1.findElement(By.cssSelector(".search-query")).sendKeys("how to make money");
        driver1.findElement(By.cssSelector("input.search-query")).sendKeys("why");

    }

}
