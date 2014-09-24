package com.paypal.selion.testcomponents.SeLion_Demo;



public class ImacAppleStorePageExt extends ImacAppleStorePage{
	
	public ImacAppleStorePageExt() {
		super();
	}
	
	public ImacAppleStorePageExt(String sitelocal){
		super(sitelocal);
	}
	

	
	public void sort(Object... nextPage) {
    //Click the Filter button, check those filter conditions buttons shown
    clickButtonRectSecondarySmallFiltersButton(getPriceHighToLowFilterLink().getLocator());
    
    //Click Price High to Low,
    clickPriceHighToLowFilterLink(nextPage);
    
// List<WebElement> list = shopmac.getItemlistClearfixUnveilGridViewContainer();
//  for(int i=0;i<list.size();i++){
// 	list.get(i).getAttribute(name)
//  	}    
	}
}
