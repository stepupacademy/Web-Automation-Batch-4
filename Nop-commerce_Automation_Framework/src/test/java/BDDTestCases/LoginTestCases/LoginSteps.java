package BDDTestCases.LoginTestCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    HomePage homePage;
    LoginPage loginpage;
    @Given("user navigate to login page")
    public void userNavigateToLoginPage() throws Exception {
        homePage = new HomePage(LoginRunner.driver);
        homePage.clickOnLoginButton();
        loginpage = new LoginPage(LoginRunner.driver);
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) throws Exception {
        loginpage.sendEmail(username);
        loginpage.sendPassword(password);
    }

    @Then("Welcome message appears")
    public void welcomeMessageAppears() throws Exception {
        LoginRunner.softAssert.assertEquals(loginpage.getValidLoginMessage(), "Welcome to our store");
        LoginRunner.softAssert.assertAll();
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() throws Exception {
        loginpage.clickOnLogInButtonInLoginPage();
    }

    @Then("Error message appears")
    public void errorMessageAppears() throws Exception {
        LoginRunner.softAssert.assertEquals(loginpage.getInvalidLoginMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                        "The credentials provided are incorrect");
        LoginRunner.softAssert.assertAll();
    }
}
