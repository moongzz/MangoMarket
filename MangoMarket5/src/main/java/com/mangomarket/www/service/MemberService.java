package com.mangomarket.www.service;

import javax.servlet.http.HttpSession;

import com.mangomarket.www.vo.MemberVO;

public interface MemberService {
	
	public int login(MemberVO vo) throws Exception;
	
	public void loginCheck(MemberVO vo, HttpSession session);
	
	public void insert(MemberVO vo);

}
