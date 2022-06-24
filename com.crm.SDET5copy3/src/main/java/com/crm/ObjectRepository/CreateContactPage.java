package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	//declaration
	@FindBy(xpath = "//img[@title='Create Contact...']") private WebElement createNewContactLkImg;
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	//utilization
	public WebElement getCreateNewContactLkImg() {
		return createNewContactLkImg;
	}
	
	public void clickOnCreateNewContackLkImg()
	{
		createNewContactLkImg.click();
	}
	
	
}
