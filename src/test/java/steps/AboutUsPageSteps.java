package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AboutUsPage;
import pages.LandingPage;
import utilities.BaseUtil;
import utilities.Constants;

public class AboutUsPageSteps {
    LandingPage landingPage;
    AboutUsPage aboutUsPage;
    WebDriver driver = BaseUtil.driver;

    public AboutUsPageSteps()
    {
        landingPage = new LandingPage(driver);
        aboutUsPage = new AboutUsPage(driver);
        BaseUtil.logger = LogManager.getLogger(AboutUsPageSteps.class.getName());
    }

    @When("user clicks on About in header tabs")
    public void user_clicks_on_About_in_header_tabs() {
        try{
            BaseUtil.logger.log(Level.INFO,"User clicking on About Us button in header tab");
            landingPage.click_button_AboutUsInNavigationBar();
            BaseUtil.logger.log(Level.INFO,"User clicked on About Us button in header tab");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user is navigated to About page")
    public void user_is_navigated_to_About_page() {
        try{
            Assert.assertEquals(driver.getTitle(), Constants.ABOUT_US_PAGE_TITLE);
            BaseUtil.logger.log(Level.INFO,"User is in about us page");
            BaseUtil.takeScreenShot(BaseUtil.driver,"User is in about us page");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @When("user clicks on Who we are tab in About page")
    public void user_clicks_on_Who_we_are_tab_in_About_page() {
        try{
            BaseUtil.logger.log(Level.INFO,"User clicking on Who We Are Tab");
            aboutUsPage.click_button_WhoWeAreTab(driver,10);
            BaseUtil.logger.log(Level.INFO,"User clicked on Who We Are Tab");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user verifies that Who we are section is displayed")
    public void user_verifies_that_Who_we_are_section_is_displayed() {
        try{
            Assert.assertEquals(aboutUsPage.is_displayed_ButtonOurAwardsAndAccolades(driver,10), true);
            BaseUtil.logger.log(Level.INFO,"User is in Who We Are tab in About Us page");
            BaseUtil.takeScreenShot(BaseUtil.driver,"User is in Who We Are tab in About Us page");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @When("user clicks on Our Awards & Accolades section in Who we are tab")
    public void user_clicks_on_Our_Awards_Accolades_section_in_Who_we_are_tab() {
        try{
            BaseUtil.logger.log(Level.INFO,"User clicking on Our Awards & Accolades section in Who We Are Tab");
            aboutUsPage.click_button_OurAwardsAndAccolades(driver,10);
            BaseUtil.logger.log(Level.INFO,"User clicked on Our Awards & Accolades section in Who We Are Tab");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }
}
