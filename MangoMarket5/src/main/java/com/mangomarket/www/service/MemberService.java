package com.mangomarket.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mangomarket.www.vo.MemberVO;

public interface MemberService {
	
	public int login(MemberVO vo) throws Exception;
	
	public void loginCheck(MemberVO vo, HttpSession session);
	
	public void logout(HttpSession session);
	
	public void insert(MemberVO vo);

	public void insertUserImg(MemberVO vo, HttpServletRequest request, HttpSession session);
	
	public MemberVO userModify(MemberVO vo, int userId);

	public MemberVO selectUser(int userId);
	
	public MemberVO findId(String phone);
}
