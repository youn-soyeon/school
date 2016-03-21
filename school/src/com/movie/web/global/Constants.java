package com.movie.web.global;

/**
 * @file : Constants.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */

public class Constants {
	// static은 모든 패키지들이 공유해야할 때 사용한다
	// oracle database
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ORACLE_ID = "hanbit";
	public static final String ORACLE_PASSWORD = "oracle";
	
	// mySql database
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://hostname:port/dbname";
	public static final String MYSQL_ID = "system";
	public static final String MYSQL_PASSWORD = "mysql";
	
	//msSql database
	public static final String MSSQL_DRIVER = "";
	public static final String MSSQL_URL = "";
	public static final String MSSQL_ID = "";
	public static final String MSSQL_PASSWORD = "mssql";
	
	// URI
	public static final String VIEWS = "/WEB-INF/views/";
}