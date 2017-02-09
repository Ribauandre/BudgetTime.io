package BudgetTimeLogic.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DB {
	
	public MysqlDataSource getDataSource(){
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("sql9158151");
		dataSource.setPassword("JYuhD6cFFT");
		dataSource.setServerName("sql9.freemysqlhosting.net");
		dataSource.setDatabaseName("sql9158151");
		dataSource.setPortNumber(3306);
		return dataSource;
		
		
	}

}
