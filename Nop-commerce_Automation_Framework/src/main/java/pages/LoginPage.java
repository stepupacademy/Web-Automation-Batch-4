package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class LoginPage extends BasePage{

    By emailBox=By.xpath("//input[@class=\"email\"]");
    By passwordBox=By.xpath("//input[@id=\"Password\"]");
    By forgetPasswordButton=By.xpath("//a[text()=\"Forgot password?\"]");
    By rememberMeButton=By.xpath("//input[@id=\"RememberMe\"]");
    By logInButtonSubmit =By.xpath("//button[@class=\"button-1 login-button\"]");
    By registerButtonLoginPage =By.xpath("//button[@class=\"button-1 register-button\"]");
    By welcomeMessage=By.xpath("//div[@class=\"page-title\"]");
    By invalidLoginMessage=By.xpath("//div[@class=\"message-error validation-summary-errors\"]");
    By validLoginMessage=By.xpath("//div//h2[text()=\"Welcome to our store\"]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void sendEmail(String email) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(email,emailBox,driver);
    }


    public void sendPassword(String password) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(password,passwordBox,driver);
    }


    public void clickOnLogInButtonInLoginPage() throws Exception {
        BrowserActions.waitAndClickOnWebElement(logInButtonSubmit,driver);
    }

    public void clickOnRememberMeButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(rememberMeButton,driver);
    }

    public void clickOnForgetPasswordButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(forgetPasswordButton,driver);
    }

    public void clickOnRegisterButtonInLoginPage() throws Exception {
        BrowserActions.waitAndClickOnWebElement(registerButtonLoginPage,driver);
    }

    public String getWelcomeMessageText() throws Exception {
        return BrowserActions.waitAndGetWebElementText(welcomeMessage,driver);
    }

    public String getInvalidLoginMessage() throws Exception {
        return BrowserActions.waitAndGetWebElementText(invalidLoginMessage,driver);
    }

    public String getValidLoginMessage() throws Exception {
        return BrowserActions.waitAndGetWebElementText(validLoginMessage,driver);
    }
}
