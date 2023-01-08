package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//super class

public class BaseClass 
{
	public WebDriver driver;
	
	public void initializeBrowser() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\AUTOMATION Testing notes\\30July_Maven\\Browsers\\chromedriver.exe");                    //diffClassName.methodName();	
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityClass.readPFData("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	

}
