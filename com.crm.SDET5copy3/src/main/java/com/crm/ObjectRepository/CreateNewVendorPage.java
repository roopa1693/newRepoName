package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
//declaration..
	@FindBy (name = "vendorname") private WebElement vendorNameTxtEdit;
	
	
	//initialization..
	public CreateNewVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization..
	public WebElement getVendorNameTxtEdit() {
		return vendorNameTxtEdit;
	}
	
	public void createVendorFun(String vendorNameValue)
	{
		vendorNameTxtEdit.sendKeys(vendorNameValue);
	}
	
}
