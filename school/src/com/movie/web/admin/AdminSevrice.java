package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

/**
 * @file : AdminSevrice.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 23.
 * @story
 */
public interface AdminSevrice {
	public List<MemberBean> getMemberList();
	public int addScore(GradeMemberBean bean);
}
