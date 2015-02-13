package com.symbio.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.asserts.SeLionAsserts;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.MobileReporter;

public class AndroidDemo_FR {

    @Test
    @MobileTest(appName = "org.tomdroid:0.7.5", device = "android19", language="fr", locale="fr_FR")
    public void testLaunchPPHApp_android() throws Exception {
    		RemoteWebDriver driver = Grid.selendroidDriver();
        SeLionAsserts.assertNotNull(driver);
        
        try {
        		WebElement validateButton = driver.findElement(By.id("button3"));
            
            if(validateButton.isDisplayed()) {
            		validateButton.click();
            }
        } catch(Exception ex) {
        		//NOSONAR
        }
        
        
        driver.findElement(By.id("menuNew")).click();
        
        WebElement title = driver.findElement(By.id("title"));
        WebElement content = driver.findElement(By.id("content"));
        
        title.clear();
        content.clear();
        
        title.sendKeys("Symbio SeLion Android Demo");
        content.sendKeys("For the SeLion Demo we want to show that we can write a note in a native Android app.");
        
        driver.findElement(By.id("edit_note_save")).click();
        
        List<WebElement> elements = driver.findElements(By.id("note_title"));
        
        for(WebElement element : elements) {
        		if(element.getText().equals("Symbio SeLion Android Demo")) {
        			element.click();
        			break;
        		}
        }
        
        driver.findElement(By.id("view_note_delete")).click();
        driver.findElement(By.id("button1")).click();
       
    }
}