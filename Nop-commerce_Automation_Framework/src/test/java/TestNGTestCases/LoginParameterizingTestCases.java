package TestNGTestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginParameterizingTestCases extends BaseTest {

    @Parameters({"username","password"})
    @Test (priority = 1)
    public void verifySuccessfulLoginWithValidCredentials(String username, String password) throws Exception {
        homePage.clickOnLoginButton();
        LoginPage loginpage = new LoginPage(driver);
        loginpage.sendEmail(username);
        loginpage.sendPassword(password);
        loginpage.clickOnLogInButtonInLoginPage();
        softassert.assertEquals(loginpage.getValidLoginMessage(), "Welcome to our store");
        softassert.assertAll();
    }

    @Test (priority = 2)
    public void verifyUnSuccessfulLoginWithInValidCredentials() throws Exception {
        homePage.clickOnLoginButton();
        LoginPage loginpage = new LoginPage(driver);
        loginpage.sendEmail("mahmed.mrmr1@gmail.com");
        loginpage.sendPassword("mahmd23456789");
        loginpage.clickOnLogInButtonInLoginPage();
        System.out.println(loginpage.getInvalidLoginMessage());
        softassert.assertEquals(loginpage.getInvalidLoginMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
        softassert.assertAll();
    }
}
