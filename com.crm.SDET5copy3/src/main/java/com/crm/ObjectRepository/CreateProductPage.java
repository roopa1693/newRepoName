package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	@FindBy(xpath = "//img[@title='Create Product...']") private WebElement createProductLkImg;
	
	public CreateProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getCreateProductLkImg() {
		return createProductLkImg;
	}
	
	
}
