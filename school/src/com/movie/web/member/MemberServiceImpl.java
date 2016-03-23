package com.movie.web.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	HashMap<String, MemberBean> map;
	MemberDAO dao = MemberDAOImpl.getInstance();
	
	public MemberServiceImpl() {
		map = new HashMap<String, MemberBean>();
	}
	
	public static MemberService getInstance() {
		return instance;
	}

	@Override
	public int join(MemberBean member) {
		// 회원가입
		return dao.insert(member);
	}

	@Override
	public MemberBean login(String id, String password) {
		// 회원 로그인 :
		// 아이디가 존재하지 않아서 실패한 경우와 비밀번호가 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야 한다.
		MemberBean member = dao.selectById(id, password);
		if (member != null) {
			return member;
		} else {
			return null;
		}
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

	@Override
	public boolean isMember(String id) {
		// id 존재 여부 체크
		return dao.isMember(id);
	}
}
