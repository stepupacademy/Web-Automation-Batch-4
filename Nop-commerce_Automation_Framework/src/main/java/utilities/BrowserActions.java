package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BrowserActions {
    private static final int timeOut = 20;

    public static void waitUntilWebElementIsPresent(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }

    public static void waitUntilWebElementIsNotPresent(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }

    public static void waitUntilWebElementIsEnabled(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }

    public static void waitAndClickOnWebElementUsingJavaScript(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            WebElement ele = driver.findElement(element);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", ele);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on webElement: " + element.toString(),e);
        }

    }
    public static void waitAndClickOnWebElement(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).click();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not click on webElement: " + element.toString(),e);
            }
    }

    public static void waitAndEnterTextInWebElement(String text, By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(text);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not enter text in webElement: " + element.toString(),e);
            }
    }

    public static void waitAndClearTextIbWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            driver.findElement(element).clear();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not clear text in webElement: " + element.toString(),e);
        }
    }
    public static void waitAndEnterTextInWebElementAndThenPressEnter(String text, By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(text);
                driver.findElement(element).sendKeys(Keys.ENTER);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not enter text in webElement: " + element.toString(),e);
            }
    }

    public static String waitAndGetWebElementText(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            String webElementText;
            try {
                webElementText = driver.findElement(element).getText();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not get text from webElement: " + element.toString(),e);
            }
            return webElementText;
    }

    public static boolean isWebElementPresent(By element, WebDriver driver){
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            boolean found;
            try {
                driver.findElement(element);
                found = true;
            } catch (Exception ex) {
                found = false;
            }
            return found;
    }

    public static void switchToFrameById(String ID, WebDriver driver) throws Exception {
            try {
                driver.switchTo().frame(ID);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Frame is not found by id: " + ID,e);
            }
    }

    public static void switchToMainWindow(WebDriver driver) throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Default Frame is not Found",e);
        }

    }


    public static void waitAndSelectFromDropdown(String value, By element, WebDriver driver){
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                Select dropdownElement = new Select(driver.findElement(element));
                dropdownElement.selectByVisibleText(value);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }


    public static void waitAndHoverOverElement(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                WebElement webElement = driver.findElement(element);
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement).perform();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not hover on webElement: " + element.toString(),e);
            }
    }


    public static void scrollIntoView(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                WebElement webElement = driver.findElement(element);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);

            } catch (Exception e) {
                System.out.println(element);
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not scroll to webElement: " + element.toString(),e);
            }
    }

    public static void removeSurveyPopup(WebDriver driver) {
        By surveyElement = By.id("kampyleInviteContainer");
        List<WebElement> surveyPopup = driver.findElements(surveyElement);
        if (surveyPopup.size() > 0) {
            String popupInjectionScript = "document.getElementById('kampyleInviteContainer').remove()";
            ((JavascriptExecutor) driver).executeScript(popupInjectionScript);
        }
    }
}
