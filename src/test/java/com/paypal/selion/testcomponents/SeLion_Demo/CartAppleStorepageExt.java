package com.paypal.selion.testcomponents.SeLion_Demo;

import junit.framework.Assert;

public class CartAppleStorepageExt extends CartAppleStorepage{
	
	public CartAppleStorepageExt() {
		super();
	}
	
	public CartAppleStorepageExt(String sitelocal){
		super(sitelocal);
	}
	/*
	 * Verify the note 'items added to cart'.
	 * Verify both items added to cart with correct number.
	 */
	public void itemsAddedToCart(){
    validatePage();
    Assert.assertEquals("1", getCartProductItemOneNumberTextField().getValue());
    Assert.assertEquals("1", getCartProductItemTwoNumberTextField().getValue());
	}
}
