package com.movie.web.grade;

public class GradeMemberBean {
	private String id, password, name, addr;
	private int hak, java, sql, jsp, spring, birth; // 생년월일은 800101 처럼 숫자만 입력

	public GradeMemberBean() {}
	
	public GradeMemberBean(String id, int java, int sql, int jsp, int spring, String name, String password, String addr, int birth) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.java = java;
		this.sql = sql;
		this.jsp = jsp;
		this.spring = spring;
		this.birth = birth;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getSql() {
		return sql;
	}

	public void setSql(int sql) {
		this.sql = sql;
	}

	public int getJsp() {
		return jsp;
	}

	public void setJsp(int jsp) {
		this.jsp = jsp;
	}

	public int getSpring() {
		return spring;
	}

	public void setSpring(int spring) {
		this.spring = spring;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "조회(학번) [아이디=" + id + ", 비밀번호=" + password + ", 이름=" + name + ", 주소=" + addr + ", 학번="
				+ hak + ", 자바=" + java + ", SQL=" + sql + ", JSP=" + jsp + ", 스프링=" + spring + ", 생년월일=" + birth
				+ "]" + "\n";
	}
}
