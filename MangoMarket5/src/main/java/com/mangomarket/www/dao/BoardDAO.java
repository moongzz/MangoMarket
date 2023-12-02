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
		List<BoardVO> list = getGoods(menuNum);
		List<BoardVO> list2 = new ArrayList<BoardVO>();
		
		for(BoardVO vo : list) {
			BoardVO vo2 = null;
			vo2 = getRegionList(vo.getGoodsId());
			vo.setRegionName(vo2.getRegionName());
			vo2 = getPictureGoods(vo.getGoodsId());
			vo.setImgUrl(vo2.getImgUrl());
			vo.setRealPath(realPath);
			
			list2.add(vo);
		}
		System.out.println("BoardDAO list2 = " + list2);
		return list2;
	}
	
	public List<BoardVO> listBoardFilter(int category, int category2){
		BoardVO vo3 = new BoardVO();
		vo3.setCategory(category + "");
		vo3.setCategory2(category2 + "");
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		if(category2 == 0) list = getGoods(category);
		else list = getGoodsFilter(vo3);
		
		List<BoardVO> list2 = new ArrayList<BoardVO>();
		for(BoardVO vo : list) {
			BoardVO vo2 = null;
			vo2 = getRegionList(vo.getGoodsId());
			vo.setRegionName(vo2.getRegionName());
			vo2 = getPictureGoods(vo.getGoodsId());
			vo.setImgUrl(vo2.getImgUrl());
			vo.setRlId(vo2.getRlId());
			
			list2.add(vo);
		}
		return list2;
		
	}
	
	private List<BoardVO> getGoods(int category){
		return mybatis.selectList(NAMESPACE + ".selectGoods", category);
	}
	
	private List<BoardVO> getGoodsFilter(BoardVO vo){
		return mybatis.selectList(NAMESPACE + ".selectGoodsFilter", vo);
	}
	
	private BoardVO getPictureGoods(int goodsId){
		return mybatis.selectOne(NAMESPACE + ".selectPictureGoods", goodsId);
	}
	
	private BoardVO getRegionList(int goodsId){
		return mybatis.selectOne(NAMESPACE + ".selectRegionList", goodsId);
	}
}
