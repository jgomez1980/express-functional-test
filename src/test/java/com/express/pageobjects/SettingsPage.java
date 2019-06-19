package com.express.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.express.framework.web.PageObjectBase;

public class SettingsPage extends PageObjectBase {

    private final String SHIPPING_ADDRESSS_CARD_XPATH ="//h2[contains(text(),'Shipping Address')]";
    private final String LOGIN_AND_SECURITY_CARD_XPATH ="//h2[contains(text(),'Login & Security')]";
    private final String PAYMENT_OPTIONS_CARD_XPATH ="//h2[contains(text(),'Payment Options')]";
    private final String PROFILE_CARD_XPATH ="//h2[contains(text(),'Profile')]";
 
  
    @FindBy(xpath = SHIPPING_ADDRESSS_CARD_XPATH)
    private WebElement shippingAddressCard; 
    
    @FindBy(xpath = LOGIN_AND_SECURITY_CARD_XPATH)
    private WebElement loginAndSecurityCard; 
    
    @FindBy(xpath = PAYMENT_OPTIONS_CARD_XPATH)
    private WebElement paymentOptionsCard; 
    
    @FindBy(xpath = PROFILE_CARD_XPATH)
    private WebElement profileCards; 

   
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedShippingAddressCard() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(SHIPPING_ADDRESSS_CARD_XPATH));
    }

    public boolean isDisplayedLoginAndSecurityCard() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(LOGIN_AND_SECURITY_CARD_XPATH));
    }
    
    public boolean isDisplayedPaymentOpctionsCard() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(PAYMENT_OPTIONS_CARD_XPATH));
    }
    
    public boolean isDisplayedProfileCard() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(PROFILE_CARD_XPATH));
    }
       
	@Override
	protected By getPageLocator() {
		return By.xpath(PROFILE_CARD_XPATH);
	}    
    

    

}
