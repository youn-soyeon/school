package com.movie.web.member;

/**
 * @file : MemberDAO.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */
public interface MemberDAO {
	public int insert(MemberBean member);
	public MemberBean selectById(String id, String password);
	public MemberBean selectMember(String id);
	public void update(MemberBean member);
	public void delete(String id, String password);
	public boolean isMember(String id);
}
