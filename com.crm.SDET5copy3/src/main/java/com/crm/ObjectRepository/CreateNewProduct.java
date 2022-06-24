package com.crm.ObjectRepository;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class CreateNewProduct extends WebDriverUtility {

	@FindBy(name="productname") private WebElement productNameTxtEdit;
	
	@FindBy(xpath="//img[@title='Select']") private WebElement selectVendorLkImg;
	
	@FindBy(id="search_txt") private WebElement searchTxtEdit;
	
	@FindBy(name="search") private WebElement searchBtn;
	
	@FindBy(xpath = "//a[.='chan']") private WebElement vendorNameSelect;

	
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getProductNameTxtEdit() {
		return productNameTxtEdit;
	}
	public WebElement getSelectVendorLkImg() {
		return selectVendorLkImg;
	}
	public WebElement getSearchTxtEdit() {
		return searchTxtEdit;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getVendorNameSelect() {
		return vendorNameSelect;
	}

	public void switchTowindow(WebDriver driver,String partialTitle)
	{
		switchToWindowUsingForEach(driver, partialTitle);
	}
	/*
	//searching through vendor name.. window pop up handling
	driver.findElement(By.id("search_txt")).sendKeys("chan");
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[.='chan']")).click();

	//switch back to parent window..(for each loop)..
	wLib.switchToWindowUsingForEach(driver, "Administrator");
	
	//type casting to scroll..
	wLib.scrollBarAction(driver);

	File f=new File("./src/test/resources/img.jpg");
	String aPath = f.getAbsolutePath();
	driver.findElement(By.xpath("//input[@type='file']")).sendKeys(aPath);*/

}
