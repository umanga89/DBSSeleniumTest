package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AboutUsPage;
import pages.AwardsAndAccoladesPage;
import pages.LandingPage;
import utilities.BaseUtil;
import utilities.Constants;

import java.util.List;
import java.util.Map;

public class AwardsAndAccoladesPageSteps {
    AwardsAndAccoladesPage awardsAndAccoladesPage;
    WebDriver driver = BaseUtil.driver;

    public AwardsAndAccoladesPageSteps()
    {
        awardsAndAccoladesPage = new AwardsAndAccoladesPage(driver);
        BaseUtil.logger = LogManager.getLogger(AwardsAndAccoladesPageSteps.class.getName());
    }

    @Then("user verifies that Awards & Accolades page is displayed")
    public void user_verifies_that_Awards_Accolades_page_is_displayed() {
        try{
            Assert.assertEquals(driver.getTitle(), Constants.AWARDS_AND_ACCOLADES_PAGE_TITLE);
            BaseUtil.logger.log(Level.INFO,"User is in awards & accolades page");
            BaseUtil.takeScreenShot(BaseUtil.driver,"User is in awards & accolades page");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user verifies that total number of wards displayed is {int}")
    public void user_verifies_that_total_number_of_wards_displayed_is(int awardsCount) {
        try{
            Assert.assertEquals(awardsAndAccoladesPage.get_count_AwardsDisplayed(), awardsCount);
            BaseUtil.logger.log(Level.INFO,"User is in awards & accolades page");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user verifies following awards displayed in page")
    public void user_verifies_following_awards_displayed_in_page(io.cucumber.datatable.DataTable awardsTable) {
        try{
            BaseUtil.logger.log(Level.INFO,"Validating awards displayed with caption value");
            List<Map<String, String>> customerInfoList = awardsTable.asMaps();
            for(Map x:customerInfoList){
                Assert.assertTrue(awardsAndAccoladesPage.validateAwardNameAndCaption(driver,x.get("Award Name").toString(),x.get("Caption of the award").toString()));
                BaseUtil.logger.log(Level.INFO,"Validated awards:"+x.get("Award Name")+" with caption:"+x.get("Caption of the award"));
            }
            BaseUtil.logger.log(Level.INFO,"Validated awards displayed with caption value");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }
}
