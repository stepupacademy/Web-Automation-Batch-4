package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class BasePage {
    WebDriver driver;
    By registerButton=By.xpath("//a[@class=\"ico-register\"]");
    By loginButton=By.xpath("//a[@class=\"ico-login\"]");
    By searchTextBox=By.xpath("//input[@id=\"small-searchterms\"]");
    By searchButton=By.xpath("//button[@class=\"button-1 search-box-button\"]");


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(loginButton,driver);
    }
    public void clickOnRegisterButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(registerButton,driver);
    }
    public void enterTextInSearchBox(String text) throws Exception {
        BrowserActions.waitAndEnterTextInWebElement(text,searchTextBox,driver);
    }

    public void clickOnSearchButton() throws Exception {
        BrowserActions.waitAndClickOnWebElement(searchButton,driver);
    }
}
