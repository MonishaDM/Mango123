package com.IB.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	//declaration
	@FindBy(xpath="//span[.='Dashboard']")
	private WebElement dashboardbtn;
	
	@FindBy(xpath="//span[.='Users']")
	private WebElement userbtn;
	
	@FindBy(xpath="//span[.='Restaurant']")
	private WebElement restaurantbtn;
	
	@FindBy(xpath="//a[.='All Restaurant']")
	private WebElement allRestaurantbtn;
	
	@FindBy(xpath="//a[.='Add Category']")
	private WebElement addCategorybtn;
	
	@FindBy(xpath="//a[.='Add Restaurant']")
	private WebElement addRestaurantbtn;
	
	@FindBy(xpath="//span[text()='Menu']")
	private WebElement Menubtn;
	
	@FindBy(xpath="//a[text()='All Menues']")
	private WebElement allMenubtn;
	
	@FindBy(xpath="//a[.='Add Menu']")
	private WebElement addMenubtn;
	
	public WebElement getAllMenubtn() {
		return allMenubtn;
	}

	@FindBy(xpath="//span[.='Orders']")
	private WebElement ordersbtn;
	
	@FindBy (xpath = "//img[@class='profile-pic']")
	private WebElement ProfilePicIcon;
	
	@FindBy (xpath = "//a[contains(text(),'Logout')]")
	private WebElement LogoutButton;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getDashboardCount(WebDriver driver, String categoryName) {
		dashboardbtn.click();
		String count = driver.findElement(By.xpath("//p[.='"+categoryName+"']/../h2")).getText();
		int value = Integer.parseInt(count);
		System.out.println(value);
		return value;
	}
	
	public void clickAllMenu() {
		Menubtn.click();
		allMenubtn.click();
	}
	
	public void clickAddMenu() {
		Menubtn.click();
		addMenubtn.click();
	}
	
	public void clickonOrders() {
		ordersbtn.click();
	}
	
	public void logoutAsAdmin() {
		ProfilePicIcon.click();
		LogoutButton.click();
	}
	
	public void clickAddCategory() {
		restaurantbtn.click();
		addCategorybtn.click();
	}
	
	public void clickAddRestaurant() {
		restaurantbtn.click();
		addRestaurantbtn.click();
	}
	
}
