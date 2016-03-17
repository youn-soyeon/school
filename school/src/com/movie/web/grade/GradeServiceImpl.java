package com.movie.web.grade;

import java.util.ArrayList;

public class GradeServiceImpl implements GradeService{
	// 멤버 필드(속성 집합)
	ArrayList<GradeBean> gradeList;
	
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
	public ArrayList<GradeBean> getList() {
		// R 성적표 리스트 출력
		return gradeList;
	}

	@Override
	public GradeBean getGradeByHak(int hak) {
		// R 성적표 조회(학번)
		GradeBean tempGrade = new GradeBean(); // 리턴값 담기위한 것
		for (int i = 0; i < gradeList.size(); i++) {
			if (hak == gradeList.get(i).getHak()) {
				tempGrade = gradeList.get(i);
				break;
			}
		}
		return tempGrade;
	}

	@Override
	public ArrayList<GradeBean> getGradesByName(String name) {
		// R 성적표 조회(이름, 동명이인 가능성)
		ArrayList<GradeBean> tempList = new ArrayList<GradeBean>();
		for (int i = 0; i < gradeList.size(); i++) {
			if (name.equals(gradeList.get(i).getName())) {
				tempList.add(gradeList.get(i));
			}
		}
		return tempList;
	}
	
	@Override
	public int getCount() {
		// R 카운트 조회(개수)
		return gradeList.size();		
	}

	@Override
	public void getCountByName() {
		// R 이름조회시 카운트 조회

	}

	@Override
	public String update(GradeBean grade) {
		// U 성적표 수정
		
		String temp = "수정 실패";
		if(gradeList.contains(getGradeByHak(grade.getHak()))){
			GradeBean searchedGrade = getGradeByHak(grade.getHak());
			searchedGrade.setJava(grade.getJava());
			searchedGrade.setSql(grade.getSql());
			searchedGrade.setJsp(grade.getJsp());
			searchedGrade.setSpring(grade.getSpring());
			
			
			temp = "수정 성공";
		}
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
