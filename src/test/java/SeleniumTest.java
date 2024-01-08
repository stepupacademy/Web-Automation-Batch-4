import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SeleniumTest {
    @Test
    public void start()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void start1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void navigateTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://google.com/");
        driver.navigate().to("https://youtube.com/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/");
        driver.quit();
    }

    @Test
    public void checkSearch()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        By searchTextBox = By.id("small-searchterms");
        driver.findElement(searchTextBox).sendKeys("Test");
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();
        WebElement searchResult = driver.findElement(By.xpath("//div[@class=\"no-result\"]"));
        String expectedResult="No products were found that matched your criteria.";
        String actualResult = searchResult.getText();
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void editAndDeleteFromTable1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        rows.get(2).findElement(By.xpath("//a[@href=\"#edit\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#edit");
    }

    @Test
    public void editAndDeleteFromTable2()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[2]//a[@href=\"#delete\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#delete");
    }

    @Test
    public void editAndDeleteFromTableWithEmail()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
        String email = "jdoe@hotmail.com";
        // xpaths :
                    // table[@id="table1"]//td[text()="jdoe@hotmail.com"]/following::a[2]
                    //table[@id="table1"]//td[text()="jdoe@hotmail.com"]/parent::tr//a[@href="#delete"]
                    //table[@id="table1"]//td[text()="jdoe@hotmail.com"]//ancestor::tr//a[@href="#delete"]
        driver.findElement(By.xpath("//table[@id='table1']//td[text()="+email+"]/..//a[@href='#delete']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/tables#delete");
    }
    @Test
    public void verifyLinks()
    {
        SoftAssert softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        softAssert.assertEquals(links.size(),46);
        for (WebElement link: links) {
            System.out.println(link.getAttribute("href"));
        }
        softAssert.assertAll();
    }
}
