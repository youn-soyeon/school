package com.movie.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.movie.web.global.Constants;

public class MemberDAOImpl implements MemberDAO {

	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체

	public MemberDAOImpl() {
		// 생성자(초기화) - 데이터베이스의 서비스
		
	}
	
	@Override
	public String insert(MemberBean member) {
		// 회원가입
		String tempStr = "데이터 등록에 실패하였습니다.";
		try {
			stmt = conn.createStatement();
			rs = pstmt.executeQuery("INSERT INTO Member(id, password, name, addr, birth) VALUES(?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddr());
			pstmt.setInt(5, member.getBirth());
			
			pstmt.executeQuery();

			tempStr = "데이터 등록에 성공하였습니다.";
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		return tempStr;
	}

	@Override
	public MemberBean selectById(String id, String password) {
		// 
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = '" + id + "' AND password = '" + password + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
			System.out.println(id);
			System.out.println(password);
			System.out.println(temp);
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + temp.getAddr());
		return temp;

	}

	@Override
	public MemberBean selectMember(String id) {
		// 회원조회(id)
		MemberBean temp = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member WHERE id = '" + id + "'");
			while (rs.next()) {
				temp.setId(rs.getString("id"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				temp.setAddr(rs.getString("addr"));
				temp.setBirth(rs.getInt("birth"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		System.out.println("쿼리 조회 결과 : " + temp.getAddr());
		return temp;
	}

	@Override
	public void update(MemberBean member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMember(String id) {
		// id 존재 여부 체크
		boolean isMember = false;
//		String tempId = "";
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

}
