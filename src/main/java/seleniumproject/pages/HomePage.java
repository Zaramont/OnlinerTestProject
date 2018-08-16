package seleniumproject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumproject.ui.Button;
import seleniumproject.ui.Link;
import seleniumproject.ui.TextInput;
public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement searchInputField;
    @FindBy(xpath = ".//*[@id='userbar']/div/div")
    private WebElement enterButton;
    @FindBy(id = "currency-informer")
    private WebElement currencyConverter;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step("Search text.")
    public SearchPage sendToSearchInputField(String text) {
        TextInput textInput = new TextInput(searchInputField);
        textInput.sendKeys(text);
        textInput.submit();
        return PageFactory.initElements(getDriver(), SearchPage.class);
    }
    @Step("Open Login page.")
    public LoginPage loginClick() {
        Button login = new Button(enterButton);
        login.click();
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }
    @Step("Open CurrencyConverter page.")
    public ExchangePage currencyConverterClick() {
        Link link = new Link(currencyConverter);
        link.click();
        return PageFactory.initElements(getDriver(), ExchangePage.class);
    }
}
