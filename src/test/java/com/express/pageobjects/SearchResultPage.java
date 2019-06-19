package com.express.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.express.framework.web.PageObjectBase;

public class SearchResultPage extends PageObjectBase {

//    private final String LABEL_RESULT_ID ="total-products";
    private final String LABEL_RESULT_XPATH ="//div[@class='grid__cell']/div";
    private final String CELL_RESULT_XPATH ="//div[contains(@class,'ProductCardLite_wrapper__')]";
    private final String SKU_LABEL_XPATH="//span[@data-testid='styleNumber']";
    private final String ITEM_PREVIEW_XPATH="//li[contains(@class,'slide--visible')]/div[contains(@class,'slideInner')]/div";
    private final String BUTTON_ADD_TO_BAG_XPATH="//button[contains(@class,'AddToCartButton_button')]";
    private final String BUTTON_VIEW_MY_BAG_XPATH="//button[contains(@class,'AddToCartContainer_successButton')]";
    

//    @FindBy(id = LABEL_RESULT_ID)
//    private WebElement labelResult;
    
    @FindBy(xpath = LABEL_RESULT_XPATH)
    private WebElement labelResult;
    
    @FindBy(xpath = CELL_RESULT_XPATH)
    private List<WebElement> cardResultList;   
  
    @FindBy(xpath = SKU_LABEL_XPATH)
    private WebElement skuMessage;
    
    @FindBy(xpath = ITEM_PREVIEW_XPATH)
    private WebElement itemPreview;
    
    @FindBy(xpath = BUTTON_ADD_TO_BAG_XPATH)
    private WebElement buttonAddToBag;
    
    @FindBy(xpath = BUTTON_VIEW_MY_BAG_XPATH)
    private WebElement buttonViewMyBag;
   
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean searchLabelResult() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(LABEL_RESULT_XPATH));
    }
    
    public boolean isDisplayedGridResult() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(CELL_RESULT_XPATH));
    }
    
    public String getFoundItems() {
    //	getWebDriverUtils().waitSeconds(5); just demo proposal
    	return labelResult.getText();
    }  
    
    public String getSkuItem() {
    	return skuMessage.getText();
    }

    public void selectFirstItem() {
    	click(cardResultList.get(0));//itemPreview
    	getWebDriverUtils().waitForElementToBeClickable(itemPreview);
//    	getWebDriverUtils().waitSeconds(5);
    }    
    
    public void selectColor(String color) {
    	WebElement itemColor=getDriver().findElement(By.xpath("//span[@class='_1e1-L' and @title='"+color+"']"));
    	scrollDownToElement(itemColor);
    	click(itemColor);
    } 
    
    public void selectSize(String size) {
    	WebElement itemSize=getDriver().findElement(By.xpath("//button[@value='"+size+"']/span"));
    	click(itemSize);
    }
    
    public void addToBagItem() {
    	scrollDownToElement(buttonAddToBag);
    	click(buttonAddToBag);
    } 
    
    public ShoppingBagPage viewMyBag() {
    	scrollDownToElement(buttonViewMyBag);
    	click(buttonViewMyBag);
    	getDriver().navigate().refresh();
    	return new ShoppingBagPage(getDriver());
    }     
    
    
	@Override
	protected By getPageLocator() {
		return By.xpath(LABEL_RESULT_XPATH);
	}    
    

    

}
