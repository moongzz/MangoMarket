package com.mangomarket.www.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	private final String NAMESPACE = "com.mangomarket.www.dao.BoardDAO";
	
	public void insertGood(BoardVO vo) {
		mybatis.insert(NAMESPACE + ".insertGood", vo);
		int goodsId = mybatis.selectOne(NAMESPACE + ".getGoodsId", vo);
		System.out.println("BoardDAO insertGood goodsId: " + goodsId);
		vo.setGoodsId(goodsId);
		mybatis.insert(NAMESPACE + ".insertRegion", vo);
		mybatis.insert(NAMESPACE + ".insertPictureGood", vo);
	}
	
	public List<BoardVO> listBoard(int menuNum, String realPath){
		List<BoardVO> list = mybatis.selectList(NAMESPACE + ".selectGoods", menuNum);
		List<BoardVO> list2 = new ArrayList<BoardVO>();
		
		for(BoardVO vo : list) {
			BoardVO vo2 = null;
			vo2 = mybatis.selectOne(NAMESPACE + ".selectRegionList", vo.getGoodsId());
			vo.setRegionName(vo2.getRegionName());
			vo2 = mybatis.selectOne(NAMESPACE + ".selectPictureGoods", vo.getGoodsId());
			vo.setImgUrl(vo2.getImgUrl());
			vo.setRealPath(realPath);
			
			list2.add(vo);
		}
		System.out.println("BoardDAO list2 = " + list2);
		return list2;
	}
}
