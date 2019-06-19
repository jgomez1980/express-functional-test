package com.express.pageobjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.express.framework.web.PageObjectBase;

public class ShoppingBagPage extends PageObjectBase {


    private final String SHOPPING_BAG_LABEL_XPATH ="//div[contains(@class,'Bag_container')]/div/div/h1";
    private final String PRODUCT_NAME_LABEL_XPATH ="//div[contains(@class,'productcard__content')]";
    private final String PRODUCT_QUANTITY_DROPBOX_XPATH ="//select[@name='quantity']";
    private final String PRODUCT_PRICE_LABEL_XPATH ="//span[contains(@class,'BagItems_totalPrice')]";
    private final String SUMMARY_SECTION_LIST_XPATH ="//div[contains(@class,'Row_row__')]/span";
    private final String PRODUCT_ITEM_LIST_XPATH ="//li[contains(@class,'BagItems_item')]/div";
    
    @FindBy(xpath = SHOPPING_BAG_LABEL_XPATH)
    private WebElement shoppingBagLabel;  
    
    @FindBy(xpath = PRODUCT_NAME_LABEL_XPATH)
    private WebElement productNameLabel; 
    
    @FindBy(xpath = PRODUCT_QUANTITY_DROPBOX_XPATH)
    private WebElement productQuantityDropbox; 
    
    @FindBy(xpath = PRODUCT_PRICE_LABEL_XPATH)
    private WebElement productPriceLabel; 
    
    @FindBy(xpath = SUMMARY_SECTION_LIST_XPATH)
    private List<WebElement> bagSummaryList; 
    
    @FindBy(xpath = PRODUCT_ITEM_LIST_XPATH)
    private List<WebElement> productItemList;

   
    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    public void goToShoppingPage(String bagId) {

    //  //This method adds or creates a cookie
//        public void addCookie(String name, String value, String domain, String path, Date expiry) {
//                driver.manage().addCookie(
//                new Cookie(name, value, domain, path, expiry));
//                }   	
    	String url=getUrl().replace("mobile/search", "bag?bagId=")+bagId;
//    			"https://raven-servers-lb.qa.cloud.express.com/bag?bagId="+bagId;
    	getDriver().get(url);
    	getWebDriverUtils().waitSeconds(3);
    	String domain=getUrl().substring(getUrl().indexOf("/")+2, getUrl().indexOf("bag?bagId=")-1);
        //   add cookie for bag site
    	Cookie bagIdCl =new Cookie.Builder("BAGID",bagId).domain(domain).build();
    	getDriver().manage().addCookie(bagIdCl);
//    	Cookie bagIdLc =new Cookie.Builder("bagId",bagId).domain(domain).build();
//    	getDriver().manage().addCookie(bagIdLc);
    	getDriver().navigate().refresh();
    	getWebDriverUtils().waitSeconds(3);
    }   
    
    public boolean isDisplayedShoppingBagLabel() {
    	return getWebDriverUtils().waitForElementToBeVisible(By.xpath(SHOPPING_BAG_LABEL_XPATH));
    }  
    
    public String getProductName() {
    	return productNameLabel.getText();
    } 
    
    public String getProductQuantity() {
    	Select select = new Select(productQuantityDropbox);
    	return select.getFirstSelectedOption().getText();
    } 
    
    public String getProductPrice() {
//    	System.out.println(productPriceLabel.getText());
    	return productPriceLabel.getText();
    } 
    
    public String getItemInformation(String nameItem, String label) {
    	String name="";
    	String quantity="";
    	String price="";
    	String value="";
        for ( WebElement row:productItemList) { 
        	name=row.findElement(By.xpath("span/section/div[contains(@class,'productcard__content')]")).getText();
        	System.out.println("###NAME "+name);
        	if(name.contains(nameItem)) {       		
        		Select select = new Select(row.findElement(By.xpath("span/select[@name='quantity']")));
        		quantity=select.getFirstSelectedOption().getText();
        		price=row.findElement(By.xpath("div/span[contains(@class,'BagItems_totalPrice')]")).getText();
        		System.out.println("######"+quantity+"###"+price);
        		break;
        	}      	
        }
        switch (label) {        
	        case "ItemName":
	        	value= name;
	        	break;
	        case "Qty":
	        	value= quantity;
	        	break;
	        case "Price":
	        	value= price;
	        	break;	
	        default:
	            break;
	        }
        	
    	return value;
    }
    
    
    public String getBagSummaryRow(String labelRow) {
    	String label="";
        for ( WebElement row: bagSummaryList) { 
        	if(row.getText().equals(labelRow)) {
        		System.out.println("########"+bagSummaryList.get(bagSummaryList.indexOf(row)+1).getText());
        		label=bagSummaryList.get(bagSummaryList.indexOf(row)+1).getText();
        		break;
        	}
        	System.out.println(row.getText());
        	System.out.println(bagSummaryList.indexOf(row));
        }

    	return label;
    } 
    

    
	  @Override
	  protected By getPageLocator() {
	      return By.xpath(SHOPPING_BAG_LABEL_XPATH);
	  }    
    
}
