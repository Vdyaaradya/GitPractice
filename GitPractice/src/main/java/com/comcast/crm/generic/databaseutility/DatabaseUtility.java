package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
public void getDBConnection(String url,String username,String password) throws Throwable
	{
		try {
	     
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
	    Connection conn=DriverManager.getConnection(url,username,password); // hardcode the url bcz , we can connect to only one database in project
	   }catch (Exception e) {
		// TODO: handle exception
	  }
   }
public void closeDBConnection() throws Throwable
	{
		conn.close();
	}
public ResultSet executeSelectQuery(String query) throws Throwable
 {
	ResultSet result=null;
	try {
		 Statement stat=conn.createStatement();
		 result = stat.executeQuery(query);
	}catch (Exception e) {
		// TODO: handle exception
	}
   return result;
}
	public int nonSelectQuery(String query) throws Throwable
	{
	 int result=0;
	 try {
		 Statement stat	=conn.createStatement();
		 result=stat.executeUpdate(query);
		   
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return result;

	}
}	
	

