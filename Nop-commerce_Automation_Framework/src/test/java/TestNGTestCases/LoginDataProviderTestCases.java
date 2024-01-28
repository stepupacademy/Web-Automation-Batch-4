package TestNGTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginDataProviderTestCases extends BaseTest {

    @DataProvider(name="InvalidLoginData")
    public Object[][] provideLoginData()
    {
        return new Object[][] {
                {"user1","password1"},
                {"",""},
        };
    }
    @Test(dataProvider = "InvalidLoginData")
    public void verifyUnSuccessfulLoginWithInValidCredentials(String username, String password) throws Exception {
        homePage.clickOnLoginButton();
        LoginPage loginpage = new LoginPage(driver);
        loginpage.sendEmail(username);
        loginpage.sendPassword(password);
        loginpage.clickOnLogInButtonInLoginPage();
        System.out.println(loginpage.getInvalidLoginMessage());
        softassert.assertEquals(loginpage.getInvalidLoginMessage(),
                "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect");
        softassert.assertAll();
    }
}
