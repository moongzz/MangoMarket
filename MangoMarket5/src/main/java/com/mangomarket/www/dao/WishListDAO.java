package com.mangomarket.www.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.WishListVO;

@Repository
public class WishListDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	private final String NAMESPACE = "com.mangomarket.www.dao.WishListDAO";
	
	public void wishList(WishListVO vo) {
		mybatis.insert(NAMESPACE + ".wishList", vo);
	}
	
	public WishListVO checkWishList(WishListVO vo) {
		return mybatis.selectOne(NAMESPACE + ".checkWishList", vo);
	}
	
	public void deleteWishList(WishListVO vo) {
		mybatis.delete(NAMESPACE + ".deleteWishList", vo);
	}
}
