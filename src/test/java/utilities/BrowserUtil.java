package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserUtil {

    public static void launchBrowser(String browserType)
    {
        switch (browserType)
        {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", BaseUtil.base_directory + BaseUtil.configProperties.getProperty("chrome.driver.path"));
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("--ignore-certificate-errors");
                BaseUtil.driver = new ChromeDriver(cOptions);
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver", BaseUtil.base_directory + BaseUtil.configProperties.getProperty("firefox.driver"));
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.addArguments("--ignore-certificate-errors");
                BaseUtil.driver = new FirefoxDriver(ffOptions);
                break;
            default:
                throw new RuntimeException("browser is not specified");
        }
        BaseUtil.driver.manage().window().maximize();
    }
}
