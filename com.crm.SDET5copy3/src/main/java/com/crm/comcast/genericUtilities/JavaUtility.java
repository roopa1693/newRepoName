package com.crm.comcast.genericUtilities;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Roopa
 *
 */
public class JavaUtility {
	/**
	 * 
	 * used to generate Random Numbers
	 * @return
	 */
	public int generateRandomNumber() 
	{
		Random random=new Random();
		int ranNum = random.nextInt(1000);
		return ranNum;
		
	}
	/**
	 * 
	 * its used to get System Date and Time In IST Format
	 * @return
	 */
	public String getSysDateAndTimeInISTFormat()
	{
		Date date=new Date();
		return date.toString();
		
	}
	/**
	 * 
	 * used to generate Standard Format Date And Time
	 * @return
	 */
	public String standardDateAndTimeFormat()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		String dd = dateAndTime.split(" ")[2];
		int mm = date.getMonth()+1;
		String finalFormat = yyyy+" "+mm+" "+dd;
		return finalFormat;
		
	}
	
}
