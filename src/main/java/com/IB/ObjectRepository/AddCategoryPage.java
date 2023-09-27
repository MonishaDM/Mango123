package com.IB.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	//declaration
	@FindBy(linkText = "Add Category")
	private WebElement addCategory;
	
	@FindBy(name="submit")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[.='Cancel']")
	private WebElement cancelbtn;
	
	public AddCategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addCategory(String categoryName) {
		addCategory.sendKeys(categoryName);
		savebtn.click();
	}
	public void validateCategory(WebDriver driver, String catName) {
		try {
			driver.findElement(By.xpath("//tr[*]/td[.='"+catName+"']"));
			System.out.println("Category is added");
		} catch (Exception e) {
			System.out.println("Category is not added");
		}
	}
	public void clickOnEditCategory(WebDriver driver, String catName) {
		driver.findElement(By.xpath("//td[.='"+catName+"']/ancestor::tr//i[@class='fa fa-edit']")).click();
	}

}
