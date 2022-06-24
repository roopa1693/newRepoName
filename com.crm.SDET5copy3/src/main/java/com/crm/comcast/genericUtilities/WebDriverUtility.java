package com.crm.comcast.genericUtilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Roopa
 */
public class WebDriverUtility
{
	/**
	 * it will wait for 10 seconds till the page gets load..(synchronization for find elements)..
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * it will wait 10 seconds for java script element..
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * it will check for the element in the GUI for polling time 500ms..(Explicit wait)..
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * it will check for the element in the GUI for polling time 500ms..(Explicit wait)..
	 * check fot title is..
	 * @param driver
	 * @param element
	 */
	public void waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * here we can change the polling time from default 500ms to any polling time (fluentwait)..
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver,int pollingTime,WebElement element)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * here we are giving custom timeout..
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<10)
		{
			try
			{
				element.click();	
			}
			catch(Exception e)
			{
				Thread.sleep(1000);	
				count++;
			}
		}
	}
	/**
	 * used to switch from one window to another window using iterator..
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver,String partialWindow)
	{
		Set<String>  allwh=driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
		while(it.hasNext())
		{
			String wh=it.next();
			driver.switchTo().window(wh);
			String currentWindow=driver.getTitle();
			if(currentWindow.contains(partialWindow))
			{
				break;	
			}
		}
	}
	/**
	 * its used switch to window using for each loop..
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindowUsingForEach(WebDriver driver,String partialWindow)
	{
		Set<String> allwh = driver.getWindowHandles();
		for(String wh:allwh)
		{
			driver.switchTo().window(wh);
			String wTitle = driver.getTitle();
			if(wTitle.contains(partialWindow))
			{
				break;
			}
		}
	}
	/**
	 * switch from one frame to another frame by using index..
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);	
	}
	/**
	 * switch from one frame to another frame by using id_attribute..
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_attribute)
	{
		driver.switchTo().frame(id_attribute);	
	}
	/**
	 * switch from one frame to another frame by using absolute path..
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);	
	}
	/**
	 * its used to switch back to one chile frame to parent frame..
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();	
	}
	/**
	 * its used to switch to alert pop up and accept..
	 * @param driver
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();	
	}
	/**
	 * its used to switch to alert pop up and dismiss..
	 * @param driver
	 */
	public void switchToAlertPopupAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * it is used to switch to select drop down by using index
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * it is used to switch to select drop down by using value
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * it is used to switch to select drop down by using visible_text
	 * @param element
	 * @param index
	 */
	public void selectDropDownByVisibleText(WebElement element,String visible_text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visible_text);
	}
	/**
	 * it is used to mouse over an element..
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * it is used to right click on Element..
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * it is used to click on enter button using keyboard actions
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver)
	{
		Actions a= new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * it is used to take screen shot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable 
	 */
	public static void takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+screenShotName+".png");
		Files.copy(src,dest);
	}
	/**
	 * it is used to perform scroll bar action
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;	
		j.executeScript("window.scrollBy(0,500)");
	}

}
