package com.crm.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility{
	//declaration
	@FindBy(name="accountname") private WebElement orgNameTxtEdit;

	@FindBy (id="phone") private WebElement phoneNoTxtEdit;

	@FindBy (id="email1") private WebElement eMailTxtEdit;

	@FindBy(name="website") private WebElement webSiteTxtEdit;

	@FindBy(name="industry") private WebElement industryDropDown;

	@FindBy(name="accounttype") private WebElement accountTypeDropDown;

	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;

	@FindBy(xpath = "//input[@value='Cancel  ']") private WebElement cancelBtn;

	//initialization
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTxtEdit() {
		return orgNameTxtEdit;
	}

	public WebElement getPhoneNoTxtEdit() {
		return phoneNoTxtEdit;
	}

	public WebElement geteMailTxtEdit() {
		return eMailTxtEdit;
	}

	public WebElement getWebSiteTxtEdit() {
		return getWebSiteTxtEdit();
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAccountTypeDropDown() {
		return accountTypeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public void enterOrgInfo(String orgName)
	{
		orgNameTxtEdit.sendKeys(orgName);
	}

	public void enterOrgRequiredDetail(String orgName,String phoneNo,String email,String website)
	{
		orgNameTxtEdit.sendKeys(orgName);
		phoneNoTxtEdit.sendKeys(phoneNo);
		eMailTxtEdit.sendKeys(email);
		webSiteTxtEdit.sendKeys(website);

	}
	public void selectIndustryType(String iValue)
	{	
		selectDropDown(industryDropDown, iValue);
	}

	public void selectTypeDropDown(String tValue)
	{
		selectDropDown(accountTypeDropDown, tValue);
	}

	public void clickOnSaveBtn(WebDriver driver)
	{
		saveBtn.click();
	}

	public void clickOnCancelBtn(WebDriver driver)
	{
		cancelBtn.click();
	}


}
