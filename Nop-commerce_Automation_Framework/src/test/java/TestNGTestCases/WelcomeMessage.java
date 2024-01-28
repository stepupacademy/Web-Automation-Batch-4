package TestNGTestCases;

import org.testng.annotations.Test;
import pages.LoginPage;

public class WelcomeMessage extends BaseTest {
    @Test
    public void sampleTest1() throws Exception {
        homePage.clickOnLoginButton();
        LoginPage loginpage=new LoginPage(driver);
        softassert.assertEquals(loginpage.getWelcomeMessageText(),"Welcome, Please Sign In!");
        softassert.assertAll();
    }
}
