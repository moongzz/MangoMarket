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
		MemberVO vo2 = dao.insertUserImg(vo);
		session.setAttribute("userInfo", vo2);
	}

	@Override
	public MemberVO userModify(MemberVO vo, int userId) {
		return dao.userModify(vo, userId);
	}

	@Override
	public MemberVO selectUser(int userId) {
		return dao.selectUser(userId);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public MemberVO findId(String phone) {
		return dao.findId(phone);
	}

}
