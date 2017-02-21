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
	

	
	public static boolean validate(String username, String pwd) 
	{
		boolean status=false;
		String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9158151";
        String usname = "sql9160018";
        String password = "TqN3ywM94V";
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from users where UserName=? and Password=?");  
			ps.setString(1,username);  
			ps.setString(2,pwd);  
		  
			ResultSet rs=(ResultSet) ps.executeQuery();  
			status=rs.next();         
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
			return status;  
	}
	

	 }

