package com.paypal.SeLion_Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.platform.mobile.android.SeLionAndroidBridgeDriver;
import com.paypal.selion.platform.mobile.android.UiObject;
import com.paypal.selion.platform.utilities.WebDriverWaitUtils;
import com.paypal.selion.testcomponents.mobile.Home.AppOnboardingPage;
import com.paypal.selion.testcomponents.mobile.Home.HomePage;
import com.paypal.selion.testcomponents.mobile.Home.LegalPage;
import com.paypal.selion.testcomponents.mobile.Home.SignUpPage;
import com.paypal.selion.testcomponents.mobile.Home.TutorialPage;
import com.paypal.selion.testcomponents.mobile.Home.VeniceLoginPage;


@Test(singleThreaded = true)
@MobileTest
public class AndroidDemoTest {
	private LegalPage legalPage;
	private TutorialPage tutorialPage;
	private SignUpPage signUpPage;
	private HomePage homePage;
	private VeniceLoginPage venicePage;
	private AppOnboardingPage appOnboardingPage;

	@BeforeClass
	private void initialize() {
		legalPage = new LegalPage();
		tutorialPage = new TutorialPage();
		signUpPage = new SignUpPage();
		homePage = new HomePage();
		venicePage = new VeniceLoginPage();
		appOnboardingPage = new AppOnboardingPage();

	}
	
	@Test()
	private void signInTest()   {		
		
		UiObject yearPickerObject = new UiObject("android:id/month_text_view");
		UiObject AcceptButtonObject = new UiObject("serviceagreement_accept");
		
		WebDriverWaitUtils.waitUntilElementIsVisible(tutorialPage.getClosetutorialButton());
		tutorialPage.getClosetutorialButton().tap(legalPage.getServieceAgreementLabel());
		//WebDriverWaitUtils.waitUntilElementIsPresent(serviceAgreementList);
		
		for (int i=0; i<30 ; i++) {
			if (AcceptButtonObject.isEnabled()) {
				break;
			}
			SeLionAndroidBridgeDriver.class.cast(Grid.driver()).swipe(20, 500, 20, 10);
		}
		
		legalPage.getAcceptButton().tap(signUpPage.getUserinfoFirstNameTextField());
		
		signUpPage.getUserinfoFirstNameTextField().setText("abcd");
		signUpPage.getUserinfoLastNameTextField().setText("efdg");
		Grid.driver().navigate().back();
		signUpPage.getUserinfoAgeTextField().tap();
		signUpPage.getDataPickerYearLabel().tap();
		
		for (int i=0; i<100 ; i++) {
			yearPickerObject.swipeDown();
			if (yearPickerObject.getText().contains("1995")) {
				yearPickerObject.tap();
				break;
			}
		}

		signUpPage.getDataPickerOkButton().tap();
		
		signUpPage.getUserinfoEmailTextField().setText("abombcm@163.com");
		
		signUpPage.getUserinfoSubmitButton().tap(homePage.getSliderImage());
		homePage.getGridIconLabel().tap(venicePage.getVeniceEmailAddressTextField());
		venicePage.getVeniceEmailAddressTextField().setText("BR-activity-01@paypal.com");
		venicePage.getVenicePasswordTextField().setText("11111111");
		venicePage.getVeniceLoginButton().tap(appOnboardingPage.getAppOnboardingTextField());
		appOnboardingPage.getAppOnboardingTextField().setText("123456789");
		appOnboardingPage.getAppOnboardingButton().tap();
	}
	


}
