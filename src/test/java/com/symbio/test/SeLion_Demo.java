package com.symbio.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.uiautomation.ios.logging.WebDriverLog;

import com.paypal.selion.annotations.WebTest;
import com.paypal.selion.platform.dataprovider.YamlDataProvider;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.WebReporter;
import com.paypal.selion.testcomponents.SeLion_Demo.OfficialAppleStorePageExt;
import com.paypal.selion.testcomponents.SeLion_Demo.ImacAppleStorePageExt;
import com.paypal.selion.testcomponents.SeLion_Demo.ImacBuyImacDesktopComputorsAppleStorePage;
import com.paypal.selion.testcomponents.SeLion_Demo.ImacPriceHighToLowPageExt;
import com.paypal.selion.testcomponents.SeLion_Demo.ConfigAppleStorePageExt;
import com.paypal.selion.testcomponents.SeLion_Demo.CartAppleStorepageExt;

public class SeLion_Demo {
  /**
   * This test case launches the google URL in the browser and search  for the
   * string “SeLion”
   */
	
	@DataProvider(name = "yamlDataProvider")
	public Object[][] simpleDataProvider() throws Exception {
	  String[][] data = new String[2][1];
	  
	  data[0][0] = "CN";
	  data[1][0] = "US";
	  
	  return data;
	}
	
   //Constant
	private OfficialAppleStorePageExt		appleStorePage	 = 	null;
	private ImacAppleStorePageExt		shopmac 	=		null;   
	private ImacBuyImacDesktopComputorsAppleStorePage 	buymac		=	null;
	private ConfigAppleStorePageExt			configure		=		null;
	private ImacPriceHighToLowPageExt          hightolow       =       null;
	private CartAppleStorepageExt		cart	=	null;
	
	
	
  @Test(dataProvider = "yamlDataProvider")
  @WebTest
  public void DemoTest1(String locale) throws InterruptedException {
	appleStorePage = new OfficialAppleStorePageExt(locale);
	shopmac = new ImacAppleStorePageExt(locale);
	buymac = new ImacBuyImacDesktopComputorsAppleStorePage(locale);
	configure = new ConfigAppleStorePageExt(locale);
	hightolow = new ImacPriceHighToLowPageExt(locale);
	cart = new  CartAppleStorepageExt(locale);
		
    //Launch the google URL in the browser
    Grid.driver().get("http://store.apple.com"+'/'+locale.toLowerCase());
    
   
     //Put imac to search bar, and go to the result page
    appleStorePage.search("imac");
    
    //Sort the result items by High to low
    shopmac.sort(hightolow.getItemlistClearfixUnveilGridViewContainer());
    //Go through all items, skip the ones with refurbished product, then click the first new product on the item img.
    hightolow.selectFirstNonRefurbish(buymac.getFirstModelLink());
    
    //Select the first product model, and check configure page opened
    buymac.clickFirstModelLink(configure.getValueMaterializerSummaryLink().getLocator());
    
    //Change some model configure, and check price changes
    configure.assertSummary();
    //Click button Add to Cart
    configure.addToCart(cart.getItemsInYourCartContainer());
    //Confirm the note 'Your item is added to cart.'

    //Verify the note 'items added to cart' and both items added to cart with correct number.
    cart.itemsAddedToCart();
    
  }
}