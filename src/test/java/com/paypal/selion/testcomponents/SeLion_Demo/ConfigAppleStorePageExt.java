package com.paypal.selion.testcomponents.SeLion_Demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.lift.Matchers;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.WebReporter;
import com.thoughtworks.selenium.Selenium;

import junit.framework.Assert;


public class ConfigAppleStorePageExt extends ConfigAppleStorePage {
	


	public ConfigAppleStorePageExt() {
		super();
	}
	
	public ConfigAppleStorePageExt(String sitelocal){
		super(sitelocal);
	}
	 
	/**
	 * Get the default summary price, and then change configure of one hardware and one accessory,
	 * check the new price, compare it with default. 
	 * @throws InterruptedException 
	 */
	public void assertSummary() throws InterruptedException{
    //Get current Summary price. $1,999.00 --> 1999
	int current;
    if (getValueMaterializerSummaryLink().getText().contains("RMB")){
    	current = 4;
    }
    else{
    	current = 1;
    }
				
    String before = getValueMaterializerSummaryLink().getText().substring(current).replace(",", "").replace(".00", "");
    Integer value_before = Integer.parseInt(before);

    //Click the second radio button of first hardware config.
    clickHardwareFirstItemSecondRadioButton();
    
    //Click the second radio button of first accessories config.
    clickAccessoriesFirstItemSecondRadioButton();
    Thread.sleep(2000);
    //Get updated Summary price.
    String after = getValueMaterializerSummaryLink().getText().substring(current).replace(",", "").replace(".00", "");
    Integer value_after = Integer.parseInt(after);
    
    //Validate price has been updated.
    Assert.assertNotSame(value_after, value_before);
	}
	
	
/*	public void ptrim(String sprice){
	String regEx="\\p+"; 
	Pattern p=Pattern.compile(regEx);
	Matcher m=p.matcher(sprice);
	String s=m.replaceAll("");
	}*/
	
	/**
	 * 
	 * @param nextPage is the expected Object of nextpage, for validation.
	 * Click the addToCart button, and see next page opened.
	 */
	
    public void addToCart(Object... nextPage){
	//Click Add to Cart, and check the item added to cart.
    clickAddToCartButton(nextPage);
    }
}
