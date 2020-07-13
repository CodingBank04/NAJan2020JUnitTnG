package main.java.listeners;

import org.testng.*;

public class CustomITestListener1 implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart="+result.getName());
        Reporter.log("onTestStart="+result.getName(), true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess="+result.getName());
        Reporter.log("onTestSuccess="+result.getName(), true);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure="+result.getName());
        Reporter.log("onTestFailure="+result.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped="+result.getName());
        Reporter.log("onTestSkipped="+result.getName(), true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage="+result.getName());
        Reporter.log("onTestFailedButWithinSuccessPercentage="+result.getName(), true);

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout="+result.getName());
        Reporter.log("onTestFailedWithTimeout="+result.getName(), true);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart="+context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        for(ITestNGMethod method: methods) {
            System.out.println(method.getMethodName());
            Reporter.log(method.getMethodName(), true);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish="+context.getName());
        Reporter.log("onFinish="+context.getName(), true);
    }
}
