package BDDTestCases.LoginTestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import utilities.DriverSetup;
@CucumberOptions(glue = {"BDDTestCases/LoginTestCases"},
        features = {"src/test/java/BDDTestCases/LoginTestCases/login.feature"},
        plugin = {"pretty","html:tsrget/cucumber-html-report"},
        monochrome = true)
public class LoginRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static SoftAssert softAssert;
    @BeforeMethod
    public void invokeBrowser()
    {
        driver = DriverSetup.driverInitiate("chrome","https://demo.nopcommerce.com/");
        softAssert = new SoftAssert();
    }
    @AfterMethod
    public void tearDown()
    {
        softAssert.assertAll();
        driver.quit();
    }
}
