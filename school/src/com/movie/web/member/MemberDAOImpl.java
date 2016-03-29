package com.movie.web.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;

public class MemberDAOImpl implements MemberDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체
	private static MemberDAO instance = new MemberDAOImpl(); // 불가피하게 초기화
	
	public static MemberDAO getInstance() {
		// 만들어진 것 가져와서 사용 = singleton 패턴
		return instance;
	}

	public MemberDAOImpl() {
		// 생성자(초기화)
		conn = DatabaseFactory.getDatabase(Vendor.ORACLE, Constants.ID, Constants.PASSWORD).getConnection();
	}
	
	@Override
	public int insert(MemberBean member) {
		// 회원가입
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO Member(id, name, password, addr, birth, major, subject) VALUES (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			pstmt.setString(6, member.getMajor());
			pstmt.setString(7, member.getSubject());
			// insert문을 수행하고나면 return되는 값은 숫자임
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("회원가입 성공여부 : " + result);
		return result;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		// 
		MemberBean tempBean = new MemberBean();
		try {
			stmt = conn.createStatement(); // 내부적으로 Factory 패턴 사용
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = '" + id + "' AND password = '" + password + "'");
			while (rs.next()) {
				tempBean.setId(rs.getString("id"));
				tempBean.setName(rs.getString("name"));
				tempBean.setPassword(rs.getString("password"));
				tempBean.setAddr(rs.getString("addr"));
				tempBean.setBirth(rs.getInt("birth"));
				tempBean.setMajor(rs.getString("major"));
				tempBean.setSubject(rs.getString("subject"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + tempBean.getAddr());
		if(tempBean.getAddr() != null){
			return tempBean;
		} else {
			return null;
		}
		

	}

	@Override
	public MemberBean selectMember(String id) {
		// 회원조회(id)
		MemberBean tempBean = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = '" + id + "'");
			while (rs.next()) {
				tempBean.setId(rs.getString("id"));
				tempBean.setName(rs.getString("name"));
				tempBean.setPassword(rs.getString("password"));
				tempBean.setAddr(rs.getString("addr"));
				tempBean.setBirth(rs.getInt("birth"));
				tempBean.setMajor(rs.getString("major"));
				tempBean.setSubject(rs.getString("subject"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + tempBean.getAddr());
		return tempBean;
	}

	@Override
	public int update(MemberBean memberBean) {
		// 회원 정보 수정
		int result = 0;
		try {
			pstmt = conn.prepareStatement("UPDATE Member SET password = ?, addr = ? WHERE id = ?");
			pstmt.setString(1, memberBean.getPassword());
			pstmt.setString(2, memberBean.getAddr());
			pstmt.setString(3, memberBean.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("update()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("정보수정 성공여부 : " + result);
		return result;

	}

	@Override
	public int delete(String id) {
		// 회원 탈퇴
		int result = 0;
		try {
			pstmt = conn.prepareStatement("DELETE FROM Member WHERE id = ?");
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("회원탈퇴 성공여부 : " + result);
		return result;
	}

	@Override
	public boolean isMember(String id) {
		// id 존재 여부 체크
		boolean isMember = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = '" + id + "'");
			if(rs.next() == true) {
				isMember = true;
			}
		} catch (Exception e) {
			System.out.println("isMember()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + isMember);
		return isMember;
	}

	@Override
	public List<MemberBean> selectList() {
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
				tempBean.setMajor(rs.getString("major"));
				tempBean.setSubject(rs.getString("subject"));
				memberList.add(tempBean);
			}
		} catch (Exception e) {
			System.out.println("selectList()에서 에러 발생");
			e.printStackTrace();
		}
		return memberList;
	}

}
