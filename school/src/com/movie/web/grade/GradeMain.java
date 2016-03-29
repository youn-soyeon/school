package com.movie.web.grade;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class GradeMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();

		while (true) {
			System.out.println("[메뉴] 1.등록 2.수정 3.삭제 4.조회(전체) 5.조회(이름) 6.조회(학번) 7.회원수 0.종료");
			
			switch (s.nextInt()) {
			case 1: 
				System.out.println("등록하고자 하는 학생의 id, JAVA, SQL, JSP, 스프링 점수, 이름, 비밀번호, 주소, 생년월일을 입력하세요. > ");
				int result = service.input(new GradeBean(s.next(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt())); // Bean > DAO > DB전달
				break;
			case 2: 
				System.out.println("수정하려는 성적표의 학번, java, sql, jsp, spring 점수를 입력하세요 > ");
				int scoreSeq = s.nextInt();
				break;
			case 3: // o
				System.out.println("삭제하려는 학번을 입력하세요 > ");
				System.out.println(service.delete(s.nextInt()));
				break;
			case 4: // o
				System.out.println("전체 학생의 성적표를 조회합니다.");
				System.out.println(service.getList().toString());
				break;
			case 5: // o
				System.out.println("조회하려는 이름을 입력하세요 > ");
				System.out.println(service.getGradesByName(s.next()));
				break;
			case 6: // o
				System.out.println("조회하려는 학번을 입력하세요 > ");
				System.out.println(service.getGradeByScoreSeq(s.nextInt()));
				break;
			case 7: // o
				System.out.println("총 회원수 : " + service.getCount());
				break;
			case 0: System.out.println("프로그램을 종료합니다."); return;

			default: System.out.println("잘못된 입력입니다. 다시 메뉴로 돌아갑니다."); continue;
			}
		}
	}
}
