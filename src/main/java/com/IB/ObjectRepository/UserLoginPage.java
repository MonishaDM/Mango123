package com.IB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	//declaration
	@FindBy(name="username")
	private WebElement UserNamebx;
	
	@FindBy(name="password")
	private WebElement Passwordbx;
	
	@FindBy(id="submit")
	private WebElement LoginBtn;
	
	//initialization
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void loginpage(String UN, String PW)
	{
		UserNamebx.sendKeys(UN);
		Passwordbx.sendKeys(PW);
		LoginBtn.click();
	}

}
