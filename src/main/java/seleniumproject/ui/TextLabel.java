package seleniumproject.ui;

import org.openqa.selenium.WebElement;

public class TextLabel extends BaseUI {

    public TextLabel(WebElement webElement) {
        super(webElement);
    }

    public String getValue() {
        return getElement().getText();
    }
}
