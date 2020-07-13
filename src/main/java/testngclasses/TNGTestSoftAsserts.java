package main.java.testngclasses;

import main.java.appCode.AppforTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TNGTestSoftAsserts {
    AppforTest atest = new AppforTest();

    @Test
    public void testSum() {
        int res;
        SoftAssert sa = new SoftAssert();
         res = atest.sumNbrs(2, 2);
        sa.assertEquals(res, 4,"sum mismatch");
        System.out.println("@Test1: first assertion complete");
        sa.assertEquals(res, 5,"sum mismatch");
        System.out.println("@Test1: second assertion complete");
        sa.assertEquals(res, 6,"sum mismatch");
        System.out.println("@Test1: third assertion complete");
        sa.assertAll("after all assertions");
    }

    @Test
    public void test2() { //write and practice for the addString to pass and fail
        System.out.println("@Test2 method");
    }

    @Test
    public void test3() { //write and practice for the getArray to pass and fail
        System.out.println("@Test3 method");
    }
}
