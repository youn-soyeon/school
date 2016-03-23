package com.movie.web.admin;

import java.util.List;

import com.movie.web.member.MemberBean;

public interface AdminDAO {
	public List<MemberBean> selectAllMember();
	public void insertScore();
}
