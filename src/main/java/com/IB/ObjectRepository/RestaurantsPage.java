package com.IB.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.IB.genericUtils.WebDriverUtility_Test;

public class RestaurantsPage extends WebDriverUtility_Test {
	
	public RestaurantsPage() {
	}

	public void validateUpdatedMenu(WebDriver driver, String restName, String menuName) {
		WebElement target = driver.findElement(By.linkText(restName));
		scrollToParticularElement(driver, target);
		driver.findElement(By.xpath("//a[.='"+restName+"']/ancestor::div[contains(@class,'text-xs-center text-sm-left')]/following-sibling::div[1]//a[.='View Menu']")).click();
		try {
			driver.findElement(By.linkText(menuName));
			System.out.println("Updated menu is visible in restaurant");
		} catch (Exception e) {
			System.out.println("Updated menu is not visible in restaurant");
		}
	}

}
