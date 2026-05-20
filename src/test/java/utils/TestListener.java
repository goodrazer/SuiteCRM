package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        log.info("==================================== STARTING TEST {} ======================================",
                iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("============================= FINISHED TEST {} Duration: {} ================================",
                iTestResult.getName(), getExecutionTime(iTestResult));
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("============================ FAILED TEST {} Duration: {} ===================================",
                        iTestResult.getName(), getExecutionTime(iTestResult));
        takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("=================================== SKIPPING TEST {} =======================================",
                        iTestResult.getName());
    }

    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return AllureUtils.takeScreenshot(driver);
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
           log.error("Failed to take screenshot: browser session does not exist or browser did not have time to open!");
        }
        return new byte[] {};
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}