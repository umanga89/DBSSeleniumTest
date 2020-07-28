package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtil;

import java.util.List;

public class AwardsAndAccoladesPage {

    public WebDriver driver;

    public AwardsAndAccoladesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //xpath for identifying each award text
    ////strong[contains(text(),'Global Finance')]//ancestor::div/p[contains(text(),'Best Bank in the World 2018')]
    @FindBy(xpath = "//a[contains(text(),'Who We Are')]")
    @CacheLookup
    WebElement tab_who_we_are;

    @FindBy(xpath = "//div//img[contains(@src,'awards-accolades')]")
    @CacheLookup
    List<WebElement> images_all_awards;

    public int get_count_AwardsDisplayed(){
        return images_all_awards.size();
    }

    public boolean validateAwardNameAndCaption(WebDriver driver, String awardName, String caption){
        return driver.findElement(By.xpath("//strong[contains(text(),'"+awardName+"')]//ancestor::div/p[contains(text(),\""+caption+"\")]")).isDisplayed();
    }
}
