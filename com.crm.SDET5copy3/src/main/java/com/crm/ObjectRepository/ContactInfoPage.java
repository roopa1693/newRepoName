package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	//declaration..
	@FindBy(className = "dvHeaderText") private WebElement headerTxt;
	
	//initialization..
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization..
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	
	
}
