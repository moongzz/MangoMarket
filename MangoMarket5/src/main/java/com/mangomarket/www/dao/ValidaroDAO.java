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
	
	public int isUserIDUnique(String id) {
		return mybatis.selectOne(NAMESPACE + ".isUserIDUnique", id);
	}
}
