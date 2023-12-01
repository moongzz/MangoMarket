package com.mangomarket.www.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ValidaroDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Inject
	SqlSession sqlSession;
	
	private final String NAMESPACE = "com.mangomarket.www.dao.ValidaroDAO";
	
	//회원가입 유효성 체크
	public int isUserIDUnique(String id) {
		return mybatis.selectOne(NAMESPACE + ".isUserIDUnique", id);
	}
	
	public int isNickDuplicate(String nick) {
		return mybatis.selectOne(NAMESPACE + ".isNickDuplicate", nick);
	}
	
	public int isEmailDuplicate(String email) {
		return mybatis.selectOne(NAMESPACE + ".isEmailDuplicate", email);
	}
	
	public int isPhoneDuplicate(String phone) {
		return mybatis.selectOne(NAMESPACE + ".isPhoneDuplicate", phone);
	}
	
}
