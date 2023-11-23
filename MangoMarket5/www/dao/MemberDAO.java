package com.mangomarket.www.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Inject
	SqlSession sqlSession; // SqlSession 의존관계 주입

	public MemberVO loginCheck(String id) {
//		return sqlSession.selectOne("member.login_check", vo);
		return sqlSession.selectOne("MemberDAO.loginCheck", id);
	}
	
	public void insert(MemberVO vo) {
		System.out.println("MemberVO [id=" + vo.getId() + ", imgUrl=" + vo.getImgUrl() + ", userNick=" + vo.getUserNick() + ", userName=" + vo.getUserName()
				+ ", email=" + vo.getEmail() + ", phone=" + vo.getPhone() + ", pwd=" + vo.getPwd() + ", userId=" + vo.getUserId() + "]");
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	public int login(MemberVO vo) throws Exception {
        return mybatis.selectOne("MemberDAO.login", vo);
    }
	
	public MemberVO userModify(MemberVO vo, int userId) {
		vo.setUserId(userId);
		mybatis.update("MemberDAO.userModify", vo);
		return sqlSession.selectOne("MemberDAO.loginCheck", userId);
	}
	
	public MemberVO selectUser(int userId) {
		MemberVO vo = new MemberVO();
		vo = mybatis.selectOne("MemberDAO.selectUser", userId);
		return vo;
	}
//	public MemberVO getUser(String id) {
//		return mybatis.selectOne("MemberDAO.getUser", id);
//	}
}
