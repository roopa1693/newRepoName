package com.crm.organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.comcast.genericUtilities.ExcelUtility;
import com.crm.comcast.genericUtilities.FileUtility;
import com.crm.comcast.genericUtilities.JavaUtility;
import com.crm.comcast.genericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.comcast.genericUtilities.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	//@Test(groups = "smokeTest")
	@Test(retryAnalyzer = com.crm.comcast.genericUtilities.RetryImpClass.class)
	public void createOrgTest() throws Throwable
	 {
		
		//generate random numbers..
		int ranNum=jLib.generateRandomNumber(); 

		//fetching data from excel..
		
		String orgName = eLib.getExcelCellValue("Details", 4, 2);
		String website =eLib.getExcelCellValue("Details", 4, 4);
		String email =eLib.getExcelCellValue("Details", 4, 7);
		String phoneNo =eLib.getExcelCellValue("Details", 7, 6);

		//clicking on organization and creating organization..
		HomePage hPage=new HomePage(driver);
		hPage.getOrgLink().click();
		
		CreateOrganizationPage cOrgPage=new CreateOrganizationPage(driver);
		cOrgPage.clickOnCreateContactLkImg();
		
		//entering fields..
		CreateNewOrgPage cNewOrgPage=new CreateNewOrgPage(driver);
		cNewOrgPage.enterOrgRequiredDetail(orgName+ranNum, phoneNo, email, website);
		

		//save code..
		cNewOrgPage.clickOnSaveBtn(driver);
		//Assert.fail();
		//verifying organization created or not..
		OrganizationInfoPage oInfoPage=new OrganizationInfoPage(driver);
		String orgaName=oInfoPage.getOrgaNameTxt().getText();
		Assert.assertTrue(orgaName.contains(orgName));
		
			System.out.println("Organization Created");
		
	}


}







































