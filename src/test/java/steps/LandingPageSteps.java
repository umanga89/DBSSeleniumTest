package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LandingPage;
import utilities.BaseUtil;
import utilities.Constants;

public class LandingPageSteps {
    LandingPage landingPage;
    WebDriver driver = BaseUtil.driver;

    public LandingPageSteps()
    {
        landingPage = new LandingPage(driver);
        BaseUtil.logger = LogManager.getLogger(LandingPageSteps.class.getName());
    }

    @Given("user is in landing page")
    public void user_is_in_landing_page() {
        try{
            Assert.assertEquals(driver.getTitle(), Constants.LANDING_PAGE_TITLE);
            BaseUtil.logger.log(Level.INFO,"User is in landing page");
            BaseUtil.takeScreenShot(BaseUtil.driver,"User is in landing page");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @When("user clicks on Learn More button")
    public void user_clicks_on_Learn_More_button() {
        try{
            BaseUtil.logger.log(Level.INFO,"User clicking on Learn More button under DBS Group tab");
            landingPage.click_button_DbsGroupLearnMore(driver, 10);
            BaseUtil.logger.log(Level.INFO,"User clicked on Learn More button under DBS Group tab");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }
}
