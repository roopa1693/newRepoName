package com.crm.contactOrg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateNewContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.comcast.genericUtilities.BaseClass;
@Listeners(com.crm.comcast.genericUtilities.ListenerImpClass.class)
public class ContactWithOrgTest extends BaseClass{
	//@Test(groups = "regressionTest")
	@Test(retryAnalyzer = com.crm.comcast.genericUtilities.RetryImpClass.class)
	public void contactWithOrgTest1() throws Throwable {
		
		//generate random numbers..
		int ranNum=jLib.generateRandomNumber(); 

		//fetching data from excel..
		String orgName = eLib.getExcelCellValue("Details", 7, 1);
		String fName =eLib.getExcelCellValue("Details", 7, 2);
		String lName =eLib.getExcelCellValue("Details", 7, 3);
		String title =eLib.getExcelCellValue("Details", 7, 4);
		String email = eLib.getExcelCellValue("Details", 7, 5);
		String phoneNo = eLib.getExcelCellValue("Details",7,6);
		String pre=eLib.getExcelCellValue("DropDownOptions", 5, 0);

	

		//clicking on contact..
		HomePage hPage=new HomePage(driver);
		hPage.getContactLink().click();

		//create new contact code..
		CreateContactPage contactPage=new CreateContactPage(driver);
		contactPage.clickOnCreateNewContackLkImg();

		//entering required fields..
		CreateNewContactPage newContact=new CreateNewContactPage(driver);
		newContact.enterRequiredFields(driver,pre, fName, lName, orgName, title, phoneNo, email);


		//save code..
		newContact.clickonSaveBtn();
		//driver.findElement(By.xpath("//input[@value='  Save  ']")).click();

		//verifying contact is created or not..
		ContactInfoPage contactInfo=new ContactInfoPage(driver);
		String contact = contactInfo.getHeaderTxt().getText();
		Assert.assertTrue(contact.contains(fName));
		System.out.println("Contact Created Successfully");
	
//		System.out.println("failed");
//		if(contact.contains(fName))
//		{
//			System.out.println("Contact Created Successfully");
//		}
//		else
//		{
//			System.out.println("Contact Not Created");
//		}

	}

}
