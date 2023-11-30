package com.mangomarket.www.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	private final String NAMESPACE = "com.mangomarket.www.dao.MemberDAO";
	
	public void insertGood(BoardVO vo) {
		mybatis.insert(NAMESPACE + ".insertGood", vo);
		int goodsId = mybatis.selectOne(NAMESPACE + ".getGoodsId", vo);
		System.out.println("BoardDAO insertGood goodsId: " + goodsId);
		vo.setGoodsId(goodsId);
		mybatis.insert(NAMESPACE + ".insertRegion", vo);
		mybatis.insert(NAMESPACE + ".insertPictureGood", vo);
	}
}
