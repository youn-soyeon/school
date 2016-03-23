package com.movie.web.admin;

import java.util.Scanner;

import com.movie.web.grade.GradeBean;

public class AdminMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AdminService service = new AdminServiceImpl(); // copy 문법? 내일해욧

		while (true) {
			System.out.println("[메뉴] 1.전체회원리스트조회 2.학생성적추가 3.특정학생성적조회 0.종료");
			switch (s.nextInt()) {
			case 1:
				System.out.println("전체 회원 리스트를 조회합니다");
				System.out.println(service.getMemberList().toString());
				break;
			case 2:
				System.out.println("아이디와 학생 점수를 입력하세요(java, sql, jsp, spring) >  ");
				GradeBean bean = new GradeBean(s.next(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
				System.out.println(service.addScore(bean));
				break;
			case 3:
				System.out.println("아이디를 입력하세여 >  ");
				System.out.println(service.getGradeListById(s.next()));
				break;

			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 메뉴로 돌아갑니다.");
				continue;
			}
		}
	}
}
