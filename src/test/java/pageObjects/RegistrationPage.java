package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BasePage{

	public 	RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
//input[@id='input-firstname']
//input[@id='input-lastname']
//input[@id='input-email']
//input[@id='input-telephone']
//input[@id='input-password']
//input[@id='input-confirm']
//label[normalize-space()='Yes']
//input[@name='agree']
//input[@value='Continue']
	 */
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	@FindBy(how=How.XPATH,using="//label[normalize-space()='Yes']") WebElement radbtnYes;
	@FindBy(xpath="//input[@name='agree']") WebElement chkAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	public void setFirstname(String firstName) {
		txtFirstname.sendKeys(firstName);
	}
	
	public void setLastname(String lastName) {
		txtLastname.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String mobileNo) {
		txtTelephone.sendKeys(mobileNo);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setConfirmPassword(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	public void clickBtnYes() {
		radbtnYes.click();
	}
	public void chkBoxAgree() {
		chkAgree.click();
	}
	public void clickBtnContinue() {
		btnContinue.click();
	}
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
}
