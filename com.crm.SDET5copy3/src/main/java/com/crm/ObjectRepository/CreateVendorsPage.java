package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorsPage 
{
//declaration
	
	@FindBy (xpath = "//img[@title='Create Vendor...']") private WebElement vendorLkImg;
	
	// initialization..
	
	public CreateVendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization..
	public WebElement getVendorLkImg() {
		return vendorLkImg;
	}
	
	
	
}
