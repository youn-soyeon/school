package com.movie.web.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberServiceImpl implements MemberService {
	HashMap<String, MemberBean> map;
	MemberDAO dao = new MemberDAOImpl();

	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}

	@Override
	public String join(MemberBean member) {
		// 회원가입
		String joinResult = "[실패] 가입에 실패하였습니다.";
		map.put(member.getId(), member);
		if (map.size() != 0) {
			joinResult = "[성공] 가입해주셔서 감사합니다.";
		}
		return joinResult;
	}

	@Override
	public String login(String id, String password) {
		// 회원 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비밀번호가 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야 한다.
		String loginResult = "[실패] 아이디가 존재하지 않습니다.";
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			if (it.next().equals(id)) {
				if (map.get(id).getPassword().equals(password)) {
					loginResult = "[성공] 로그인 되었습니다.";
				} else {
					loginResult = "[실패] 비밀번호가 틀렸습니다.";
				}
			}
		}
		return loginResult;
	}

	@Override
	public MemberBean detail(String id) {
		// 회원 정보 조회
		return dao.selectMember(id);
	}

	@Override
	public String update(MemberBean member) {
		// 회원 정보 수정
		String updateResult = "[실패] 정보 수정에 실패하였습니다.";
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			if (it.next().equals(member.getId())) {
				map.replace(member.getId(), member);
				updateResult = "[성공] 회원 정보가 수정되었습니다.";
			} else {
				updateResult = "[실패] 비밀번호가 틀렸습니다.";
			}
		}
		return updateResult;
	}

	@Override
	public String remove(String id, String password) {
		// 회원 탈퇴
		String removeResult = "[실패] 아이디가 존재하지 않습니다.";
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			if (it.next().equals(id)) {
				if (map.get(id).getPassword().equals(password)) {
					map.remove(id);
					removeResult = "[성공] 회원 탈퇴가 완료되었습니다.";
				} else {
					removeResult = "[실패] 비밀번호가 틀렸습니다.";
				}
			}
		}
		return removeResult;
	}
}
