package seleniumproject.ui;

import org.openqa.selenium.WebElement;

public class Link extends BaseUI {

    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {

        getElement().click();
    }
}
