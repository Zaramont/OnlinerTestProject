package seleniumproject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumproject.utils.DriverFactory;

public class BasePage {

    //private static final Integer TIMEOUTINSECONDS = 120;
    protected String url;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, TIMEOUTINSECONDS);
        this.action = new Actions(driver);
        this.url = "http://www.onliner.by";//ConfigUtil.getProperty("url");

    }
    @Step("Open homepage.")
    public void openPage() {
        getDriver().get(url);

    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
