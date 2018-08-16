package seleniumproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import seleniumproject.listeners.CustomTestListener;
import seleniumproject.utils.DriverFactory;
import org.testng.annotations.Listeners;


@Listeners(CustomTestListener.class)
public class BaseTest {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true, description = "Init driver")
    protected void initDriver(String browser) {
        System.out.println("init driver");
        System.out.println(browser);
        DriverFactory.getDriverByType(browser);
    }

    @AfterClass(alwaysRun = true, description = "Quit driver")
    protected void quitDriver() {
        getDriver().quit();
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
