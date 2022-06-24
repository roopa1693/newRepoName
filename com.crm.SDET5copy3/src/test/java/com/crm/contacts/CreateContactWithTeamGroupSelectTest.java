package com.crm.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithTeamGroupSelectTest extends BaseClass{
	@Test
	public void createContactWithTeamGroupSelectTest() throws Throwable

	{
		
		//fetching data from excel..
		String orgName = eLib.getExcelCellValue("Details", 4, 2);
		String fName =eLib.getExcelCellValue("Details", 7, 2);
		String lName =eLib.getExcelCellValue("Details", 7, 3);
		String title =eLib.getExcelCellValue("Details", 7, 4);
		String email = eLib.getExcelCellValue("Details", 7, 5);
		String phoneNo = eLib.getExcelCellValue("Details",7,6);
		String pre=eLib.getExcelCellValue("DropDownOptions", 5, 0);
		String groupSelect=eLib.getExcelCellValue("DropDownOptions", 7, 3);
		
		//generate random number..
		int ranNum = jLib.generateRandomNumber();

		
		//click on contact..
		HomePage hPage=new HomePage(driver);
		hPage.getContactLink().click();
		
		
		//creating new contact code..
		CreateContactPage createContact=new CreateContactPage(driver);
		createContact.clickOnCreateNewContackLkImg();
		
		//filling required fields..
		CreateNewContactPage newContact=new CreateNewContactPage(driver);
		newContact.enterRequiredFields(driver, pre, fName, lName, orgName, title, phoneNo, email);
		
		
		newContact.selectGrDropDown(groupSelect);
		
		//save code..
		newContact.clickonSaveBtn();
		
		//verifying contact is created or not..
		ContactInfoPage infoContact=new ContactInfoPage(driver);
		String contact = infoContact.getHeaderTxt().getText();
		if(contact.contains(fName))
		{
			System.out.println("Contact Created Successfully");
		}
		else
		{
			System.out.println("Contact Not Created");
		}

	}

}
