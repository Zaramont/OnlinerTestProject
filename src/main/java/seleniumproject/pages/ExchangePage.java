package seleniumproject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import seleniumproject.ui.Button;
import seleniumproject.ui.TextInput;
import seleniumproject.ui.TextLabel;

import java.math.BigDecimal;

public class ExchangePage extends BasePage {
    @FindBy(id = "amount-in")
    private WebElement currencyAmountInput;
    @FindBy(xpath = ".//*[@id='converter-in']/li/label[@class='state-2']")
    private WebElement buyButton;
    @FindBy(xpath = ".//*[@id='converter-in']/li/label[@class='state-1']")
    private WebElement sellButton;
    @FindBy(id = "currency-in")
    private WebElement fromDropDown;
    @FindBy(id = "currency-out")
    private WebElement toDropDown;
    @FindBy(xpath = ".//li/i/p/b")
    private WebElement exchangeRateLabel;
    @FindBy(xpath = "//b[@class='js-cur-result']")
    private WebElement resultLabel;

    public ExchangePage(WebDriver driver) {
        super(driver);
    }

    private ExchangePage selectCurrencyDropDownFrom(String currency) {

        WebElement dropDownValue = fromDropDown.findElement(
                By.ByXPath.xpath("option[@value='" + currency + "']"));
        dropDownValue.click();
        return this;
    }

    private ExchangePage selectCurrencyDropDownTo(String currency) {
        WebElement dropDownValue = toDropDown.findElement(
                By.ByXPath.xpath("option[@value='" + currency + "']"));
        dropDownValue.click();
        return this;
    }
    @Step("Click Buy button.")
    public void buyCurrency(String fromCurrency, String toCurrency, String amount) {
        Button buy = new Button(buyButton);
        buy.click();
        selectCurrencyDropDownFrom(fromCurrency);
        selectCurrencyDropDownTo(toCurrency);
        typeCurrencyValue(amount);

    }
    @Step("Click Sell button.")
    public void sellCurrency(String from, String to, String amount) {
        sellButton.click();
        selectCurrencyDropDownFrom(from);
        selectCurrencyDropDownTo(to);
        typeCurrencyValue(amount);
    }
    @Step("Enter currency value.")
    private void typeCurrencyValue(String amount) {
        TextInput textInput = new TextInput(currencyAmountInput);

        textInput.clearInput();
        textInput.sendKeys(amount);
    }
    @Step("Check equality.")
    public SoftAssert isCurrencyResultsEquals() {
        TextLabel result = new TextLabel(resultLabel);
        TextLabel exchange = new TextLabel(exchangeRateLabel);
        TextInput currencyValue = new TextInput(currencyAmountInput);
        SoftAssert convertionAssert = new SoftAssert();


        BigDecimal sumValue = new BigDecimal(result.getValue()
                .replace(',', '.'));
        BigDecimal exchangeRate = new BigDecimal(exchange.getValue()
                .replace(',', '.'));
        BigDecimal amount = new BigDecimal(currencyValue.getAttribute("value")
                .replace(" ", ""));

        BigDecimal actualValue = exchangeRate.multiply(amount);
        convertionAssert.assertTrue((actualValue.compareTo(sumValue))==0,
                "Error with convertation. Expected value = " + sumValue + " actual value = " + actualValue);
        return convertionAssert;
    }
}
