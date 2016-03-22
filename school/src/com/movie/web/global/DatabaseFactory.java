package com.movie.web.global;

/**
 * @file : DatabaseFactory.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 22.
 * @story
 */
public class DatabaseFactory {
	public static DatabaseService getDatabase(Vendor vendor, String id, String password) {
		String driver = null, url = null;
		switch (vendor) {
		case ORACLE: 
			driver = Constants.ORACLE_DRIVER;
			url = Constants.ORACLE_URL;
			break;
		case MYSQL: 
			driver = Constants.MYSQL_DRIVER;
			url = Constants.MYSQL_URL;
			break;
		case MSSQL: 
			driver = Constants.MSSQL_DRIVER;
			url = Constants.MSSQL_URL;
			break;
		default: break;
		}
		return new DatabaseServiceImpl(driver, url, id, password);
	}
}
