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
	public void loginCheck(MemberVO vo, HttpSession session) {
		MemberVO vo2 = dao.loginCheck(vo.getId());
		 if (vo2.getId() != null) { // 세션 변수 저장
//		  session.setAttribute("userid", vo.getUserId());
//		  session.setAttribute("name", name);
		  session.setAttribute("userInfo", vo2);
		}
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate(); // 세션 초기화
	}

	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}
	
	@Override
    public int login(MemberVO vo) throws Exception {
    
        return dao.login(vo);

    }

	@Override
	public MemberVO userModify(MemberVO vo, int userId) {
		return dao.userModify(vo, userId);
	}

	@Override
	public MemberVO selectUser(int userId) {
		return dao.selectUser(userId);
	}

//	@Override
//	public MemberVO login(MemberVO vo) {
//		return null;
//	}
}
