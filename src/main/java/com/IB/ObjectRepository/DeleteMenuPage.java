package com.IB.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteMenuPage {
	
public DeleteMenuPage(){
		
	}

	public void clickOnDeleteMenu(WebDriver driver,String restName) {
		driver.findElement(By.xpath("//td[.='"+restName+"']/ancestor::tr//i[@class='fa fa-trash-o']")).click();
	}

	public void validateDeletedMenu(WebDriver driver, String restName) {
		String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		if (actual.equalsIgnoreCase(restName)) {
			System.out.println("Menu is not deleted");
		}
		else {
			System.out.println("Menu is deleted");
		}
	}

}
