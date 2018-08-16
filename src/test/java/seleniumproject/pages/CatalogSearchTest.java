package seleniumproject.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class CatalogSearchTest extends BaseTest {

    @Test
    public void checkSearchLogic() {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.openPage();

        SearchPage frame = homePage.sendToSearchInputField("Apple");
        frame.checkResultContainsText("Apple").assertAll();
    }

}
