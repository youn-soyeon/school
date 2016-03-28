package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

import sun.security.jca.GetInstance;

/**
 * @file : AdminServiceImple.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 23.
 * @story
 */
public class AdminServiceImpl implements AdminService {

	private static AdminService instance = new AdminServiceImpl();
	AdminDAO dao = new AdminDAOImpl();
	
	public static AdminService GetInstance(){
		return instance;
	}
	
	@Override
	public List<MemberBean> getMemberList() {
		// 전체 회원 정보 보기
		return dao.selectAllMember();
	}
	
	@Override
	public List<GradeMemberBean> getGradeMemberList() {
		// 학생 전체 점수 조회
		return dao.selectAllMemberGrade();
	}

	@Override
	public int addScore(GradeBean bean) {
		// 학생 성적 추가하기
		return dao.insertScore(bean);
	}

	@Override
	public List<GradeBean> getGradeListById(String id) {
		// id로 특정 학생의 점수 조회하기
		return dao.selectGradeById(id);
	}

	@Override
	public AdminBean getAdmin(AdminBean temp) {
		// 아이디 비밀번호로 관리자 정보 가져오기
		return dao.selectAdmin(temp);
	}


}
