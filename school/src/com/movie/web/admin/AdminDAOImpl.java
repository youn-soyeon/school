package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
import com.movie.web.grade.GradeBean;
import com.movie.web.grade.GradeMemberBean;
import com.movie.web.member.MemberBean;

public class AdminDAOImpl implements AdminDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static AdminDAO instance = new AdminDAOImpl(); // 불가피하게 초기화

	public static AdminDAO getInstance() {
		return instance;
	}

	public AdminDAOImpl() {
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}

	@Override
	public List<MemberBean> selectAllMember() {
		// 전체 회원 정보 보기
		List<MemberBean> memberList = new ArrayList<MemberBean>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member");
			while (rs.next()) {
				MemberBean tempBean = new MemberBean();
				tempBean.setId(rs.getString("id"));
				tempBean.setName(rs.getString("name"));
				tempBean.setPassword(rs.getString("password"));
				tempBean.setAddr(rs.getString("addr"));
				tempBean.setBirth(rs.getInt("birth"));
				memberList.add(tempBean);
			}
		} catch (Exception e) {
			System.out.println("selectAllMember()에서 에러 발생");
			e.printStackTrace();
		}
		return memberList;
	}
	
	@Override
	public List<GradeMemberBean> selectAllMemberGrade() {
		// 학생 전체 점수 조회
		List<GradeMemberBean> memberList = new ArrayList<GradeMemberBean>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			while (rs.next()) {
				GradeMemberBean tempBean = new GradeMemberBean();
				tempBean.setId(rs.getString("id"));
				tempBean.setName(rs.getString("name"));
				tempBean.setPassword(rs.getString("password"));
				tempBean.setAddr(rs.getString("addr"));
				tempBean.setBirth(rs.getInt("birth"));
				tempBean.setScoreSeq(rs.getInt("scoreSeq"));
				tempBean.setJava(rs.getInt("java"));
				tempBean.setSql(rs.getInt("sql"));
				tempBean.setJsp(rs.getInt("jsp"));
				tempBean.setSpring(rs.getInt("spring"));
				memberList.add(tempBean);
			}
		} catch (Exception e) {
			System.out.println("selectAllMember()에서 에러 발생");
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public int insertScore(GradeBean grade) {
		// 학생 점수 추가하기
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Grade(score_seq, id, java, sql, jsp, spring) VALUES (score_seq.NEXTVAL, ?, ?, ?, ?, ?)");
			pstmt.setString(1, grade.getId());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getJsp());
			pstmt.setInt(5, grade.getSpring());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insertScore()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("학생 점수 추가 결과 : " + result);
		return result;
	}

	@Override
	public List<GradeBean> selectGradeById(String id) {
		// id로 특정 학생의 점수 조회하기
		List<GradeBean> gradeBeanList = new ArrayList<GradeBean>();
		try {
			pstmt = conn.prepareStatement("SELECT * FROM Grade WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeBean tempBean = new GradeBean();
				tempBean.setId(rs.getString("id"));
				tempBean.setJava(rs.getInt("java"));
				tempBean.setSql(rs.getInt("sql"));
				tempBean.setJsp(rs.getInt("jsp"));
				tempBean.setSpring(rs.getInt("spring"));
				gradeBeanList.add(tempBean);
			}
		} catch (Exception e) {
			System.out.println("selectGradeById()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("학생 점수 추가 결과 : ");
		return gradeBeanList;
	}

	@Override
	public AdminBean selectAdmin(String id, String password) {
		// 아이디 비밀번호로 관리자 정보 가져오기
		AdminBean temp = new AdminBean();
		try {
			stmt = conn.createStatement(); // 내부적으로 Factory 패턴 사용
			rs = stmt.executeQuery("SELECT * FROM Admin WHERE id = '" + id + "' AND password = '" + password + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
				temp.setRole(rs.getString("role"));
			}
			System.out.println(id);
			System.out.println(password);
			System.out.println(temp);
		} catch (Exception e) {
			System.out.println("selectAdmin()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + temp.getName());
		return temp;
	}
}
