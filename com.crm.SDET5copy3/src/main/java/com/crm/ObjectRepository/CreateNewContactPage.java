package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebDriverUtility;
import com.github.dockerjava.api.model.Driver;

public class CreateNewContactPage extends WebDriverUtility
{
	
	//declaration..
	@FindBy (name="salutationtype") private WebElement preSelect;
	
	@FindBy(name="firstname") private WebElement fNameTxtEdit;
	
	@FindBy(name="lastname") private WebElement lNameTxtEdit;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]") private WebElement orgSelectLkImg;
	
	@FindBy(id="search_txt") private WebElement searchTxtEdit;
	
	@FindBy(id="1") private WebElement selectOrgName;
	
	@FindBy(id="title") private WebElement titleTxtEdit;
	
	@FindBy(id="mobile") private WebElement phoneNoTxtEdit;
	
	@FindBy (id="email") private WebElement emailTxtEdit;
	
	@FindBy (xpath = "//input[@value='  Save  ']") private WebElement saveBtn;
	
	@FindBy(name ="leadsource") private WebElement selectLeadSource;
	
	@FindBy(xpath = "//input[@value='U']") private WebElement adminSelect;
	
	@FindBy(xpath = "//input[@value='T']")private WebElement groupSelect;

	//initialization..
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization..
	public WebElement getPreSelect() {
		return preSelect;
	}


	public WebElement getGroupSelect() {
		return groupSelect;
	}

	public WebElement getAdminSelect() {
		return adminSelect;
	}

	public WebElement getSelectLeadSource() {
		return selectLeadSource;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getfNameTxtEdit() {
		return fNameTxtEdit;
	}


	public WebElement getlNameTxtEdit() {
		return lNameTxtEdit;
	}


	public WebElement getOrgSelectLkImg() {
		return orgSelectLkImg;
	}
	
	
	public WebElement getSearchTxtEdit() {
		return searchTxtEdit;
	}

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}

	public WebElement getTitleTxtEdit() {
		return titleTxtEdit;
	}

	public WebElement getPhoneNoTxtEdit() {
		return phoneNoTxtEdit;
	}

	public WebElement getEmailTxtEdit() {
		return emailTxtEdit;
	}
	
	public void selectLeadDropDown(String leadSelectValue)
	{
		selectLeadSource.sendKeys(leadSelectValue);
	}
	
	public void selectGrDropDown(String groupSelectValue)
	{
		groupSelect.sendKeys(groupSelectValue);
	}
	
	public void  selectAdmin(String adselect)
	{
		adminSelect.sendKeys(adselect);
	}
	
	public void enterRequiredFields(WebDriver driver,String preSelectValue,String fName,String lName,String orgName,String title,String phoneNo,String email)
	{
		selectDropDown(preSelect, preSelectValue);
		fNameTxtEdit.sendKeys(fName);
		lNameTxtEdit.sendKeys(lName);
		orgSelectLkImg.click();
		switchToWindow(driver, "Acounts&action=Popup");
		selectOrgName.click();
		switchToWindowUsingForEach(driver, "Administrator - Contacts");
		titleTxtEdit.sendKeys(title);
		emailTxtEdit.sendKeys(email);
		phoneNoTxtEdit.sendKeys(phoneNo);
		
	}
	
	public void clickonSaveBtn()
	{
		saveBtn.click();
	}
	
	
}
