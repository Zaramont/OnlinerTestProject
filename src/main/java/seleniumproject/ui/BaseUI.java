package seleniumproject.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumproject.utils.DriverFactory;

public class BaseUI{

    private Integer TIMEOUTINSECONDS = 15;
    private WebElement webElement;
    private Actions action;


    protected BaseUI(WebElement webElement) {
        this.webElement = webElement;
        this.action = new Actions(DriverFactory.getDriver());
    }

    protected WebElement getElement() {
        return (new WebDriverWait(DriverFactory.getDriver(), TIMEOUTINSECONDS)).until(ExpectedConditions.visibilityOf(webElement));
    }
    protected Actions getAction() {
        return this.action;
    }
}
