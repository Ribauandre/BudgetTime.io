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
	
	/* the Azure db stuff
	 jdbc:sqlserver://budgettimeio.database.windows.net:1433;
	 database=budgettimeio;
	 user=srg5328@budgettimeio;
	 password={your_password_here};
	 encrypt=true;
	 trustServerCertificate=false;
	 hostNameInCertificate=*.database.windows.net;
	 loginTimeout=30;
	 
	 */

}


