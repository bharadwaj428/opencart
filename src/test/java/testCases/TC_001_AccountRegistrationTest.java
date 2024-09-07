package testCases;
import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void verify_account_registeration() throws InterruptedException {
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		logger.debug("This is a debug log message.");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on My Account Link");
		hp.clickMyAccount();
		logger.info("CLicked on Register Link");
		hp.clickRegister();
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Provide Customer Details..");
		rp.setFirstname(randomeString().toUpperCase());
		rp.setLastname(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"@gmail.com");
		rp.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.clickBtnYes();
		rp.chkBoxAgree();
		rp.clickBtnContinue();
		Thread.sleep(2000);
		logger.info("Validating Excepted Confirmation Message");
		String confmsg=rp.getConfirmationMsg();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("Test Passed....");
		}
		else {
			logger.error("Test failed..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail("Test failed..."+e.getMessage());
		}
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}
	}
	
}
