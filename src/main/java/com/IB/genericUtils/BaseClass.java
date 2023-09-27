package com.IB.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.IB.ObjectRepository.AdminLoginPage;
import com.IB.ObjectRepository.DashboardPage;

public class BaseClass {
	
	public DatabaseUtility_Test dLib = new DatabaseUtility_Test();
	public ExeclUtility_Test eLib = new ExeclUtility_Test();
	public FileUtility_Test fLib = new FileUtility_Test();
	public JavaUtility_Test jLib = new JavaUtility_Test();
	public WebDriverUtility_Test wLib = new WebDriverUtility_Test();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("--connect to DB--");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver =  new ChromeDriver();
			System.out.println("launch the chrome browser");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			System.out.println("launch the edge browser");
		}
		else
		{
			System.out.println("Invalid browser");
		}
		sdriver = driver;
		wLib.maximizeTheBrowser(driver);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	{
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.loginpage(USERNAME, PASSWORD);
		System.out.println("--Login to the application--");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		DashboardPage db = new DashboardPage(driver);
		db.logoutAsAdmin();
		System.out.println("--Logout from the application--");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		System.out.println("-- Close the Browser --");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws Throwable
	{
		dLib.closeDB();
		System.out.println("--Disconnect the database--");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
