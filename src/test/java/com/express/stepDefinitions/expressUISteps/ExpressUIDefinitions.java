package com.express.stepDefinitions.expressUISteps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.express.framework.utils.WebDriverUtils;
import com.express.pageobjects.HomePage;
import com.express.pageobjects.LoginPage;
import com.express.pageobjects.MyAccountPage;
import com.express.pageobjects.MyRewardsPage;
import com.express.pageobjects.SearchResultPage;
import com.express.pageobjects.SettingsPage;
import com.express.pageobjects.ShoppingBagPage;
import com.express.stepDefinitions.Hooks;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExpressUIDefinitions {

    private WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    SearchResultPage searchResultPage;
    MyRewardsPage myRewardsPage;
    SettingsPage settingsPage;
    ShoppingBagPage shoppingBagPage;
 
    public ExpressUIDefinitions() {
        this.driver = Hooks.getwebDriver();
    }
    
    /*EXPRESS*/
    
    @Given("^I am on the home page of Express\\.com$")
    public void i_am_on_the_home_page_of_Express_com() throws Throwable {
    	WebDriverUtils.initializePageInstance(driver);
        homePage = new HomePage(driver);
    }
    
    @Given("^I am on search page$")
    public void i_am_on_search_page() throws Throwable {
    	WebDriverUtils.initializePageInstance(driver);
        homePage = new HomePage(driver);
    }

    @Given("^I am on main screen page$")
    public void i_am_on_main_screen_page() throws Throwable {
    	WebDriverUtils.initializePageInstance(driver);
        homePage = new HomePage(driver);
        homePage.searchItemFromMain();
    }
    
    @When("^login as valid next user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login_as_valid_next_user_with_and(String user, String pass) throws Throwable {
    	loginPage=homePage.clickLoginButton();
    	myAccountPage=loginPage.loginSite(user, pass); 	
    }    
    
    @Then("^the site displays the progress bar within the Account Overview section\\.$")
    public void the_site_displays_the_progress_bar_within_the_Account_Overview_section() throws Throwable {
    	Assert.assertTrue("Progress bar section is not displayed",myAccountPage.isDisplayedProgressBarUntilAListUser());
    }     
    
    @When("^I search a \"([^\"]*)\" on the serch box$")    
    public void i_search_a_on_the_serch_box(String item) throws Throwable {
    	searchResultPage=homePage.searchItem(item);
    }
    
    @When("^select the first item found$")
    public void select_the_first_item_found() throws Throwable {
    	searchResultPage.selectFirstItem();
    }

    @When("^select color \"([^\"]*)\" and size \"([^\"]*)\"$")
    public void select_color_and_size(String color, String size) throws Throwable {
    	searchResultPage.selectColor(color);
    	searchResultPage.selectSize(size);
    }   
    
    @When("^add to bag selected item$")
    public void add_to_bag_selected_item() throws Throwable {
    	searchResultPage.addToBagItem();
    }

    @When("^go to view my bag$")
    public void go_to_view_my_bag() throws Throwable {
    	shoppingBagPage=searchResultPage.viewMyBag();
    }
    
    @Then("^The site displays all items that match with the criteria$")
    public void the_page_show_all_items_that_match_with_the_criterion() throws Throwable {
    	Assert.assertTrue("Search Result Page was not displayed",searchResultPage.searchLabelResult());
    	Assert.assertTrue("Grid result was not displayed",searchResultPage.isDisplayedGridResult());
    }    
    
    @Then("^the number of results of the search is \"([^\"]*)\"$")
    public void the_number_of_results_of_the_search_is(String amount) throws Throwable {
    	Assert.assertTrue("The number of items found does not match the search",searchResultPage.getFoundItems().contains(amount));
    }

    @Then("^the item found contains the SKU \"([^\"]*)\"$")
    public void the_item_found_contains_the_SKU(String item) throws Throwable {
    	Assert.assertTrue("The SKU is not displayed",searchResultPage.getSkuItem().contains(item));
    }
    
    @Then("^the site displays My account page$")
    public void the_site_show_My_account_page() throws Throwable {
    	Assert.assertTrue("Account Panel is not displayed",myAccountPage.isDisplayedAccountPanel());
    }    
 
    @Then("^the site displays Account Overview section$")
    public void the_site_show_Account_Overview_section() throws Throwable {
    	Assert.assertTrue("Get started section is not displayed",myAccountPage.isDisplayedGetStartedSection());
    	Assert.assertTrue("Points Histtory section is not displayed",myAccountPage.isDisplayedPointsHistorySection());
    	Assert.assertTrue("Rewards Available section is not displayed",myAccountPage.isDisplayedRewardsAvailableSection());
    	Assert.assertTrue("Bonus Points section is not displayed",myAccountPage.isDisplayedBonusPointsSection());
    	Assert.assertTrue("Express Credit Card section is not displayed",myAccountPage.isDisplayedExpressCreditCardSection());    
    }
    
    @When("^select Earn Points navigation item$")
    public void select_Earn_Points_item() throws Throwable {
    	myRewardsPage=myAccountPage.selectEarnPoints();
    }

    @Then("^the site displays Earn Points section$")
    public void the_site_display_Earn_Points_section() throws Throwable {
    	Assert.assertTrue("Header My Rewards is not displayed",myRewardsPage.isDisplayedHeaderMyRewards());
    	Assert.assertTrue("Earns Section is not displayed",myRewardsPage.isDisplayedEarnsSection());
    }
 
    @Then("^the site displays Earn Rewards label with text \"([^\"]*)\"$")
    public void the_site_displays_Earn_Rewards_label_with_text(String label) throws Throwable {
    	Assert.assertTrue("Earns Rewards label is not displayed",myRewardsPage.isDisplayedEarnsRewardsLabel());
    	Assert.assertTrue("Earns Rewards label is not correct",myRewardsPage.getTextEarnsRewardsLabel().contains(label));
    }
    
    @Then("^select each Earns cards the site displays Earn Rewards modal with rewards information$")
    public void the_site_displays_Earn_Rewards_modal_with_rewards_information() throws Throwable {
    	myRewardsPage.validateEarnsRewardsModal();
    }
    

    
    @When("^select setting navigation item$")
    public void select_Setting_navigation_item() throws Throwable {
    	settingsPage=myAccountPage.selectSettings();
    }

    @Then("^the site displays settings page$")
    public void the_site_displays_settings_page() throws Throwable {
    	Assert.assertTrue("Shipping Address Card is not displayed",settingsPage.isDisplayedShippingAddressCard());
    	Assert.assertTrue("Login And Security Card is not displayed",settingsPage.isDisplayedLoginAndSecurityCard());
    	Assert.assertTrue("Payment Opctions Card is not displayed",settingsPage.isDisplayedPaymentOpctionsCard());
    	Assert.assertTrue("Profile Card is not displayed",settingsPage.isDisplayedProfileCard());
    }    
    
    
    // using BagId
    @Given("^I create a bag$")
    public void i_create_a_bag() throws Throwable {
        System.out.println("Create session");
        System.out.println("Create bag");
    }

    @When("^add the bag to cart$")
    public void add_the_bag_to_cart() throws Throwable {
    	System.out.println("Add to bag");
    }

    @When("^navigate to shopping bag page for \"([^\"]*)\"$")
    public void navigate_to_shopping_bag_page_for(String bagId) throws Throwable {
    	shoppingBagPage=new ShoppingBagPage(driver);
    	shoppingBagPage.goToShoppingPage(bagId);
//    	shoppingBagPage.isDisplayedShoppingBagLabel();
    }
    
    @Then("^Shopping Bag page is displayed for \"([^\"]*)\"$")
    public void shopping_Bag_page_is_displayed(String bagId) throws Throwable {
    	shoppingBagPage=new ShoppingBagPage(driver);
    	shoppingBagPage.goToShoppingPage(bagId);
    	shoppingBagPage.isDisplayedShoppingBagLabel();   	
    }
    
    @Then("^Shopping Bag page is displayed$")
    public void shopping_Bag_page_is_displayed() throws Throwable {
    	shoppingBagPage.isDisplayedShoppingBagLabel();
    }
    
    @Then("^the bag item displays the name \"([^\"]*)\" the quantity \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void the_bag_item_displays_the_name_the_quantity_and_price(String name, String quantity, String totalPrice) throws Throwable {
    	Assert.assertTrue("The product name is not correct",shoppingBagPage.getProductName().contains(name));
    	Assert.assertTrue("The product quantity is not correct",shoppingBagPage.getProductQuantity().contains(quantity));
    	Assert.assertTrue("The product total price is not correct",shoppingBagPage.getProductPrice().contains(totalPrice));

    }
    
    @Then("^the bag item displays for the item \"([^\"]*)\" the quantity \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void the_bag_item_displays_for_the_item_the_quantity_and_price(String name, String quantity, String totalPrice) throws Throwable {
    	Assert.assertTrue("The product name is not correct",shoppingBagPage.getItemInformation(name, "ItemName").contains(name));
    	Assert.assertTrue("The product quantity is not correct",shoppingBagPage.getItemInformation(name, "Qty").contains(quantity));
    	Assert.assertTrue("The product total price is not correct",shoppingBagPage.getItemInformation(name, "Price").contains(totalPrice));
    }
    
    @Then("^bag summary displays subtotal \"([^\"]*)\" the shipping \"([^\"]*)\" and tax \"([^\"]*)\"$")
    public void bag_summary_displays_subtotal_the_shipping_and_tax(String priceSubTotal, String shipping, String tax) throws Throwable {
    	Assert.assertTrue("The product sub total price is not correct",shoppingBagPage.getBagSummaryRow("Subtotal").contains(priceSubTotal));
    	Assert.assertTrue("The product shipping is not correct",shoppingBagPage.getBagSummaryRow("Shipping").contains(shipping));
    	Assert.assertTrue("The product tax is not correct",shoppingBagPage.getBagSummaryRow("Tax").contains(tax));
    }
}
