package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtil;

public class LandingPage {
    public LandingPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='dbs-group']//button[contains(text(),'Learn More')]")
    @CacheLookup
    WebElement button_dbs_group_learn_more;

    @FindBy(xpath = "//div[@class='navbar-links-left']//a[contains(@href,'about-us')]")
    @CacheLookup
    WebElement button_navigation_bar_about_us;

    public void click_button_DbsGroupLearnMore(WebDriver driver, int seconds)
    {
        SeleniumUtil.WaitForElementToBeClickable(driver, button_dbs_group_learn_more,seconds);
        button_dbs_group_learn_more.click();
    }

    public void click_button_AboutUsInNavigationBar()
    {
        button_navigation_bar_about_us.click();
    }
}
