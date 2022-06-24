package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
//declaration..	

@FindBy(xpath="//a[text()='Organizations']") private WebElement orgLink;

@FindBy(xpath="//a[text()='Contacts']") private WebElement contactLink;

@FindBy(xpath="//a[text()='Products']") private WebElement productLink;

@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']") private WebElement moreLink;

@FindBy(name = "Vendors") private WebElement vendorsLink;

@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement adminLink;

@FindBy(xpath = "//a[text()='Sign Out']") private WebElement signOutLink;

//initialization

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


//utilization

public WebElement getOrgLink() {
	return orgLink;
}

public WebElement getContactLink() {
	return contactLink;
}



public WebElement getVendorsLink() {
	return vendorsLink;
}


public WebElement getProductLink() {
	return productLink;
}

public WebElement getMoreLink() {
	return moreLink;
}

public WebElement getAdminLink() {
	return adminLink;
}

public WebElement getSignOutLink() {
	return signOutLink;
}


public void logout(WebDriver driver) 
{
	mouseOverAnElement(driver, adminLink);
	signOutLink.click();
}
}
