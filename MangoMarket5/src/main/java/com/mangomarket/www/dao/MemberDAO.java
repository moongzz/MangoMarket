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
		return mybatis.selectOne(NAMESPACE +".login", vo);
	}
	
	public MemberVO loginCheck(String id) {
		return sqlSession.selectOne(NAMESPACE + ".loginCheck", id);
	}
	
}
