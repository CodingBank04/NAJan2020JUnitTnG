package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class FirstChrome {

        //psvm and do ctrl+space
        public static void main(String[] args) {
            /* location of the driver executable
            For windows, navigate to file location, right click and click Properties. Grab the location value, add the filename at the end
            For MAC, navigate to file location, right click and click Get Info. Grab the location value, add the filename at the end
             */
            System.setProperty("webdriver.chrome.driver","C:\\IJProjs\\NAAutoBoot\\chromedriver.exe");

            System.out.println("driver location is:"+System.getProperty("webdriver.chrome.driver"));

            WebDriver driver1 = new ChromeDriver();

            driver1.get("https://www.bankofamerica.com/");

        }

}
