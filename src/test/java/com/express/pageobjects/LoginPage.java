package com.express.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.express.framework.web.PageObjectBase;

public class LoginPage extends PageObjectBase {

    private final String INPUT_EMAIL_ID ="login-form-email-addr";
    private final String INPUT_PASS_NAME ="password";
    private final String BUTTON_SIGN_IN_XPATH ="//button[@type='submit']";
 

    @FindBy(id = INPUT_EMAIL_ID)
    private WebElement emailAddressInput;
    
    @FindBy(name = INPUT_PASS_NAME)
    private WebElement passwordInput;   
  
    @FindBy(xpath = BUTTON_SIGN_IN_XPATH)
    private WebElement signInButton; 

   
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage loginSite(String user, String pass) {
    	typeOnField(emailAddressInput,user);
    	typeOnField(passwordInput,pass);
    	click(signInButton);
    	return new MyAccountPage(getDriver());    	
    }

	@Override
	protected By getPageLocator() {
		return By.xpath(BUTTON_SIGN_IN_XPATH);
	}    
    

    

}
