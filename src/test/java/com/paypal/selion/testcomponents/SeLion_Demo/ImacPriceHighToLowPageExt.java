package com.paypal.selion.testcomponents.SeLion_Demo;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.paypal.selion.reports.runtime.WebReporter;

public class ImacPriceHighToLowPageExt extends ImacPriceHighToLowPage{

	public ImacPriceHighToLowPageExt() {
		super();
	}
	
	public ImacPriceHighToLowPageExt(String sitelocal){
		super(sitelocal);
	}
	/*
	 * Go through all items, skip the ones with refurbished product, then click the first new product on the item img.
	 */
	
	public void selectFirstNonRefurbish(Object... nextPage){
	     List<WebElement> list= getItemlistClearfixUnveilGridViewContainer().getElements();
	     for(int i = 0;i<list.size();i++){ 
	     	if (getItemlistClearfixUnveilGridViewContainer(i).getCategoryLink().isElementPresent()){
	     	continue;
	     	}

	     	getItemlistClearfixUnveilGridViewContainer(i).getItemImgLink().click(nextPage);
	     	break;
	     }
		
	}
	

}
