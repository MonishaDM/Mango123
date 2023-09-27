package com.IB.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IB.genericUtils.JavaUtility_Test;
import com.IB.genericUtils.WebDriverUtility_Test;

public class AddRestaurantPage {
	//declaration	
	@FindBy (name  ="res_name")
	private WebElement RestaurantNameTextField;
	
	@FindBy (name  ="email")
	private WebElement BusinessEmailTextField;
	
	@FindBy (name  ="phone")
	private WebElement PhoneTextField;
	
	@FindBy (name  ="url")
	private WebElement WebsiteUrlTextField;
	
	@FindBy (name  ="o_hr")
	private WebElement OpenHoursDropDown;
	
	@FindBy (name  ="c_hr")
	private WebElement CloseHoursDropDown;
	
	@FindBy (name  ="o_days")
	private WebElement OpenDaysDropDown;
	
	@FindBy (name  ="file")
	private WebElement ChooseFileButton;
	
	@FindBy (name  ="c_name")
	private WebElement SelectCategoryDropDown;
	
	@FindBy (name  ="address")
	private WebElement RestaurantAddress;
	
	@FindBy (name  ="submit")
	private WebElement SaveButton;
	
	@FindBy (linkText = "Cancel")
	private WebElement CancelButton;
	
	public AddRestaurantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public String addRestaurant(HashMap<String, String> map, WebDriver driver,WebDriverUtility_Test wLib, JavaUtility_Test jLib,String opHrs, String clHrs, String opDs, String catName) {
		String nameRandom = null;
		for (Entry<String, String> s : map.entrySet()) {
			if (s.getKey().contains("res_name")) {
				nameRandom=s.getValue()+jLib.getRandomNumber();
				driver.findElement(By.name(s.getKey())).sendKeys(nameRandom);
			} else {
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			}
		}
		wLib.selectByDropDown(OpenHoursDropDown, opHrs);
		wLib.selectByDropDown(CloseHoursDropDown, clHrs);
		wLib.selectByDropDown(OpenDaysDropDown, opDs);
		wLib.selectByDropDown(catName, SelectCategoryDropDown);
		SaveButton.click();
		return nameRandom;
	}
	
}
