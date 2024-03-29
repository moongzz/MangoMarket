package com.mangomarket.www.service;

import javax.servlet.http.HttpSession;

import com.mangomarket.www.vo.MemberVO;

public interface MemberService {
	
	public void insert(MemberVO vo);
	
	public void loginCheck(MemberVO vo, HttpSession session);
	
	public void logout(HttpSession session);
	
//	public MemberVO login(MemberVO vo);
	
	public int login(MemberVO vo) throws Exception;
	
	public MemberVO userModify(MemberVO vo, int userId);
	
	public MemberVO selectUser(int userId);
}
