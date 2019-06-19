package com.express.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.express.framework.web.PageObjectBase;

public class MyRewardsPage extends PageObjectBase {

    private final String HEADER_MY_REWARDS_XPATH ="//h2[contains(text(),'Reward Challenges')]";
    private final String EARNS_SECTION_XPATH ="//div[contains(@class,'account-card__header')]/div[@class='_2yGpC']";
    private final String EARNS_REWARDS_LABEL_XPATH ="//div[contains(@class,'account-card__header')]/div[@class='_2yGpC']/div/h3";
    private final String EARNS_REWARDS_CARDS_LIST_XPATH ="//div[@class='_2yGpC']/div/div";
    private final String EARNS_REWARDS_MODAL_CLOSE_BUTTON_XPATH ="//section[@class='COVzK']";
  
    @FindBy(xpath = HEADER_MY_REWARDS_XPATH)
    private WebElement headerMyRewards; 
    
    @FindBy(xpath = EARNS_SECTION_XPATH)
    private WebElement earnsSection; 
    
    @FindBy(xpath = EARNS_REWARDS_LABEL_XPATH)
    private WebElement earnsRewardsLabel; 
    
    @FindBy(xpath = EARNS_REWARDS_CARDS_LIST_XPATH)
    private List<WebElement> earnsRewardsCardsList; 
    
    @FindBy(xpath = EARNS_REWARDS_MODAL_CLOSE_BUTTON_XPATH)
    private WebElement earnsRewardsCloseButton; 

   
    public MyRewardsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedHeaderMyRewards() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(HEADER_MY_REWARDS_XPATH));
    }

    public boolean isDisplayedEarnsSection() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(EARNS_SECTION_XPATH));
    }
    
    public boolean isDisplayedEarnsRewardsLabel() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(EARNS_REWARDS_LABEL_XPATH));
    }
    
    public String getTextEarnsRewardsLabel() {
    	return normalText(earnsRewardsLabel);
    }
    
    public boolean validateEarnsRewardsModal() {
    	for(int i=0; i<earnsRewardsCardsList.size();i++) {
    		getWebDriverUtils().waitSeconds(1);
    		scrollDownToElement(earnsRewardsCardsList.get(i));
    		click(earnsRewardsCardsList.get(i).findElement(By.tagName("a")));
        	getWebDriverUtils().waitSeconds(1);
        	earnsRewardsCloseButton.click();
    	}
    	
    	
    	return true;
    }    
       
    
	@Override
	protected By getPageLocator() {
		return By.xpath(HEADER_MY_REWARDS_XPATH);
	}    
    

    

}
