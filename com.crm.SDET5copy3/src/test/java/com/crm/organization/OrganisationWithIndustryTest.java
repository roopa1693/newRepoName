package com.crm.organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.CreateNewOrgPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.comcast.genericUtilities.BaseClass;
@Listeners(com.crm.comcast.genericUtilities.ListenerImpClass.class)
public class OrganisationWithIndustryTest extends BaseClass 
{
	//@Test(groups = "regressionTest")
	@Test(retryAnalyzer = com.crm.comcast.genericUtilities.RetryImpClass.class)
	public void organizationWithIndustry() throws Throwable 
	{
		
		//generate random numbers..
		int ranNum=jLib.generateRandomNumber(); 

		//fetching data from excel..
		String orgName = eLib.getExcelCellValue("Details", 4, 2);
		String website =eLib.getExcelCellValue("Details", 4, 4);
		String phoneno =eLib.getExcelCellValue("Details", 4, 6);
		String email =eLib.getExcelCellValue("Details", 4, 7);
		String industrySelect=eLib.getExcelCellValue("DropDownOptions", 25, 0);
		String typeSelect=eLib.getExcelCellValue("DropDownOptions", 23, 1);


		
		//Create New Organization Code..
		HomePage hPage=new HomePage(driver);
		hPage.getOrgLink().click();
		
		CreateOrganizationPage  createOrg=new CreateOrganizationPage(driver);
		createOrg.clickOnCreateContactLkImg();

		//Entering the field values code..
		CreateNewOrgPage newOrg=new CreateNewOrgPage(driver);
		newOrg.enterOrgRequiredDetail(orgName+ranNum, phoneno, email, website);

		//Choosing industry..&..type..
		newOrg.selectIndustryType(industrySelect);
		newOrg.selectTypeDropDown(typeSelect);
		
		//Scroll to description..
		wLib.scrollBarAction(driver);
		wLib.scrollBarAction(driver);
		wLib.scrollBarAction(driver);
		
		Thread.sleep(2000);

		//Write Description..
	//	driver.findElement(By.name("description")).sendKeys("description written..");
		Thread.sleep(2000);

		//Save..
		newOrg.clickOnSaveBtn(driver);
		
		//Verify Organization created or not..
		ContactInfoPage infoContact=new ContactInfoPage(driver);
		String OrgaName = infoContact.getHeaderTxt().getText();
		Assert.assertTrue(OrgaName.contains(orgName));
		
			System.out.println("Organization Created With Industry");
		

	}
}





























