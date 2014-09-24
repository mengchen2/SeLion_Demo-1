package com.paypal.selion.testcomponents.SeLion_Demo;

import com.paypal.selion.platform.html.TextField;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.reports.runtime.WebReporter;


public class OfficialAppleStorePageExt extends OfficialAppleStorePage {
	
	public OfficialAppleStorePageExt() {
		super();
	}
	
	public OfficialAppleStorePageExt(String sitelocal){
		super(sitelocal);
	}
	/**
	 * Search an item with Search bar, and go to the result by press 'Enter'
	 * 
	 * @param search The item needs to be searched out.
	 */
	public void search(String search) {
		
		//Validate iStore opened.
		//validatePage();
		
		//Click the Search Button
		if (getSearchSubmitButton().isElementPresent()) {
		clickSearchSubmitButton(getSiteSearchQueryTextField());
		}
		//Define the text field
	    TextField asearch = getSiteSearchQueryTextField();

	    //Thread will wait until TextFiled element present in the browser
	    WebDriverWaitUtils.waitUntilElementIsPresent(asearch.getLocator());

	    //Search for the string 'imac' in the text box
	    asearch.type(search+"\n");
	    WebReporter.log("Search for the string 'imac' in the text box", true, true);
	}

}
