package com.movie.web.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;
import com.movie.web.global.DatabaseFactory;
import com.movie.web.global.Vendor;
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
		MemberBean tempBean = new MemberBean();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Member");
			while (rs.next()) {
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
	public void insertScore() {
		// 학생 점수 추가하기

	}

}
