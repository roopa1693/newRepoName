package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
//declaration
	@FindBy(xpath  = "//span[@class='dvHeaderText']") private WebElement orgaNameTxt;
	
	
	//initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgaNameTxt() {
		return orgaNameTxt;
	}
	
}
