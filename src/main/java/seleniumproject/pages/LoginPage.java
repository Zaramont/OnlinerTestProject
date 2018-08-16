package seleniumproject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import seleniumproject.ui.Button;
import seleniumproject.ui.Link;
import seleniumproject.ui.TextInput;
import seleniumproject.ui.TextLabel;

public class LoginPage extends BasePage {
    private static final Integer sleepDuration = 2000;
    @FindBy(xpath = ".//*[@id='auth-container__forms']/div/div/form/div/div[@class='auth-box__line']/input")
    private WebElement usernameInput;
    @FindBy(xpath = ".//*[@id='auth-container__forms']/div/div/form/div/div[@class='auth-box__line'][2]/input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//*[@id='auth-container__forms']/div/div/form/div/div[@class='auth-box__line'][3]/input")
    private WebElement passwordConfirmationInput;
    @FindBy(xpath = ".//*[@id='auth-container__forms']/div/div/form//button")
    private WebElement loginButton;
    @FindBy(xpath = ".//*[@id='auth-container__forms']//*[@class='auth-box__switcher']/div[2]")
    private WebElement loginTab;
    @FindBy(xpath = ".//*[@id='auth-container__forms']//*[@class='auth-box__switcher']/div[2]")
    private WebElement registrationTab;
    @FindBy(xpath = ".//*[@id='userbar']/div/div/a[@href='https://profile.onliner.by']")
    private WebElement userbar;
    @FindBy(xpath = ".//*[@id='auth-container__forms']/div/div/form//div/div[@class='auth-box__line auth-box__line--error js-error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        TextInput textInput = new TextInput(usernameInput);
        textInput.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        TextInput textInput = new TextInput(passwordInput);
        textInput.sendKeys(password);
        return this;
    }

    public LoginPage typeRegistrationPassword(String password, String passwordConfirmation) {
        TextInput textInput = new TextInput(passwordInput);
        TextInput textInputConfirmation = new TextInput(passwordConfirmationInput);

        textInput.sendKeys(password);
        textInputConfirmation.sendKeys(passwordConfirmation);
        return this;
    }

    public HomePage submitLogin() {
        Button login = new Button(loginButton);
        login.click();
        login.submit();
        
        return PageFactory.initElements(getDriver(), HomePage.class);
    }
    @Step()
    public LoginPage clickRegistrationTab() {
        Link link = new Link(registrationTab);
        link.click();
        return this;
    }
    @Step()
    public HomePage registerAs(String username, String password, String passwordConfirmation) {
        typeUsername(username);
        typeRegistrationPassword(password, passwordConfirmation);
        return submitLogin();
    }
    @Step()
    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
    @Step()
    public String getErrorMessageText() {
        TextLabel label = new TextLabel(errorMessage);
        return label.getValue();
    }

    /*public boolean userLoggedIn() {
        return userbar.isDisplayed();
    }*/
    @Step("Check that user logged in.")
    public SoftAssert userLoggedIn() {
        SoftAssert assertForUserbar = new SoftAssert();
        assertForUserbar.assertTrue(userbar.isDisplayed(),"Не удалось залогиниться.");
        return assertForUserbar;
    }
}