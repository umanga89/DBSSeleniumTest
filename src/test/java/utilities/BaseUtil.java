package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseUtil {

    public static WebDriver driver;
    public static String webUrl;
    public static String browser;
    public static String base_directory;
    public static Logger logger;
    public static Properties configProperties;
    public static Scenario message;

    public static void takeScreenShot(WebDriver driver,String label) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            message.attach(screenshot, "image/png",label);
    }
}
