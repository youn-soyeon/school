package com.movie.web.admin;

import com.movie.web.member.MemberBean;

public class AdminBean extends MemberBean{
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
