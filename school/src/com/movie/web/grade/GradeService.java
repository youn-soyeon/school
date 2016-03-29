package com.movie.web.grade;

import java.util.List;

/**
 * CRUD
 * C : create 생성
 * R : read 조회
 * U : update 수정
 * D : delete 삭제
 * */

public interface GradeService {
	// C 성적표 등록
	public int input(GradeBean gradeBean); // 추상 메소드, 기능을 추상화 한다.
	// R 성적표 리스트 출력
	public List<GradeMemberBean> getList();
	// R 성적표 조회(학번)
	public GradeMemberBean getGradeByScoreSeq(int scoreSeq);
	// R 성적표 조회(이름)
	public List<GradeMemberBean> getGradesByName(String name);
	// R 성적표 조회(id)
	public GradeMemberBean getGradeById(String id);
	// R 카운트 조회(개수)
	public int getCount();
	// R 이름조회시 카운트 조회
	public void getCountByName();
	// U 성적표 수정
	public String update(GradeBean grade);
	// D 성적표 삭제
	public String delete(int scoreSeq);

}
