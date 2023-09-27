package com.IB.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	//declaration
		@FindBy(name="username")
		private WebElement UserNamebx;
		
		public WebElement getUserNamebx() {
			return UserNamebx;
		}

		public void setUserNamebx(WebElement userNamebx) {
			UserNamebx = userNamebx;
		}

		public WebElement getPasswordbx() {
			return Passwordbx;
		}

		public void setPasswordbx(WebElement passwordbx) {
			Passwordbx = passwordbx;
		}

		public WebElement getLoginBtn() {
			return LoginBtn;
		}

		public void setLoginBtn(WebElement loginBtn) {
			LoginBtn = loginBtn;
		}

		@FindBy(name="password")
		private WebElement Passwordbx;
		
		@FindBy(name="submit")
		private WebElement LoginBtn;
		
		//initialization
		public AdminLoginPage(WebDriver driver) {
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
