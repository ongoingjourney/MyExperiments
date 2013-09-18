package com.sanjeeb.spring.jdbc.dao;

import com.sanjeeb.spring.jdbc.model.Member;

public interface MemberDAO {
	public int insertMember(Member m);
	public int deleteMember(String email);
	public Member getMember(String email);
}