package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	//@FindBys({@FindBy(xpath="//input[@type='text']"),@FindBy(name="user_name")})
	
	@FindAll({@FindBy(xpath="//input[@type='text']"),@FindBy(name="user_name")})
	private WebElement userNameTxtEdit;

	//@FindBy(name="user_password")
	@FindAll({@FindBy(xpath="//input[@type='password']"),@FindBy(name="user_password")})
	private WebElement passwordTxtEdit;

	@FindBy(id="submitButton")
	@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
	private WebElement submitBtn;

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTxtEdit() {
		return userNameTxtEdit;
	}

	public WebElement getPasswordTxtEdit() {
		return passwordTxtEdit;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void loginToApplication(String userName,String password)
	{
		userNameTxtEdit.sendKeys(userName);
		passwordTxtEdit.sendKeys(password);
		submitBtn.click();
	}

}
