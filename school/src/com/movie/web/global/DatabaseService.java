package com.movie.web.global;

import java.sql.Connection;

/**
 * @file : DatabaseService.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 22.
 * @story
 */
public interface DatabaseService {
	public Connection getConnection();
}
