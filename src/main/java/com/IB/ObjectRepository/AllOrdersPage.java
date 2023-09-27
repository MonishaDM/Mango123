package com.IB.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.IB.genericUtils.WebDriverUtility_Test;

public class AllOrdersPage {
public AllOrdersPage(){
		
	}

	public void clickOnDeleteOrder(WebDriver driver,String menuName, WebDriverUtility_Test wLib) {
		driver.findElement(By.xpath("//td[.='"+menuName+"']/ancestor::tr//i[@class='fa fa-trash-o']")).click();
		wLib.acceptAlertPopup(driver, menuName);
	}

	public void validateDeletedOrder(WebDriver driver, String menuName) {
	try {
		driver.findElement(By.xpath("//td[.='"+menuName+"']/ancestor::tr//i[@class='fa fa-trash-o']"));
		System.out.println("Order is not deleted");
	} catch (Exception e) {
		System.out.println("Order is deleted");
	}
	}

}
