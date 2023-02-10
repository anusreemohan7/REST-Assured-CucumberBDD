package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporter {
	public static final ExtentReports extent = new ExtentReports();
	public static ExtentReports extendReportGenerator() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/extent-report.html");
		reporter.config().setReportName("API Automations Results");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anusree");
		return extent;
	}

}
