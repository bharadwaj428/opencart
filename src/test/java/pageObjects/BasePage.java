package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	JavascriptExecutor executor;
	Wait<WebDriver> wait40;
	public BasePage(WebDriver driver){
		this.driver=driver;
		this.executor=(JavascriptExecutor)driver;
		this.wait40=new WebDriverWait(this.driver,Duration.ofSeconds(40));
		PageFactory.initElements(driver,this);
	}

}
