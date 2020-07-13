package main.java.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.Reporter;

public class CustomSuiteListener1 implements ISuiteListener {
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish=" + suite.getName());
        Reporter.log("onFinish=" + suite.getName(), true);

    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart=" + suite.getName());
        Reporter.log("onStart=" + suite.getName(), true);
    }
}
