package seleniumproject.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import seleniumproject.utils.ExcelDataProvider;

public class ExchangeTest extends BaseTest {

    @Test(dataProvider = "excelSheetNameAsMethodName", dataProviderClass = ExcelDataProvider.class)
    public void testCurrencyConvertion(String fromCurrency, String toCurrency, String amount) {

        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.openPage();

        ExchangePage exchangePage = homePage.currencyConverterClick();
        exchangePage.buyCurrency(fromCurrency, toCurrency, amount);

        exchangePage.isCurrencyResultsEquals().assertAll();
    }
}
