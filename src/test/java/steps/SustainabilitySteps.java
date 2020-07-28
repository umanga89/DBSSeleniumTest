package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AboutUsPage;
import pages.SustainabilityPage;
import utilities.BaseUtil;
import utilities.Constants;
import utilities.ExcelUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SustainabilitySteps {

    SustainabilityPage sustainabilityPage = null;
    WebDriver driver = BaseUtil.driver;
    public SustainabilitySteps(){
        sustainabilityPage = new SustainabilityPage(driver);
        BaseUtil.logger = LogManager.getLogger(SustainabilitySteps.class.getName());
    }

    @When("user scrolls down to Singapore on left panel and clicks on it")
    public void scolls_down_to_Singapore_on_left_panel_and_clicks_on_it() {
        try{
            BaseUtil.logger.log(Level.INFO,"Scrolling to Singapore link in left pane");
            sustainabilityPage.scoll_to_link_SingporeInLeftPage(driver);
            BaseUtil.logger.log(Level.INFO,"User clicking on Singapore link in left pane");
            sustainabilityPage.click_button_SingaporeInLeftPane(driver);
            BaseUtil.logger.log(Level.INFO,"User clicked on Singapore link in left pane");
            BaseUtil.takeScreenShot(BaseUtil.driver,"User clicked on Singapore link in left pane");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user sees a table with information about meal distribution for “Feed the City” programme")
    public void user_sees_a_table_with_information_about_meal_distribution_for_Feed_the_City_programme() {
        try{
            Assert.assertEquals(true, sustainabilityPage.is_displayed_TableFeedTheCityProgram(driver, 10));
            BaseUtil.logger.log(Level.INFO,"Feed the City programme table is displayed");
            BaseUtil.takeScreenShot(BaseUtil.driver,"Feed the City programme table is displayed");
        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @When("user adds data in table to an excel sheet")
    public void user_adds_data_in_table_to_an_excel_sheet() {
        try{

            String filePath = BaseUtil.base_directory+BaseUtil.configProperties.getProperty("excel.file.path");
            ExcelUtil excelUtil = new ExcelUtil();

            //Create excel file
            Assert.assertTrue(excelUtil.createExcelFile());

            //Create sheet in excel file
            Assert.assertTrue(excelUtil.addSheet(BaseUtil.configProperties.getProperty("excel.file.sheet.name")));

            //Adding data to sheet in excel file
            sustainabilityPage.add_table_feed_the_city_programme_data_to_excel(filePath,BaseUtil.configProperties.getProperty("excel.file.sheet.name"));

        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }

    @Then("user verifies that excel file is created")
    public void user_verifies_that_excel_file_is_created_with_exact_number_of_rows_and_columns_as_per_table() {
        try{
            Path path = Paths.get(BaseUtil.base_directory+BaseUtil.configProperties.getProperty("excel.file.path"));
            Assert.assertTrue(Files.exists(path));

        }catch(Exception e){
            BaseUtil.logger.log(Level.ERROR,e.getMessage());
            throw e;
        }
    }
}
