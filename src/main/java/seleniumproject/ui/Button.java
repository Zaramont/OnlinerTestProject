package seleniumproject.ui;

import org.openqa.selenium.WebElement;

public class Button extends BaseUI {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        getElement().click();
    }

    public void submit() {
        getElement().submit();
    }
}
