package testCases;

import testBase.BaseClass;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.HomePage;

public class TC_002_LoginTest extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verify_login_page() {
		logger.info("*****Starting TC_002_LoginTest*****");
		logger.debug("capturing application debug logs....");
		try {
	
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickLogin();
		logger.info("clicked on login link under myaccount..");
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean status=mp.isMyaccountDisplayed();
		Assert.assertEquals(status, true,"login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		/*if(status) {
			mp.clickLogout();
			Assert.assertTrue(status);
		}
		else {
			Assert.assertTrue(status);
		}*/
		logger.info("*****Ending TC_002_LoginTest*****");
		
	}

}
