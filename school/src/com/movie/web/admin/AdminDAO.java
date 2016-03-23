package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public interface AdminDAO {
	public List<MemberBean> selectAllMember();
	public List<GradeMemberBean> selectAllMemberGrade();
	public int insertScore(GradeBean grade);
	public List<GradeBean> selectGradeById(String id);
}
