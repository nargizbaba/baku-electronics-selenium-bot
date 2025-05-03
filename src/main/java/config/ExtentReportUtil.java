package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Arrays;

public class ExtentReportUtil {
    private static final ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
                "C:/Users/nargi/IdeaProjects/BakuElectronics/target/ExtentReports/BakuElectronics_.html"
        );
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Nargiz");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    public static void startTest(String testName) {
        ExtentTest scenarioTest = extent.createTest(testName);
        test.set(scenarioTest);
    }

    public static void logInfo(String message) {
        test.get().info(message);
    }

    public static void logPass(String message) {
        test.get().pass(message);
    }

    public static void logFail(String message) {
        test.get().fail(message);
    }

    public static void logException(Exception e) {
        String exceptionDetails = logExceptionDesign(e);
        test.get().fail(exceptionDetails);
    }

    public static void logStep(String stepDescription) {
        test.get().info(stepDescription);
    }

    public static void endTest() {
        extent.flush();
    }

    private static String logExceptionDesign(Exception e) {
        String exceptionMessage = e.getMessage();
        String stackTrace = Arrays.toString(e.getStackTrace())
                .replace(", ", "\n")
                .replace("[", "")
                .replace("]", "");
        return "<details><summary>Error occurred: " + exceptionMessage + "</summary>" +
                "<pre style='padding-left: 20px;'>" + stackTrace + "</pre></details>";
    }
}
