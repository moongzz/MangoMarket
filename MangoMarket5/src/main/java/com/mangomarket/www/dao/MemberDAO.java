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
	SqlSession sqlSession;
	
	private final String NAMESPACE = "com.mangomarket.www.dao.MemberDAO";
	
	public int login(MemberVO vo) throws Exception{
		return sqlSession.selectOne(NAMESPACE +".login", vo);
	}
	
	public MemberVO getMember(String id) {
		return sqlSession.selectOne(NAMESPACE + ".getMember", id);
	}
	
	public void insert(MemberVO vo) {
		System.out.println("MemberVO [id=" + vo.getId() + ", imgUrl=" + vo.getImgUrl() + ", userNick=" + vo.getUserNick() + ", userName=" + vo.getUserName()
				+ ", email=" + vo.getEmail() + ", phone=" + vo.getPhone() + ", pwd=" + vo.getPwd() + ", userId=" + vo.getUserId() + "]");
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}
	
	public MemberVO insertUserImg(MemberVO vo) {
		sqlSession.update(NAMESPACE + ".insertUserImg", vo);
		return sqlSession.selectOne(NAMESPACE + ".getMember", vo.getUserId());
	}
	
	public MemberVO userModify(MemberVO vo, int userId) {
		vo.setUserId(userId);
		sqlSession.update(NAMESPACE + ".userModify", vo);
		return sqlSession.selectOne(NAMESPACE + ".getMember", userId);
	}
	
}
