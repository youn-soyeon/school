package com.movie.web.grade;

import java.util.ArrayList;
import java.util.List;

public class GradeServiceImpl implements GradeService{
	// 멤버 필드(속성 집합)
	ArrayList<GradeBean> gradeList;
	GradeDAO dao = new GradeDAOImpl();
	
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeBean>(); // 초기화
	}
	
	// 멤버 메소드 area(메소드 집)
	@Override
	public void input(GradeBean bean) {
		// C 성적표 등록
		gradeList.add(new GradeBean(2,"김유신",100,100,100,100));
		gradeList.add(new GradeBean(3,"강감찬",90,90,90,90));
		gradeList.add(new GradeBean(4,"유관순",80,80,80,80));
		gradeList.add(new GradeBean(5,"김구",70,70,70,70));
		gradeList.add(new GradeBean(6,"김구",70,70,70,70));
		gradeList.add(bean);
	}

	@Override
	public List<GradeMemberBean> getList() {
		// R 성적표 리스트 출력
		return dao.selectAll();
	}

	@Override
	public GradeMemberBean getGradeByHak(int hak) {
		// R 성적표 조회(학번)
		return dao.selectGradeByHak(hak);
	}

	@Override
	public List<GradeMemberBean> getGradesByName(String name) {
		// R 성적표 조회(이름, 동명이인 가능성)
		return dao.selectGradesByName(name);
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
//		if(gradeList.contains(getGradeByHak(grade.getHak()))){
//			GradeBean searchedGrade = getGradeByHak(grade.getHak());
//			searchedGrade.setJava(grade.getJava());
//			searchedGrade.setSql(grade.getSql());
//			searchedGrade.setJsp(grade.getJsp());
//			searchedGrade.setSpring(grade.getSpring());
//			
//			
//			temp = "수정 성공";
//		}
		/*
		this.delete(grade.getHak());
		this.input(grade);
		*/
		
		return temp;
	}

	@Override
	public String delete(int hak) {
		// D 성적표 삭제
		return (gradeList.remove(this.getGradeByHak(hak))) ? "삭제 성공" : "삭제 실패";
	}

}
