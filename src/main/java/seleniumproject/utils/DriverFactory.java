package seleniumproject.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final String CHROME_BROWSER = "chrome";
    private static final String FIREFOX_BROWSER = "firefox";
    private static final Integer TIMEOUTINSECONDS = 8;
    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriverByType(String browserName) {

        switch (browserName.toLowerCase()) {
            case CHROME_BROWSER:
                return getChromeDriverInstance();
            case FIREFOX_BROWSER:
                return getFirefoxDriverInstance();
            default:
                throw new RuntimeException(String.format("Browser $s not found", browserName));
        }
        // }
    }

    private static WebDriver getChromeDriverInstance() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Onix\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        return initDriver(driver);
    }

    private static WebDriver getFirefoxDriverInstance() {
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver", "C:\\Onix\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        return initDriver(driver);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver initDriver(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(TIMEOUTINSECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
