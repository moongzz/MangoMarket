package com.mangomarket.www.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.WishListVO;

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
		BoardVO vo2 = null;
		vo2 = getPictureGoods(goodsId);
		vo.setImgUrl(vo2.getImgUrl());
		mybatis.insert(NAMESPACE + ".insertSellHistory", vo);
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
			vo.setCountWishList(countWishList(vo.getGoodsId()));
			vo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
			
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
			
			vo.setCountWishList(countWishList(vo.getGoodsId()));
			vo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
			
			list2.add(vo);
		}
		return list2;
		
	}
	
	public BoardVO showGood(int goodsId) {
		BoardVO vo = new BoardVO();
		BoardVO vo2 = new BoardVO();
		vo = getGood(goodsId);
		vo2 = getRegionList(goodsId);
		vo2 = getPictureGoods(goodsId);
		vo.setRegionName(vo2.getRegionName());
		vo.setRlId(vo2.getRlId());
		vo.setImgUrl(vo2.getImgUrl());
		vo.setCountWishList(countWishList(vo.getGoodsId()));
		vo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
		return vo;
	}
	
	public List<BoardVO> showWishList(int userId){
		List<WishListVO> userWishList = new ArrayList<WishListVO>();
		List<BoardVO> wishListGoods = new ArrayList<BoardVO>();
		
		userWishList = mybatis.selectList(NAMESPACE + ".getUserWishList", userId);
		for(WishListVO vo : userWishList) {
			BoardVO bvo = getGood(vo.getGoodsId());
			BoardVO imgbvo = getPictureGoods(bvo.getGoodsId());
			bvo.setImgUrl(imgbvo.getImgUrl());
			bvo.setCountWishList(countWishList(vo.getGoodsId()));
			bvo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
			wishListGoods.add(bvo);
		}
		
		return wishListGoods;
	}
	
	public List<BoardVO> sellHistory(int userId){
		List<BoardVO> sellGoods = new ArrayList<BoardVO>();
		List<BoardVO> userSellList = new ArrayList<BoardVO>();
		
		sellGoods = mybatis.selectList(NAMESPACE + ".getSellGoods", userId);
		for(BoardVO vo : sellGoods) {
			BoardVO bvo = getGood(vo.getGoodsId());
			BoardVO imgbvo = getPictureGoods(bvo.getGoodsId());
			bvo.setImgUrl(imgbvo.getImgUrl());
			bvo.setCountWishList(countWishList(vo.getGoodsId()));
			bvo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
			userSellList.add(bvo);
		}
		
		return userSellList;
	}
	
	public List<BoardVO> buyHistory(int userId){
		List<BoardVO> buyGoods = new ArrayList<BoardVO>();
		List<BoardVO> userBuyList = new ArrayList<BoardVO>();
		
		buyGoods = mybatis.selectList(NAMESPACE + ".getBuyGoods", userId);
		for(BoardVO vo : buyGoods) {
			BoardVO bvo = getGood(vo.getGoodsId());
			BoardVO imgbvo = getPictureGoods(bvo.getGoodsId());
			bvo.setImgUrl(imgbvo.getImgUrl());
			bvo.setCountWishList(countWishList(vo.getGoodsId()));
			bvo.setCountChatRoom(countChatRoom(vo.getGoodsId()));
			userBuyList.add(bvo);
		}
		
		return userBuyList;
	}
	
	
	private List<BoardVO> getGoods(int category){
		return mybatis.selectList(NAMESPACE + ".selectGoods", category);
	}
	
	private BoardVO getGood(int goodsId) {
		return mybatis.selectOne(NAMESPACE + ".getGood", goodsId);
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
	
	private int countWishList(int goodsId) {
		return mybatis.selectOne(NAMESPACE + ".countWishList", goodsId);
	}
	
	private int countChatRoom(int goodsId) {
		return mybatis.selectOne(NAMESPACE + ".countChatRoom", goodsId);
	}
}
