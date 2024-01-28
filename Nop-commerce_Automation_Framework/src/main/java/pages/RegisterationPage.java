package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class RegisterationPage extends BasePage{

    By femaleButton= By.xpath("//input[@id=\"gender-female\"]");
    By maleButton=By.xpath("//input[@id=\"gender-male\"]");
    By firstName=By.xpath("//input[@id=\"FirstName\"]");
    By lastName=By.xpath("//input[@id=\"LastName\"]");
    By dayOfBirth =By.xpath("//select[@name=\"DateOfBirthDay\"]");
    By monthOfBirth=By.xpath("//select[@name=\"DateOfBirthMonth\"]");
    By yearOfBirth=By.xpath("//select[@name=\"DateOfBirthYear\"]");
    By emailBox=By.xpath("//input[@name=\"Email\"]");
    By companyBox=By.xpath("//input[@name=\"Company\"]");
    By newsLetter=By.xpath("//input[@name=\"Newsletter\"]");
    By passwordBox=By.xpath("//input[@name=\"Password\"]");
    By confirmPasswordBox=By.xpath("//input[@name=\"ConfirmPassword\"]");
    By registerButtonSubmit =By.xpath("//button[@id=\"register-button\"]");
    By welcomeMessage=By.xpath("//div[@class=\"result\"]");
    By invalidRegisterMessage=By.xpath("//div[@class=\"message-error validation-summary-errors\"]//ul//li[text()=\"The specified email already exists\"]");
    public RegisterationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFemaleButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(femaleButton,driver);
    }

    public void clickOnMaleButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(maleButton,driver);
    }

    public void sendFirstName(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,firstName,driver);
    }


    public void sendLastName(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,lastName,driver);
    }


    public void sendEmail(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,emailBox,driver);
    }

    public void sendDayOfBirth(String text){
        BrowserActions.waitAndSelectFromDropdown(text,dayOfBirth,driver);
    }

    public void sendMonthOfBirth(String text){
        BrowserActions.waitAndSelectFromDropdown(text,monthOfBirth,driver);
    }

    public void sendYearOfBirth(String text){
        BrowserActions.waitAndSelectFromDropdown(text,yearOfBirth,driver);
    }

    public void sendCompany(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,companyBox,driver);
    }

    public void clickOnNewSLetter() throws Exception {
        BrowserActions.waitAndClickOnWebElement(newsLetter,driver);
    }

    public void sendPasswordInRegisterPage(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,passwordBox,driver);
    }

    public void sendConfirmPassword(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,confirmPasswordBox,driver);
    }

    public void clickOnRegisterButtonInRegisterPage() throws Exception {
        BrowserActions.waitAndClickOnWebElement(registerButtonSubmit,driver);
    }
    public String getWelcomeMessage() throws Exception {
        return BrowserActions.waitAndGetWebElementText(welcomeMessage,driver);
    }
    public String getInvalidRegisterMessage() throws Exception {
        return BrowserActions.waitAndGetWebElementText(invalidRegisterMessage,driver);
    }
}
