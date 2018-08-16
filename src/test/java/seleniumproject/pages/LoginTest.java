package seleniumproject.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void logIn() {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.openPage();

        LoginPage loginPage = homePage.loginClick();
        loginPage.loginAs("test@tut.by", "УточкаДелаетКряКря");

        loginPage.userLoggedIn().assertAll();
    }
}
