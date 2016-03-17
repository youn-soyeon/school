package com.movie.web.member;

/**
 * @file : MemberDAO.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */
public interface MemberDAO {
	public void insert(MemberBean member);
	public void selectById(String id, String password);
	public MemberBean selectMember(String id);
	public void update(MemberBean member);
	public void delete(String id, String password);
}
