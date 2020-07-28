package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {

    public static void ClickElementUsingJavaScript(WebDriver driver, WebElement element)
    {
        try
        {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        }
        catch (NoSuchElementException e)
        {
            throw e;
        }
    }

    public static boolean WaitForElementToBeClickable(WebDriver driver, WebElement element, int seconds)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }
        catch(NoSuchElementException ex)
        {
            throw ex;
        }
    }

    public static boolean WaitForElementToBeDisplayed(WebDriver driver, WebElement element, int seconds)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch(NoSuchElementException ex)
        {
            throw ex;
        }
    }

    public static void ScrollToElementUsingJavaScript(WebDriver driver, WebElement element)
    {
        try
        {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0]. scrollIntoView(true);", element);
        }
        catch (NoSuchElementException e)
        {
            throw e;
        }
    }
}
