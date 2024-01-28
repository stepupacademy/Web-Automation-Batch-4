package TestNGTestCases;

import org.testng.annotations.Test;
import pages.RegisterationPage;

public class RegisterPageTestCases extends BaseTest{

    @Test (priority = 1)
    public void verifySuccessfulRegisterWithValidData() throws Exception {
        homePage.clickOnRegisterButton();
        RegisterationPage registerationPage= new RegisterationPage(driver);
        registerationPage.clickOnFemaleButton();
        registerationPage.sendFirstName("mohamed");
        registerationPage.sendLastName("mohamed");
        registerationPage.sendEmail("mahmed.mrmr1562255@gmail.com");
        registerationPage.sendDayOfBirth("9");
        registerationPage.sendMonthOfBirth("October");
        registerationPage.sendYearOfBirth("2001");
        registerationPage.sendCompany("amazon");
        registerationPage.clickOnNewSLetter();
        registerationPage.sendPasswordInRegisterPage("mahmd123456789");
        registerationPage.sendConfirmPassword("mahmd123456789");
        registerationPage.clickOnRegisterButtonInRegisterPage();
        softassert.assertEquals(registerationPage.getWelcomeMessage(), "Your registration completed");
        softassert.assertAll();
    }
    
    @Test (priority = 2)
    public void verifyUnSuccessfulRegisterWithEmailAlreadyRegistered() throws Exception {
        homePage.clickOnRegisterButton();
        RegisterationPage registerationPage= new RegisterationPage(driver);
        registerationPage.clickOnFemaleButton();
        registerationPage.sendFirstName("mohamed");
        registerationPage.sendLastName("mohamed");
        registerationPage.sendEmail("mahmed.mrmr1562255@gmail.com");
        registerationPage.sendDayOfBirth("9");
        registerationPage.sendMonthOfBirth("October");
        registerationPage.sendYearOfBirth("2001");
        registerationPage.sendCompany("amazon");
        registerationPage.clickOnNewSLetter();
        registerationPage.sendPasswordInRegisterPage("mahmd123456789");
        registerationPage.sendConfirmPassword("mahmd123456789");
        registerationPage.clickOnRegisterButtonInRegisterPage();
        softassert.assertEquals(registerationPage.getInvalidRegisterMessage() , "The specified email already exists");
        softassert.assertAll();
    }
}
