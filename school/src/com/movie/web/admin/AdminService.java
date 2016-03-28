package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

/**
 * @file : AdminSevrice.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 23.
 * @story
 */
public interface AdminService {
	public List<MemberBean> getMemberList();
	public List<GradeMemberBean> getGradeMemberList();
	public int addScore(GradeBean bean);
	public List<GradeBean> getGradeListById(String id);
	public AdminBean getAdmin(String id, String password);
}
