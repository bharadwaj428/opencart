package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters({"browser","os"})
	public void setUp(String br,String os) throws IOException, InterruptedException {
		File src = new File("./src/test/resources/config.properties");
        FileInputStream f = new  FileInputStream(src);
		p=new Properties();
		p.load(f);
		logger =LogManager.getLogger(this.getClass());
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--incognito");
		//options.setAcceptInsecureCerts(true);
		if(p.getProperty("exec_env").equalsIgnoreCase("remote")){
			DesiredCapabilities cap=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")){
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")){
				cap.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("Invalid Operating System");
				return;
			}
			switch(br.toLowerCase()) {
			case "chrome":cap.setBrowserName("chrome");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			case "firefox":cap.setBrowserName("firefox");break;
			default:System.out.println("No Matching browser"); return;
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}
		
		
		
		
		if(p.getProperty("exec_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) {
				case "chrome": driver=new ChromeDriver(); break;
				case "edge":driver=new EdgeDriver();break;
				case "firefox":driver=new FirefoxDriver();break;
				default: System.out.println("Invalid browser...");return;
		
			}	
		
		}
		
	
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/index.php");
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		//Thread.sleep(3000);
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}

	public String captureScreen(String tname) throws IOException {
		// TODO Auto-generated method stub
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+".\\screenshots\\"+tname+"-"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}


}
