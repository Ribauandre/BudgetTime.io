package BudgetTimeLogic.model;

import java.sql.DriverManager;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.*;

public class LoginModel extends DB {
	Connection connection = null; 
	Statement statement = null; 
	ResultSet resultSet = null; 
	
	public void initializeConnection(){
try{
		String userName = "sql9158151"; 
	    String password = "JYuhD6cFFT"; 
	    String db_name = "sql9158151"; 
	    String url = "sql9.freemysqlhosting.net";
	    Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	    connection = (Connection) DriverManager.getConnection(url, userName, password); 
	    System.out.println("DB connection successful for database");
		
	} 

catch (Exception e){
	System.err.println("DB connection failed"); }
	
	}

	
	public boolean login(){
		{
			Scanner userInput = new Scanner (System.in);
			 String username = userInput.next(); 
			 String pwd = userInput.next(); 
			 
			 if (username.equals("srg5328") && pwd.equals("Hello")){return true;}  
			 	
			 if(username.equals("arb5438") && pwd.equals("power")){return true;}
			 
			 else {return false; }


		}
	

	 }
}

