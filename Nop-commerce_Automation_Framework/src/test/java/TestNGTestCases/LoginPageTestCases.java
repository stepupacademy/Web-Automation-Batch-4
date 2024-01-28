package TestNGTestCases;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTestCases extends BaseTest {

    @Test (priority = 1)
    public void verifySuccessfulLoginWithValidCredentials() throws Exception {
        homePage.clickOnLoginButton();
        LoginPage loginpage = new LoginPage(driver);
        loginpage.sendEmail("mahmed.mrmr1562255@gmail.com");
        loginpage.sendPassword("mahmd123456789");
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
