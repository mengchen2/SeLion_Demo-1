package com.symbio.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.MobileReporter;
import com.paypal.selion.testcomponents.mobile.DetailPage;
import com.paypal.selion.testcomponents.mobile.OverviewPage;

public class IOS_Demo {

    @MobileTest(appName = "InternationalMountains")
    @Test
    public void testMethod() throws InterruptedException {
        OverviewPage overview = new OverviewPage();
        DetailPage detail =  new DetailPage();
        
        MobileReporter.log(overview.getNavigationTextUIAStaticText().getValue(), true);
        overview.getMountainOneUIATableCell().tap();
        Thread.sleep(2 * 1000);
        
        MobileReporter.log(overview.getNavigationTextUIAStaticText().getValue(), true);
        Assert.assertEquals(detail.getTextUIAStaticText().getValue().contains("1953"), true);

        detail.getNavigationBackUIAButton().tap();
        Thread.sleep(2 * 1000);
        
        MobileReporter.log(overview.getNavigationTextUIAStaticText().getValue(), true);
        Assert.assertEquals(overview.getMountainTwoUIATableCell().isDisplayed(), true);
        
        MobileReporter.log(overview.getNavigationTextUIAStaticText().getValue(), true);
        overview.getMountainThreeUIATableCell().tap();
        Thread.sleep(2 * 1000);
        
        MobileReporter.log(overview.getNavigationTextUIAStaticText().getValue(), true);        
    }
}
