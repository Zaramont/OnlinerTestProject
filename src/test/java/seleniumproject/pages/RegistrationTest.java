package seleniumproject.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    public void registerUserWithDifferentPasswords() {
        HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
        homePage.openPage();

        LoginPage loginPage = homePage.loginClick();
        loginPage.clickRegistrationTab();
        loginPage.registerAs("Testdev@gmail.com", "TestPwd1", "TestPwd2");

        Assert.assertTrue(loginPage.getErrorMessageText().contains("Пароли не совпадают"),"Сообщение 'Пароли не совпадают' не отображено на странице");
    }
}
