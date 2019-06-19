package com.express.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.express.framework.web.PageObjectBase;

public class HomePage extends PageObjectBase {

    private final String SEARCH_ID ="searchExpress";
//    private final String SEARCH_ID ="header-search-field";
    private final String FOOTER_LOGO_XPATH ="//a[@href='/?footer']";
    private final String LOGIN_XPATH ="//a[@href='/login']";

    @FindBy(id = SEARCH_ID)
    private WebElement SearchInput;
    
    @FindBy(xpath = FOOTER_LOGO_XPATH)
    private WebElement footerLogo;
    
    @FindBy(xpath = LOGIN_XPATH)
    private WebElement loginButton;  

   
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void searchItemFromMain() {
    	String url=getUrl().replace("mobile/search", "mobile?storeID=00123");
    	getDriver().get(url);
    } 

    public SearchResultPage searchItem(String item) {
        typeOnField(SearchInput, item);
        SearchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(getDriver());
    }   
    
    public LoginPage clickLoginButton() {
    	click(loginButton);
        return new LoginPage(getDriver());
    }  
    
    
	  @Override
	  protected By getPageLocator() {
	      return By.xpath(FOOTER_LOGO_XPATH);
	  }    
    
}
