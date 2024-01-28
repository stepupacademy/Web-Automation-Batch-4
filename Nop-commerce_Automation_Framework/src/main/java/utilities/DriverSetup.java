package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup
{
    public static WebDriver driver;
    public static void chromeDriverInitiate(String urlTxt) {
        System.setProperty(
                "webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/driverbinaries/chromedriver.exe");
        driver.get(urlTxt);
        driver.manage().window().maximize();
    }
    public static WebDriver driverInitiate(String browser,String urlTxt)
    {
        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("Browser is not Supported");
        }
        driver.manage().window().maximize();
        driver.get(urlTxt);
        return driver;
    }
}
