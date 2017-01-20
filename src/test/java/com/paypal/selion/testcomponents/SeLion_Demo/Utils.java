package com.paypal.selion.testcomponents.SeLion_Demo;

import io.appium.java_client.android.AndroidDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.html.support.HtmlElementUtils;
import com.paypal.selion.platform.mobile.UIOperationFailedException;
import com.paypal.selion.platform.mobile.android.SeLionAndroidBridgeDriver;
import com.paypal.selion.platform.mobile.android.UiObject;
import com.paypal.selion.platform.mobile.elements.MobileElement;
@SuppressWarnings("unchecked")
/**
 * 
 * @author jesse
 *
 */
public class Utils {

	/**
	 * swipe to element
	 * @param scrollElement
	 * @param targetElement
	 * @throws InterruptedException
	 */
	public static void SwipeUpToElement(UiObject scrollElement,MobileElement targetElement) {
		
		SwipeUpToElement(scrollElement, targetElement,2);
	}
	public static void SwipeUpToElement(UiObject scrollElement,MobileElement targetElement,long delayTimes) {
		
		boolean flag = true;
		
		while(flag){
			try {
				waitUntilElementIsPresent(targetElement.getLocator(),delayTimes);
				flag = false;
			} catch (Exception e) {
				scrollElement.swipeUp();
			}
		}
	}
	
	public static void SwipeUpToElementAndClick(UiObject scrollElement,MobileElement targetElement){
		SwipeUpToElement(scrollElement, targetElement,2);
		targetElement.tap();
	}
	public static void SwipeUpToElementAndClick(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		SwipeUpToElement(scrollElement, targetElement,delayTimes);
		targetElement.tap();
	}
	
	
	
	public static void SwipeDownToElement(UiObject scrollElement,MobileElement targetElement){
		
		SwipeDownToElement(scrollElement, targetElement, 2);
	}
	
	public static void SwipeDownToElementAndClick(UiObject scrollElement,MobileElement targetElement){
		SwipeDownToElement(scrollElement, targetElement, 2);
		targetElement.tap();
	}
	
	public static void SwipeDownToElementAndClick(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		SwipeDownToElement(scrollElement, targetElement, delayTimes);
		targetElement.tap();
	}
	
	public static void SwipeDownToElement(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		
		boolean flag = true;
		
		while(flag){
			try {
				waitUntilElementIsPresent(targetElement.getLocator(),delayTimes);
				flag = false;
			} catch (Exception e) {
				
				scrollElement.swipeDown();
			}
		}
	}
	public static void SwipeLeftToElement(UiObject scrollElement,MobileElement targetElement){
		
		SwipeLeftToElement(scrollElement, targetElement, 2);
	}
	public static void SwipeLeftToElementAndClick(UiObject scrollElement,MobileElement targetElement){
		
		SwipeLeftToElement(scrollElement, targetElement, 2);
		targetElement.tap();
	}
	public static void SwipeLeftToElementAndClick(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		
		SwipeLeftToElement(scrollElement, targetElement, delayTimes);
		targetElement.tap();
	}
	
	
	public static void SwipeLeftToElement(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		
		boolean flag = true;
		
		while(flag){
			try {
				waitUntilElementIsPresent(targetElement.getLocator(),delayTimes);
				flag = false;
			} catch (Exception e) {
				
				scrollElement.swipeLeft();
			}
		}
	}
	public static void SwipeRightToElement(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		SwipeRightToElement(scrollElement, targetElement, 2);
	}
	public static void SwipeRightToElementAndClick(UiObject scrollElement,MobileElement targetElement){
		SwipeRightToElement(scrollElement, targetElement, 2);
		targetElement.tap();
	}
	public static void SwipeRightToElementAndClick(UiObject scrollElement,MobileElement targetElement,long delayTimes){
		SwipeRightToElement(scrollElement, targetElement, delayTimes);
		targetElement.tap();
	}
	public static void SwipeRightToElement(UiObject scrollElement,MobileElement targetElement){
		
		boolean flag = true;
		
		while(flag){
			try {
				waitUntilElementIsPresent(targetElement.getLocator(),2);
				flag = false;
			} catch (Exception e) {
				
				scrollElement.swipeRight();
			}
		}
	}
	
	/**
	 * common operation
	 */
	public static void pressBackKey(){
		
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) Grid.driver();
		driver.pressKeyCode(4);
	}
	public static void pressHomeKey(){
		
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) Grid.driver();
		driver.pressKeyCode(3);
	}
	public static void pressMenuKey(){
		
		AndroidDriver<WebElement> driver = (AndroidDriver<WebElement>) Grid.driver();
		driver.pressKeyCode(82);
	}
	/**
	 * get counts of list
	 * @param element
	 * @param childBy
	 * @return
	 */
	public static int elementCount(MobileElement element,String locator){
		
		List<WebElement> tableCells = null;
		WebElement tableView = null;
		By by = HtmlElementUtils.resolveByType(element.getLocator());
		By childBy = getBy(locator);
		SeLionAndroidBridgeDriver driver = SeLionAndroidBridgeDriver.class.cast(Grid.driver());
		tableView = driver.findElement(by);
		if (childBy == null) {
			throw new UIOperationFailedException("for Android list, cast list to UiList and set the childBy.");
		}
		tableCells = tableView.findElements(childBy);
        return tableCells.size();
	}
	
	public static By getBy(String locator){
		return  HtmlElementUtils.resolveByType(locator);
	}
	
	public static UiObject findElementByText(String name){
		return new UiObject(name);
	}
	
	public static void waitUntilElementIsPresent(final String elementLocator,long timeoutInSeconds) {
        By by = HtmlElementUtils.resolveByType(elementLocator);
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOfElementLocated(by);
        new WebDriverWait(Grid.driver(), timeoutInSeconds).until(condition);
    }
	
	public static boolean waitElement(String elementLocator,long timeoutInSeconds){
		
		try {
			waitUntilElementIsPresent(elementLocator, timeoutInSeconds);
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
