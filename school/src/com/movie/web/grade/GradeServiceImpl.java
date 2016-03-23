package com.movie.web.grade;

import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements GradeService{
	// 멤버 필드(속성 집합)
	private static GradeService instance = new GradeServiceImpl();
	ArrayList<GradeBean> gradeList;
	GradeDAO dao = GradeDAOImpl.getInstance();
	
	public static GradeService getInstance() {
		return instance;
	}

	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 초기화
	}
	
	// 멤버 메소드 area(메소드 집)
	@Override
	public String input(GradeMemberBean bean) {
		// C 성적표 등록
		return dao.insert(bean);
	}

	@Override
	public List<GradeMemberBean> getList() {
		// R 성적표 리스트 출력
		return dao.selectAll();
	}

	@Override
	public GradeMemberBean getGradeByScoreSeq(int scoreSeq) {
		// R 성적표 조회(학번)
		return dao.selectGradeByScoreSeq(scoreSeq);
	}

	@Override
	public List<GradeMemberBean> getGradesByName(String name) {
		// R 성적표 조회(이름, 동명이인 가능성)
		return dao.selectGradesByName(name);
	}
	
	@Override
	public GradeMemberBean getGradeById(String id) {
		// R 성적표 조회(id)
		GradeMemberBean gradeMember = dao.selectGradeById(id);
		return gradeMember;
	}
	
	@Override
	public int getCount() {
		// R 카운트 조회(개수)
		return dao.count();		
	}
	
	@Override
	public void getCountByName() {
		// R 이름조회시 카운트 조회

	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정
		
		String temp = "수정 실패";
//		if(gradeList.contains(getGradeByScoreSeq(grade.getScoreSeq()))){
//			GradeBean searchedGrade = getGradeByScoreSeq(grade.getScoreSeq());
//			searchedGrade.setJava(grade.getJava());
//			searchedGrade.setSql(grade.getSql());
//			searchedGrade.setJsp(grade.getJsp());
//			searchedGrade.setSpring(grade.getSpring());
//			
//			
//			temp = "수정 성공";
//		}
		/*
		this.delete(grade.getScoreSeq());
		this.input(grade);
		*/
		
		return temp;
	}

	@Override
	public String delete(int scoreSeq) {
		// D 성적표 삭제
		return (gradeList.remove(this.getGradeByScoreSeq(scoreSeq))) ? "삭제 성공" : "삭제 실패";
	}

}
