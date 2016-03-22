package com.movie.web.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.movie.web.global.Constants;

public class GradeDAOImpl implements GradeDAO {

	/**
	 * DAO에 기본적으로 꼭 들어가야하는 4가지 요소!!
	 */
	private Connection conn; // 오라클 연결 객체
	private Statement stmt; // 쿼리 전송 객체
	private PreparedStatement pstmt; // 쿼리 전송 객체2
	private ResultSet rs; // 리턴값 회수 객체

	@Override
	public String insert(GradeMemberBean bean) {
		String tempStr = "데이터 등록에 실패하였습니다.";
		try {
			Class.forName(Constants.MSSQL_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			pstmt = conn.prepareStatement("INSERT INTO Grade(hak, id, java, sql, jsp, spring) VALUES(hak.NEXTVAL,?,?,?,?,?)");
			pstmt.setString(1, bean.getId());
			pstmt.setInt(2, bean.getJava());
			pstmt.setInt(3, bean.getSql());
			pstmt.setInt(4, bean.getJsp());
			pstmt.setInt(5, bean.getSpring());
			
			pstmt.executeUpdate();

			tempStr = "데이터 등록에 성공하였습니다.";
		} catch (Exception e) {
			System.out.println("insert()에서 에러 발생");
			e.printStackTrace();
		}
		return tempStr;
	}

	@Override
	public List<GradeMemberBean> selectAll() {
		List<GradeMemberBean> gm = new ArrayList<GradeMemberBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember");
			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));

				gm.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectAll()에서 에러 발생");
			e.printStackTrace();
		}
		return gm;
	}

	@Override
	public GradeMemberBean selectGradeByHak(int hak) {
		// R 성적표 조회(학번)

		GradeMemberBean bean = new GradeMemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE hak = '" + hak + "'");
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}

		// System.out.println("쿼리 조회 결과 : " + temp.getAddr());
		return bean;
	}

	@Override
	public List<GradeMemberBean> selectGradesByName(String name) {
		// R 성적표 조회 (이름)
		List<GradeMemberBean> gm = new ArrayList<GradeMemberBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE name = '" + name + "'");
			while (rs.next()) {
				GradeMemberBean bean = new GradeMemberBean();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));

				gm.add(bean);
			}
		} catch (Exception e) {
			System.out.println("selectGradesByName()에서 에러 발생");
			e.printStackTrace();
		}
		return gm;
	}
	
	@Override
	public GradeMemberBean selectGradeById(String id) {
		// R 성적표 조회(id)
		GradeMemberBean bean = new GradeMemberBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GradeMember WHERE id = '" + id + "'");
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setPassword(rs.getString("password"));
				bean.setAddr(rs.getString("addr"));
				bean.setBirth(rs.getInt("birth"));
				bean.setHak(rs.getInt("hak"));
				bean.setJava(rs.getInt("java"));
				bean.setSql(rs.getInt("sql"));
				bean.setJsp(rs.getInt("jsp"));
				bean.setSpring(rs.getInt("spring"));
			}
		} catch (Exception e) {
			System.out.println("selectMember()에서 에러 발생");
			e.printStackTrace();
		}
		// System.out.println("쿼리 조회 결과 : " + temp.getAddr());
		return bean;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			stmt = conn.createStatement();
//			rs = stmt.executeQuery("SELECT COUNT(*) FROM GradeMember");
//			while (rs.next()) {
//				count = rs.getInt(1);
//			}
			// 회원 수가 어마어마할 때
			// while문 사용하는 것 보다
			// 커서가 바로 이동해서 row번호를 가져오는 방식을 사용하는 것이 좋다. (빠름)
			 stmt.executeQuery("SELECT * FROM GradeMember").last();
			 count = rs.getRow();
		} catch (Exception e) {
			System.out.println("count()에서 에러 발생");
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(GradeBean grade) {
		return null;
	}

	@Override
	public String delete(int hak) {
		String tempStr = hak + "의 데이터 삭제에 실패했습니다.";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			conn = DriverManager.getConnection(Constants.ORACLE_URL, Constants.ORACLE_ID, Constants.ORACLE_PASSWORD);
			pstmt = conn.prepareStatement("DELETE FROM GradeMember WHERE = '" + hak + "'");
			pstmt.executeUpdate();
			while (rs.next()) {
				tempStr = hak + "의 데이터를 성공적으로 삭제했습니다.";
			}
		} catch (Exception e) {
			System.out.println("count()에서 에러 발생");
			e.printStackTrace();
		}
		return tempStr;
	}

}
