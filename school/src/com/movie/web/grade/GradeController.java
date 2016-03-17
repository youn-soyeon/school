package com.movie.web.grade;

import java.util.Scanner;
import java.util.ArrayList;

public class GradeController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();
		GradeBean temp = new GradeBean();
		String tempStr = "";
		while (true) {
			System.out.println("[메뉴] 1.등록 2.수정 3.삭제 4.조회(전체) 5.조회(이름) 6.조회(학번) 7.회원수 0.종료");
			
			switch (s.nextInt()) {
			case 1: 
				System.out.println("등록하고자 하는 학생의 학번, 이름, JAVA, SQL, JSP, 스프링 점수를 입력하세요. > ");
				service.input(new GradeBean(s.nextInt(), s.next(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt())); // Bean > DAO > DB전달
				System.out.println("등록을 완료하였습니다.");
				break;
			case 2: 
				System.out.println("수정하려는 성적표의 학번, java, sql, jsp, spring 점수를 입력하세요 > ");
				int hak = s.nextInt();
				String name = service.getGradeByHak(hak).getName();
				System.out.println(service.update(new GradeBean(hak, name, s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt())));
				break;
			case 3: 
				System.out.println("삭제하려는 학번을 입력하세요 > ");
				System.out.println(service.delete(s.nextInt()));
				break;
			case 4: 
				System.out.println("전체 학생의 성적표를 조회합니다.");
				System.out.println(service.getList());
				break;
			case 5: 
				System.out.println("조회하려는 이름을 입력하세요 > ");
				ArrayList<GradeBean> tempList = service.getGradesByName(s.next());
				System.out.println((tempList.size() == 0) ? "조회하려는 이름이 없습니다." : tempList);
				break;
			case 6: 
				System.out.println("조회하려는 학번을 입력하세요 > ");
				temp = service.getGradeByHak(s.nextInt());
				tempStr = (temp.getName() != null) ? temp.toString() : "조회하려는 학번이 없습니다.";
				System.out.println(tempStr);
				break;
			case 7: 
				System.out.println(service.getCount());
				break;
			case 0: System.out.println("프로그램을 종료합니다."); return;

			default: System.out.println("잘못된 입력입니다. 다시 메뉴로 돌아갑니다."); continue;
			}
		}
	}
}
