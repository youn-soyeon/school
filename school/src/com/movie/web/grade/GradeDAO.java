package com.movie.web.grade;

import java.util.List;

public interface GradeDAO { // DAO : data access object
	// C 성적표 등록
	public String insert(GradeMemberBean bean); // 추상 메소드, 기능을 추상화 한다.
	// R 성적표 리스트 출력
	public List<GradeMemberBean> selectAll();
	// R 성적표 조회(학번)
	public GradeMemberBean selectGradeByScoreSeq(int scoreSeq);
	// R 성적표 조회(이름)
	public List<GradeMemberBean> selectGradesByName(String name);
	// R 성적표 조회(id)
	public GradeMemberBean selectGradeById(String id);
	// R 카운트 조회(개수)
	public int count();
	// U 성적표 수정
	public String update(GradeBean grade);
	// D 성적표 삭제
	public String delete(int scoreSeq);
}
