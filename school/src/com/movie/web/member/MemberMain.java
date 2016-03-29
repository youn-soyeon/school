package com.movie.web.member;

import java.util.Scanner;

public class MemberMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MemberService service = new MemberServiceImpl(); // copy 문법? 내일해욧
		
		while (true) {
			System.out.println("[메뉴] 1.가입 2.로그인 3.내정보보기 4.내정보수정 5.탈퇴 0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("[회원가입] 아이디, 이름, 비밀번호, 주소, 생년월일을 입력하세요 > ");
				System.out.println("Main의 회원 가입 결과" + service.join(new MemberBean(s.next(), s.next(), s.next(), s.next(), s.nextInt(), s.next(), s.next()))); 
				break;
			case 2: 
				System.out.println("[로그인] 아이디와 비밀번호를 입력하세요 > ");
				System.out.println(service.login(s.next(), s.next()).toString()); 
				break;
			case 3: 
				System.out.print("[내정보보기] 아이디를 입력하세요 > ");
				System.out.println(service.detail(s.next()).toString());
				break;
			case 4: 
				System.out.println("[내정보수정] 아이디, 비밀번호, 이름, 주소, 생년월일를 입력하세요 > ");
				System.out.println(service.update(new MemberBean(s.next(), s.next(), s.next(), s.next(), s.nextInt(), s.next(), s.next())));
				break;
			case 5: 
				System.out.println("[회원탈퇴] 탈퇴하실 아이디를 입력하세요 > ");
				break;
			
			case 0: System.out.println("프로그램을 종료합니다."); return;
			default: System.out.println("잘못된 입력입니다. 다시 메뉴로 돌아갑니다."); continue;
			}
		}
	}
}
