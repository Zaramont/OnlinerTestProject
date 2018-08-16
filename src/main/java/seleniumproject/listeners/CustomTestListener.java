package seleniumproject.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static seleniumproject.utils.DriverFactory.getDriver;


public class CustomTestListener extends TestListenerAdapter {

    private Logger log = LoggerFactory.getLogger(CustomTestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        log.info("Test class started: ".toUpperCase() + result.getTestClass().getName());
        log.info("Test started: ".toUpperCase() + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //makeScreenshot();
        log.info("Test SUCCESS: ".toUpperCase() + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
        log.info("Test FAILED: ".toUpperCase() + result.getName());
        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        System.out.println("Try to take a screenshot");

        return ((TakesScreenshot) getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}
