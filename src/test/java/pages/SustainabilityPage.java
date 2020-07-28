package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtil;
import utilities.SeleniumUtil;

import java.util.ArrayList;
import java.util.List;

public class SustainabilityPage {
    public SustainabilityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='nav-link hasDevice'][contains(text(),'Singapore')]")
    @CacheLookup
    WebElement link_left_pane_singapore;

    @FindBy(xpath = "(//table)[2]")
    @CacheLookup
    WebElement table_feed_the_city_programme;

    @FindBy(xpath = "(//table)[2]/tbody/tr")
    @CacheLookup
    List<WebElement> table_rows_feed_the_city_programme;

    @FindBy(xpath = "(//table)[2]/tbody/tr[1]/td")
    @CacheLookup
    List<WebElement> table_columns_per_rows_feed_the_city_programme;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td")
    @CacheLookup
    List<WebElement> table_columns_feed_the_city_programme;

    public void scoll_to_link_SingporeInLeftPage(WebDriver driver) {
        SeleniumUtil.ScrollToElementUsingJavaScript(driver, link_left_pane_singapore);
    }

    public void click_button_SingaporeInLeftPane(WebDriver driver) {
        //link_left_pane_singapore.click();
        SeleniumUtil.ClickElementUsingJavaScript(driver, link_left_pane_singapore);
    }

    public boolean is_displayed_TableFeedTheCityProgram(WebDriver driver, int seconds) {
        SeleniumUtil.WaitForElementToBeDisplayed(driver, table_feed_the_city_programme, seconds);
        return table_feed_the_city_programme.isDisplayed();
    }

    public boolean add_table_feed_the_city_programme_data_to_excel(String filePath, String sheetName) {
        try {
            ExcelUtil excelUtil = new ExcelUtil();
            List<String> cellValues = new ArrayList<>();
            for (WebElement x : table_columns_feed_the_city_programme) {
                cellValues.add(x.getText());
            }
            excelUtil.addRowsAndColumns(filePath, sheetName, table_rows_feed_the_city_programme.size(), table_columns_per_rows_feed_the_city_programme.size(), cellValues);
        } catch (
                Exception e) {
            return false;
        }
        return true;
    }
}
