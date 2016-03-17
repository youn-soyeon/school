package com.movie.web.global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @file : OracleTest.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */
public class OracleTest {
	public static void main(String[] args) {
		Connection conn = null; // null 주는 이유 : 지역변수 초기화
		Statement stmt = null;
		ResultSet rs = null; // Deep Copy 방식 사용할 것임 (ResultSet은 인터페이스이므로)

		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Test");
			String sample = "";
			while (rs.next()) {
				sample = rs.getString("sample");
			}
			System.out.println("샘플 : " + sample);
		} catch (Exception e) {
			// 줄줄이 catch 사용하는 것 비추
			System.out.println("오라클 에러 발생");
			e.printStackTrace();
		}
	}
}
