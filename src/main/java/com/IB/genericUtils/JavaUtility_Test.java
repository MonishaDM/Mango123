package com.IB.genericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility_Test {
	/**
	 * This method is used to get Random number
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(100);
		return ranNum;	
	}
	/**
	 * This method will fetch system date in ISI format
	 * @return
	 */
	public String getSystemdate()
	{
		Date date = new Date();
		return date.toString();
	}
	/**
	 * This method will fetch the system date in required format
	 * @return
	 */
	public String getSystemdateInFormat()
	{
		Date dateTime = new Date();
		String[] d = dateTime.toString().split(" ");
		
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		
		String finalformat = day+" "+month+" "+date+" "+year;
		return finalformat;
	}

}
