package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstFF {

    //psvm and do ctrl+space
    public static void main(String[] args) {
        /* location of the driver executable
        For windows, navigate to file location, right click and click Properties. Grab the location value, add the filename at the end
        For MAC, navigate to file location, right click and click Get Info. Grab the location value, add the filename at the end
         */
        System.setProperty("webdriver.gecko.driver","C:\\IJProjs\\NAAutoBoot\\geckodriver.exe");

        System.out.println("driver location is:"+System.getProperty("webdriver.gecko.driver"));

        WebDriver driver1 = new FirefoxDriver();

        driver1.get("https://amazon.com");

    }

}
