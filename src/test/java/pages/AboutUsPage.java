package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtil;

public class AboutUsPage {

    public WebDriver driver;

    public AboutUsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'Who We Are')]")
    @CacheLookup
    WebElement tab_who_we_are;

    //Elements inside Who We Are tab
    @FindBy(xpath = "//a[contains(text(),'Our Awards & Accolades')]")
    @CacheLookup
    WebElement button_our_awards_and_accolades;

    public void click_button_WhoWeAreTab(WebDriver driver, int seconds)
    {
        SeleniumUtil.WaitForElementToBeClickable(driver, tab_who_we_are,seconds);
        tab_who_we_are.click();
    }

    public boolean is_displayed_ButtonOurAwardsAndAccolades(WebDriver driver, int seconds){
        SeleniumUtil.WaitForElementToBeDisplayed(driver,button_our_awards_and_accolades,seconds);
        return button_our_awards_and_accolades.isDisplayed();
    }

    public void click_button_OurAwardsAndAccolades(WebDriver driver, int seconds)
    {
        SeleniumUtil.WaitForElementToBeClickable(driver, button_our_awards_and_accolades,seconds);
        button_our_awards_and_accolades.click();
    }
}
