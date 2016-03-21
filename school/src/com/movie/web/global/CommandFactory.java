package com.movie.web.global;

/**
 * @file : CommandFactory.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 21.
 * @story
 */
public class CommandFactory {
	public Command getCommand(String directory, String action){
		Command command = new Command(directory, action);
		return command;
	}
}
