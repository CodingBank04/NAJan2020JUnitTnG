package main.java.testngclasses;

import org.testng.annotations.*;

public class TNG_Group extends TNG_Suite {

    @BeforeClass(alwaysRun = true)
    public void setUP() {
        System.out.println("TNG_Group - @BeforeClass method");
    }

    @Test(groups = {"iphone", "faceid"})
    public void testIphoneX() {
        System.out.println("Class1 - @Test1 - testIphoneX - method");
    }

    @Test(groups = {"iphone", "faceid"})
    public void testIphone11() {
        System.out.println("Class1 - @Test2 - testIphone11 - method");
    }

    @Test(groups = {"iphone", "touchid"})
    public void testIphone7() {
        System.out.println("Class1 - @Test3 - testIphone7 - method");
    }

    @Test(groups = {"iphone", "touchid"})
    public void testIphone8() {
        System.out.println("Class1 - @Test3 - testIphone8 - method");
    }

    @Test(groups = {"android", "samsung", "faceid"})
    public void testSamsungG10() {
        System.out.println("Class1 - @Test1 - testSamsungG10 - method");
    }

    @Test(groups = {"android", "samsung"})
    public void testSamsungG9() {
        System.out.println("Class1 - @Test2 - testSamsungG9 - method");
    }

    @Test(groups = {"android", "oneplus"})
    public void testOnePlus9() {
        System.out.println("Class1 - @Test3 - testOnePlus9 - method");
    }

    @Test(groups = {"android", "oneplus"})
    public void testOnePlus8() {
        System.out.println("Class1 - @Test3 - testOnePlus8 - method");
    }
}
