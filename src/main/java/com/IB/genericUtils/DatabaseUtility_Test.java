package com.IB.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility_Test {
	Connection con = null;
	/**
	 * This method is used to connect database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	/**
	 * This method is used to execute query and get the data
	 * @param query
	 * @param columnNo
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnNo, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			String data = result.getString(columnNo);
			if(data.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("--data is verified");
			return expData;
		}
		else {
			System.out.println("--Data is not present");
			return "";
		}
	}
	/**
	 * This method is used to close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}

}









