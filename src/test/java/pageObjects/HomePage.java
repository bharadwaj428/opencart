package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement lnkMyaccount;
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin;
	
	public void clickMyAccount() {
		//executor.executeScript("arguments[0].click()", lnkMyaccount);
		//wait40.until(ExpectedConditions.elementToBeClickable(lnkMyaccount));
		lnkMyaccount.click();
	}
	

	public void clickRegister() {
		lnkRegister.click();
		//executor.executeScript("arguments[0].click()",lnkRegister);
		//wait40.until(ExpectedConditions.elementToBeClickable(lnkRegister));
	}
	
	public void clickLogin() {
		//lnkLogin.click();
		executor.executeScript("arguments[0].click()", lnkLogin);
	}
}
