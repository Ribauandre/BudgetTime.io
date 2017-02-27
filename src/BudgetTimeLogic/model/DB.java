package BudgetTimeLogic.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DB {
	
	public static MysqlDataSource getDataSource(){
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("sql9161197");
		dataSource.setPassword("gIhNBWcKYa");
		dataSource.setServerName("sql9.freemysqlhosting.net");
		dataSource.setDatabaseName("sql9161197");
		dataSource.setPortNumber(3306);
		return dataSource;
		
		
	}
	
	

}


