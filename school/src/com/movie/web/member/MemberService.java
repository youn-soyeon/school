package com.movie.web.member;

public interface MemberService {
	// 에러 안뜨는 이유 : static은 먼저 메모리에 로딩이 됨
	// 한 곳에 코딩했지만
	// 인터페이스와 이 static으로 선언된 상수는 관련이 없기때문에 에러가 없음
	// 컴파일 하는 순간에 컴퓨터는 static을 다 모아서 따로 빼버림
	// 지금 코드는 하드에 저장된 상태
	// 따라서 관련이없어서 에러 안남
	public final static String NAME = "홍길동";
	
	// 인터페이스는 추상 메소드만 와야한다는 문법이 있어서
	// abstract 생략이 가능하다
	// 그러나 추상 클래스는 구상 메소드가 존재하므로
	// 둘을 구분하기 위해서 반드시 abstract를 붙여야 한다.
	
	/**
	 * 회원가입
	 * */
	public int join(MemberBean member);
	/**
	 * 회원로그인
	 */
	public MemberBean login(String id, String password);
	/**
	 * 내정보보기
	 * */
	public MemberBean detail(String id);
	/**
	 * 회원정보수정
	 * */
	public String update(MemberBean member);
	/**
	 * 회원탈퇴
	 * */
	public String remove(String id, String password);
	/**
	 * id 존재 여부 체크
	 * */
	public boolean isMember(String id);

}
