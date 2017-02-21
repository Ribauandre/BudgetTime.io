package BudgetTimeLogic.model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class RegisterModel extends DB {
	
	AccountModel newCustomer = new AccountModel();
	Person newPerson = new Person(); 
	Connection connection = null; 
	Statement statement = null; 
	ResultSet resultSet = null; 
	
	
	public void addNewUserToDB(String fname, String lastname, String username, String password ){
		newPerson.setFirstName(fname);
		newPerson.setLastName(lastname);
		newCustomer.setUsername(username); 
		newCustomer.setPassword(password);
	
	}
	
	
	

	
	
}