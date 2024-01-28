package TestNGTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.DriverSetup;

public class BaseTest {
    WebDriver driver;
    SoftAssert softassert;
    HomePage homePage;
    @BeforeMethod
    public void driversSetUp(){
        driver = DriverSetup.driverInitiate("chrome","https://demo.nopcommerce.com/");
        softassert = new SoftAssert();
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void driverClose(){
        driver.close();
    }
}
