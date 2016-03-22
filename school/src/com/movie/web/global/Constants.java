package com.movie.web.global;

/**
 * @file : Constants.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */

public class Constants {
	// static은 모든 패키지들이 공유해야할 때 사용한다
	public static final String ID = "hanbit";
	public static final String PASSWORD = "oracle";
	
	// oracle database
	public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// mySql database
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://hostname:port/dbname";
	
	//msSql database
	public static final String MSSQL_DRIVER = "";
	public static final String MSSQL_URL = "";
	
	// URI
	public static final String VIEWS = "/WEB-INF/views/";
}