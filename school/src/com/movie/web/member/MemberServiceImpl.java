package com.movie.web.member;

public class MemberServiceImpl implements MemberService {
	private static MemberService instance = new MemberServiceImpl();
	MemberDAO dao = MemberDAOImpl.getInstance();

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
	public int update(MemberBean member) {
		// 회원 정보 수정
		return dao.update(member);
	}

	@Override
	public int remove(String id) {
		// 회원 탈퇴
		return dao.delete(id);
	}

	@Override
	public boolean isMember(String id) {
		// id 존재 여부 체크
		return dao.isMember(id);
	}
}
