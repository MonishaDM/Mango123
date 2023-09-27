package com.IB.genericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;import com.google.common.io.Files;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility_Test {
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the browser
	 * @param driver
	 */
	public void minimizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	/**
	 * This method will wait until the elements in webpage gets loaded
	 * @param driver
	 * @param duration
	 */
	public void implicitWait(WebDriver driver,int duration)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	/**
	 * This method will wait until the elements in web_page gets loaded
	 * @param driver
	 * @param duration
	 * @param url
	 */
	public void explicitwait(WebDriver driver,int duration,String url)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * This method will wait until the title of page gets loaded
	 * @param driver
	 * @param duration
	 * @param expectedTitle
	 */
	public void waitUntilTitleLoads(WebDriver driver,int duration,String expectedTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	/**
	 * This method will wait until the elements in the page gets clickable
	 * @param driver
	 * @param duration
	 * @param element
	 */
	public void waitUntilElementsToBeVisible(WebDriver driver,int duration,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to ignore NoSuchElementException and continue execution
	 * @param driver
	 * @param duration
	 */
	public void ignoreNoSuchElementException(WebDriver driver, int duration)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * This method will wait until the element will visible in the web_page
	 * @param element
	 * @throws Throwable
	 */
	public void customWait(WebElement element) throws Throwable {
		int count=0;
		while(count<20) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
	}
	/**
	 * This method is used to select the drop_down based on index
	 * @param element
	 * @param index
	 */
	public void selectByDropDown(WebElement element,int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select the drop_down based on value
	 * @param element
	 * @param value
	 */
	public void selectByDropDown(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select the drop_down based on Visible text
	 * @param text
	 * @param element
	 */
	public void selectByDropDown(String text,WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method is used for mouse actions on the element in web_page
	 * @param element
	 * @param driver
	 */
	public void mouseOverOnElement(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method is used to right click on the element in web_page
	 * @param element
	 * @param driver
	 */
	public void rigthClick(WebElement element, WebDriver driver) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This method is used to drag and drop the web_page element
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest);
	}
	/**
	 * This method is used to double click on the web_page elements
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	/**
	 * This method is used to click on enter button in the web_page
	 * @param driver
	 */
	public void clickOnEnterKey(WebDriver driver) {
		Actions a = new Actions(driver);   //Robot rob = new Robot(); rb.keyPress(KeyEvent.VK_ENTER);
		a.sendKeys(Keys.ENTER).perform();    
	}
	/**
	 * This method is used to release the enter button
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	}
	 * This method is used to switch one frame to another using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch one frame to another using id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver, String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method is used to switch one frame to another using web element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch to main frame using default content
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to accept the alert pop_up
	 * @param driver
	 * @param expectedText
	 */
	public void acceptAlertPopup(WebDriver driver, String expectedText) {
		Alert alt = driver.switchTo().alert();
	if(alt.getText().equalsIgnoreCase(expectedText)) {
		System.out.println("Alert msg is verified");
	}
	else {
		System.out.println("Alert msg in not verified");
	}
	alt.accept();
	}
	/**
	 * This method is used to dismiss the alert pop_up
	 * @param driver
	 * @param expectedText
	 */
	public void dismissAlertPopup(WebDriver driver, String expectedText) {
		Alert alt = driver.switchTo().alert();
		if(alt.getText().equalsIgnoreCase(expectedText)) {
			System.out.println("Alert msg ia verified");
		}
		else {
			System.out.println("Alert msg is not verified");
		}
		alt.dismiss();
	}
	/**
	 * This method is used to switch the window using getWindowHandles
	 * @param driver
	 */
	public void switchWindow(WebDriver driver) {
		Set<String> set = driver.getWindowHandles();
		for (String str : set) {
			driver.switchTo().window(str);
		}
	}
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param expectedTitle
	 */
	public void switchToBasedOnTitle(WebDriver driver, String expectedTitle) {
		Set<String> set = driver.getWindowHandles();
		for (String str : set) {
			driver.switchTo().window(str);
			String title = driver.getTitle();
			if(title.contains(expectedTitle)) {
				break;
			}
		}
	}
	/**
	 * This method is used to switch the window based on URL
	 * @param driver
	 * @param expectedUrl
	 */
	public void switchToBasedOnUrl(WebDriver driver, String expectedUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String url = driver.getCurrentUrl();
			if(url.contains(expectedUrl)) {
				break;
			}
		}
	}
	/**
	 * This method is used to take screenshot for failed test scripts 
	 * @param driver
	 * @param screenShotName
	 * @return
	 */
	public static String takesScreenShot(WebDriver driver, String screenShotName) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);		
		File dest = new File("./screenShots/"+screenShotName+".png");
		try {
			Files.copy(src, dest);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return screenShotName;
	}
	/**
	 * This method used to scrollTo particular element
	 * @param driver
	 * @param element
	 */
	public void scrollToParticularElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)","");
	}
	/**
	 * This method will scroll until specified element will found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("arguments[0].scrollIntoView()", element);
	}
	public void closeTheBrowser(WebDriver driver)
	{
		driver.close();
	}
}
