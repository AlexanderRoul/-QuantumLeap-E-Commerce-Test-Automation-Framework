package com.quantumleap.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("QuantumLeap Test Report");
            spark.config().setReportName("QuantumLeap Suite");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
