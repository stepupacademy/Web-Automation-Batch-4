import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserInteractions {

    WebDriver driver;
    @BeforeMethod
    public void start()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void doubleClick()
    {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testHover()
    {
        driver.get("https://the-internet.herokuapp.com/hovers");
        driver.manage().window().maximize();
        WebElement element =driver.findElement(By.xpath("(//img)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        WebElement result = driver.findElement(By.xpath("//a[@href=\"/users/1\"]"));
        Assert.assertEquals(result.getText(),"View profile");
    }

    @Test
    public void testDragAndDrop()
    {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().window().maximize();
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions act=new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
        WebElement result = driver.findElement(By.xpath("//div[@id='bal3']"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void testAlert()
    {
        driver.get("https://cookbook.seleniumacademy.com/Alerts.html");
        driver.manage().window().maximize();
        WebElement btn1 = driver.findElement(By.id("confirm"));
        WebElement btn2 = driver.findElement(By.id("prompt"));
        WebElement result1 = driver.findElement(By.id("demo"));
        WebElement result2 = driver.findElement(By.id("prompt_demo"));
        btn1.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Press a button!");
        alert.accept();
        Assert.assertEquals(result1.getText(),"You Accepted Alert!");
        btn1.click();
        alert.dismiss();
        Assert.assertEquals(result1.getText(),"You Dismissed Alert!");
        btn2.click();
        alert.sendKeys("Kamal");
        alert.accept();
        Assert.assertEquals(result2.getText(),"Hello Kamal! How are you today?");
    }

    @Test
    public void testFrames()
    {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        WebElement element = driver.findElement(By.xpath("//body[@id=\"tinymce\"]//p"));
        System.out.println(element.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void scrollByPixel() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Test
    public void scrollByVisibleElement() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        WebElement Element = driver.findElement(By.linkText("Linux"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    @Test
    public void scrollByPage() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Test
    public void ScrollHorizontally() {
        driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.linkText("VBScript"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
