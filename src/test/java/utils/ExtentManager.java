package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;

    public static ExtentReports initExtentReport() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/TestReport_" + timestamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            try {
                sparkReporter.loadXMLConfig("./src/test/resources/extent-config.xml");
            } catch (IOException e) {
                e.printStackTrace(); // or use a logger
            }

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Project", "Hybrid Automation Framework");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "QA User");
        }

        return extent;
    }
    
    public static void flushExtentReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}