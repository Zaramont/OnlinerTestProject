package seleniumproject.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextInput extends BaseUI {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String message) {

        WebElement textField = getElement();
        Actions textAction = getAction();

        textAction.moveToElement(textField)
                .click()
                .sendKeys(Keys.DELETE)
                .build()
                .perform();
        textField.sendKeys(message);

    }
    public void clearInput(){
        getElement().clear();
        getAction().moveToElement(getElement())
                .click()
                .sendKeys(Keys.DELETE)
                .sendKeys(Keys.DELETE)
                .build()
                .perform();
    }
    public void submit() {
        getElement().submit();
    }
    public String getAttribute(String value) {
        return getElement().getAttribute(value);
    }
}
