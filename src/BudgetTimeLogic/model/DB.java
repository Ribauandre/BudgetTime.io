package BudgetTimeLogic.model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DB {
	
	public static MysqlDataSource getDataSource(){
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("sql9160018");
		dataSource.setPassword("TqN3ywM94V");
		dataSource.setServerName("sql9.freemysqlhosting.net");
		dataSource.setDatabaseName("sql9160018");
		dataSource.setPortNumber(3306);
		return dataSource;
		
		
	}
	
	

}


