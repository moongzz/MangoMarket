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
	
	public MemberVO selectUser(int userId) {
		MemberVO vo = new MemberVO();
		vo = mybatis.selectOne(NAMESPACE + ".selectUser", userId);
		return vo;
	}
	
	public MemberVO findId(String phone) {
		return mybatis.selectOne(NAMESPACE + ".findId", phone);
	}
	
	public MemberVO findPW(MemberVO vo) {
		return mybatis.selectOne(NAMESPACE + ".findPW", vo);
	}
	
	public void resetPW(MemberVO vo) {
		mybatis.update(NAMESPACE + ".resetPW", vo);
	}
}
