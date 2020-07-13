package main.java.testngclasses;

import com.relevantcodes.extentreports.ExtentReports;
import java.text.SimpleDateFormat;

public class ExtentFactory {

    static final String currTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(System.currentTimeMillis());
    
    public static ExtentReports getExTentInstance() {
        ExtentReports ereports;
        String path = "C:\\IJProjs\\NAAutoBoot\\src\\main\\java\\reports\\"+currTime+".html";
        ereports = new ExtentReports(path, false);
        return ereports;
    }
}
