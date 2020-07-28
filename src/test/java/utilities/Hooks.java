package utilities;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import listeners.TestListenerImpl;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;

public class Hooks {
    @Before
    public void setup(Scenario scenario) throws IOException {
        try {
            BaseUtil.logger.info("Running " + scenario.getName());

            BaseUtil.browser = BaseUtil.configProperties.getProperty("browser");
            BaseUtil.logger.info("Launching " + BaseUtil.browser + " browser");

            //Launching browser
            BrowserUtil.launchBrowser(BaseUtil.browser);

            BaseUtil.webUrl = BaseUtil.configProperties.getProperty("web.url");
            BaseUtil.logger.info("Navigate to " + BaseUtil.webUrl);

            //Navigating to URL
            BaseUtil.driver.navigate().to(BaseUtil.webUrl);
            BaseUtil.logger.info("Navigating to " + BaseUtil.webUrl);

            BaseUtil.message = scenario;
        } catch (Exception e) {
            throw e;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                BaseUtil.takeScreenShot(BaseUtil.driver, scenario.getName());
            } catch (Exception e) {

            }
        }
        BaseUtil.logger.info("Test completed for scenario: " + scenario.getName());
        BaseUtil.logger.info("Closing all browser windows");
        BaseUtil.driver.quit();
    }
}
