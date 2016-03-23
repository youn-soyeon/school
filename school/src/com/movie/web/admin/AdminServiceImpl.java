package com.movie.web.admin;

import java.util.List;

import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

/**
 * @file : AdminServiceImple.java
 * @author sssoyeon92@naver.com
 * @date 2016. 3. 23.
 * @story
 */
public class AdminServiceImpl implements AdminSevrice {

	AdminDAO dao = new AdminDAOImpl();
	
	@Override
	public List<MemberBean> getMemberList() {
		// 전체 회원 정보 보기
		return dao.selectAllMember();
	}

	@Override
	public int addScore(GradeMemberBean bean) {
		// 학생 성적 추가하기
		return 0;
	}

}
