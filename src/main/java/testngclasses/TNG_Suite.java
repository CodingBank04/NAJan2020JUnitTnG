package main.java.testngclasses;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TNG_Suite {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite - method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite - method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("@BeforeTest - method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("@AfterTest - method");
    }
}
