package seleniumproject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SearchPage extends BasePage {

    By productTitleLocator = By.ByXPath.xpath("//div[@class='search__content-wrapper']//div[@class='result__wrapper']//a[@class='product__title-link']");
    //@FindBy(xpath = ".//*[@id='fast-search-modal']/div/div/iframe")
    By iframeLocator = By.ByXPath.xpath(".//*[@id='fast-search-modal']/div/div/iframe");
    //private WebElement iframe;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @Step("Check results of search.")
    public SoftAssert checkResultContainsText(String searchText) {
        SoftAssert softAssert = new SoftAssert();
        getDriver().switchTo().frame(getDriver().findElement(iframeLocator)/*iframe*/);
        List<WebElement> productTitleList = getDriver()
                .findElements(productTitleLocator);

        softAssert.assertTrue(!productTitleList.isEmpty(), "Result list is empty");

        for (WebElement productTitle : productTitleList) {
            String title = productTitle.getText();
            softAssert.assertTrue(title.contains(searchText),
                    "Product title text doesn`t contains the product" +
                            " title text from reviews page. Expected value = " + title + " actual value = " + searchText);
        }
        return softAssert;
    }
}
