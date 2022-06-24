package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	//declaration..
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement vendorInfoHeaderTxt;
	
	//initialization..
	public VendorInfoPage(WebDriver driver) 
	{

	PageFactory.initElements(driver, this);
	}
	
	//utilization..
	public WebElement getVendorInfoHeaderTxt() {
		return vendorInfoHeaderTxt;
	}
	
	

}
