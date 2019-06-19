package com.express.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.express.framework.web.PageObjectBase;

public class MyAccountPage extends PageObjectBase {


    private final String ACCOUNT_PANEL_XPATH ="//div[@class='_1PwBj']";
    private final String GET_STARTED_SECTION_XPATH ="//section[contains(@class,'account-card__content')]";
    private final String POINTS_HISTORY_SECTION_XPATH ="//div[contains(@class,'_33FQU')]";
    private final String REWARDS_AVAILABLE_SECTION_XPATH ="//div[contains(@class,'dDpYR')]";
    private final String BONUS_POINT_SECTION_XPATH ="//div[contains(@class,'_2cqLZ')]";
    private final String EXPRESS_CREDIT_CARD_SECTION_XPATH ="//div[contains(@class,'_1iyLm')]";
    private final String EARN_POINTS_MENU_ITEM_XPATH ="//a[contains(text(),'Earn Points')]";
    private final String SETTINGS_MENU_ITEM_XPATH ="//a[contains(text(),'Settings')]";
    private final String PROGRESS_BAR_CLASSNAME ="_3QtZE";
    
    
    @FindBy(xpath = ACCOUNT_PANEL_XPATH)
    private WebElement accountPanel; 
    
    @FindBy(xpath = GET_STARTED_SECTION_XPATH)
    private WebElement getStartedSection;     

    @FindBy(xpath = POINTS_HISTORY_SECTION_XPATH)
    private WebElement pointsHistorySection;   
    
    @FindBy(xpath = REWARDS_AVAILABLE_SECTION_XPATH)
    private WebElement rewardsAvailableHistorySection; 
    
    @FindBy(xpath = BONUS_POINT_SECTION_XPATH)
    private WebElement bonusPointSection; 
   
    @FindBy(xpath = EXPRESS_CREDIT_CARD_SECTION_XPATH)
    private WebElement expressCreditCardSection; 
    
    @FindBy(className = PROGRESS_BAR_CLASSNAME)
    private WebElement progressBar; 
  
    @FindBy(xpath = EARN_POINTS_MENU_ITEM_XPATH)
    private WebElement earnPointsMenuItem;
    
    @FindBy(xpath = SETTINGS_MENU_ITEM_XPATH)
    private WebElement settingsMenuItem;
   
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedAccountPanel() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(ACCOUNT_PANEL_XPATH));
    }
    
    public boolean isDisplayedGetStartedSection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(GET_STARTED_SECTION_XPATH));
    }
    
    public boolean isDisplayedPointsHistorySection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(POINTS_HISTORY_SECTION_XPATH));
    }    
    
    public boolean isDisplayedRewardsAvailableSection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(REWARDS_AVAILABLE_SECTION_XPATH));
    }    
    
    public boolean isDisplayedBonusPointsSection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(BONUS_POINT_SECTION_XPATH));
    }     

    public boolean isDisplayedExpressCreditCardSection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(EXPRESS_CREDIT_CARD_SECTION_XPATH));
    } 
    
    public boolean isDisplayedProgressBarUntilAListUser() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.className(PROGRESS_BAR_CLASSNAME));
    } 
    
    public MyRewardsPage selectEarnPoints() {
    	scrollDownToElement(earnPointsMenuItem);
    	click(earnPointsMenuItem);
    	return new MyRewardsPage(getDriver());    	
    }  
    
    public SettingsPage selectSettings() {
    	scrollDownToElement(settingsMenuItem);
    	click(settingsMenuItem);
    	return new SettingsPage(getDriver());    	
    }      
    
	@Override
	protected By getPageLocator() {
		return By.xpath(ACCOUNT_PANEL_XPATH);
	}    
    

    

}
