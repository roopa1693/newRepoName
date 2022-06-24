package com.crm.comcast.genericUtilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Roopa
 *
 */
public class BaseClass {

	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	/**
	 * connect to database..
	 */
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void dbConnect()
	{
		dLib.connectToDBConfigur();
	}
	
	/**
	 * 
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable
	//public void launchBrowser(String Browser) throws Throwable
	{
		//String Browser = System.getProperty("browser");
		//String url = System.getProperty("url");
		String Browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		
		//implicit wait..
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		
		//open the url..
		sdriver.get(url);
		
		//maximize the screen..
		driver.manage().window().maximize();
	}
	
	/**
	 * login to application..
	 * @throws Throwable   
	 */
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void loginToAppln() throws Throwable 
	{
		
		String userName=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		
		LoginPage lPage=new LoginPage(driver);
		lPage.loginToApplication(userName, password);
		
	}
	/**
	 * logout to application..
	 */
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void logOutFromApplication()
	{
		HomePage hPage=new HomePage(driver);
		hPage.logout(driver);
	}
	
	/**
	 * close the browser..
	 */
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void closeTheBrowser()
	{
		driver.quit();
	}
	
	/**
	 * close the DataBase..
	 */
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void closeDBConfig()
	{
		dLib.closeToDBConfigure();
	}
	
}
