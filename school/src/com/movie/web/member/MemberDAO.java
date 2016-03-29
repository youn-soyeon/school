package com.movie.web.member;

import java.util.List;

/**
 * @file : MemberDAO.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 17.
 * @story
 */
public interface MemberDAO {
	public int insert(MemberBean memberBean);
	public MemberBean selectById(String id, String password);
	public MemberBean selectMember(String id);
	public int update(MemberBean memberBean);
	public int delete(String id);
	public boolean isMember(String id);
	public List<MemberBean> selectList();
}
