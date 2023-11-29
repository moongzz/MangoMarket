package com.mangomarket.www.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.mangomarket.www.dao.MemberDAO;
import com.mangomarket.www.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO dao;

	@Override
	public int login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}
	
	@Override
	public void loginCheck(MemberVO vo, HttpSession session) {
		MemberVO vo2 = dao.getMember(vo.getId());
		if(vo2.getId() != null) {
			session.setAttribute("userInfo", vo2);
		}
	}
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public void insertUserImg(MemberVO vo, HttpServletRequest request, HttpSession session) {
		System.out.println("imgUrl = " + vo.getImgUrl());
		dao.insertUserImg(vo);
		MemberVO vo2 = dao.getMember(vo.getId());
		session.setAttribute("userInfo", vo2);
	}

}
