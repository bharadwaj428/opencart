package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String username,String Password,String res) {
		logger.info("***** Started TC_003_LoginDDT****");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Clicked MyAccount Link");
		hp.clickMyAccount();
		logger.info("clicked Login Link");
		hp.clickLogin();
		
		logger.info("Provided Username And Password");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(username);
		lp.setPassword(Password);
		logger.info("Clicked Login Button");
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean status=mp.isMyaccountDisplayed();
		
		if(res.equalsIgnoreCase("Valid")) {
			if(status==true) {
				mp.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid")) {
			if(status==true) {
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) {
			Assert.fail("An Exception Occured: "+e.getMessage());
		}
		logger.info("****Ended TC_003_LoginDDT***");
	
	}

}
