package main.java.listeners;

import org.testng.*;

public class CustomMethodListener2 implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        String testMethod = method.getTestMethod().getMethodName();
        String testClass = testResult.getTestClass().getName();
        System.out.println("Before Invocation - Class:"+testClass+"\t Method: "+testMethod);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String testMethod = method.getTestMethod().getMethodName();
        String testClass = testResult.getTestClass().getName();
        System.out.println("after Invocation - Class:"+testClass+"\t Method: "+testMethod);
        System.out.println("Test passed:"+ testResult.isSuccess());
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        System.out.println("before Invocation:"+context.getName());
        ITestNGMethod testmethods[] = context.getAllTestMethods();
        for (ITestNGMethod method1: testmethods) {
            System.out.println(method1.getMethodName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }
}
