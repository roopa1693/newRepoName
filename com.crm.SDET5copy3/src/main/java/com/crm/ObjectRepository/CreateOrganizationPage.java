package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	//declaration
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrgLkImg;
	
	//initialization
	public CreateOrganizationPage(WebDriver  driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateOrgLkImg() {
		return createOrgLkImg;
	}
	
	public void clickOnCreateContactLkImg()
	{
		createOrgLkImg.click();
	}
	
}
