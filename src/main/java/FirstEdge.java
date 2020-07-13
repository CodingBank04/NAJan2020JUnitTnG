package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstEdge {

    //psvm and do ctrl+space
    public static void main(String[] args) {
        WebDriver driver1 = new EdgeDriver();

        driver1.get("https://amazon.com");

    }

}
