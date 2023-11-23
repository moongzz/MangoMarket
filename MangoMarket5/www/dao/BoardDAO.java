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
	
	public void insertGood(BoardVO vo) {
		mybatis.insert("BoardDAO.insertGood", vo);
		mybatis.insert("BoardDAO.insertRegion", vo);
		int goodsId = mybatis.selectOne("BoardDAO.getGoodsId", vo);
		System.out.println("BoardDAO insertGood goodsId: " + goodsId);
		vo.setGoodsId(goodsId);
		mybatis.update("BoardDAO.updateRlId", vo);
		mybatis.insert("BoardDAO.insertPictureGood", vo);
		System.out.println( "BoardVO [goodsId=" + vo.getGoodsId() + ", createdAt=" + vo.getCreatedAt() + ", status=" + vo.getStatus() + ", sellerId="
				+ vo.getSellerId() + ", rlId=" + vo.getRlId() + ", title=" + vo.getTitle() + ", content=" + vo.getContent() + ", price=" + vo.getPrice()
				+ ", categoryId=" + vo.getCategoryId() + ", pgId=" + vo.getPgId() + ",  imgUrl=" + vo.getImgUrl() 
				+ ", orgFileName=" + vo.getOrgFileName() + ", saveFileName=" + vo.getSaveFileName() + ", fileSize=" + vo.getFileSize()
				+ ", regionName=" + vo.getRegionName() + "]");
	}

	public List<BoardVO> listBoard(int menuNum, String realPath) {
		List<BoardVO> list = mybatis.selectList("BoardDAO.selectGoods", menuNum);
		List<BoardVO> list2 = new ArrayList<BoardVO>();
		for(BoardVO vo : list) {
			BoardVO vo2 = null;
			vo2 = mybatis.selectOne("BoardDAO.selectRegionlist", vo.getGoodsId());
			vo.setRegionName(vo2.getRegionName());
			vo2 = mybatis.selectOne("BoardDAO.selectPicturegoods", vo.getGoodsId());
			vo.setOrgFileName(vo2.getOrgFileName());
			vo.setSaveFileName(vo2.getSaveFileName());
			vo.setFileSize(vo2.getFileSize());
			vo.setRealPath(realPath);
			int countWishList = mybatis.selectOne("BoardDAO.countWishList", vo.getGoodsId());
			int countChatRoom = mybatis.selectOne("BoardDAO.countChatRoom", vo.getGoodsId());
			vo.setCountWishList(countWishList);
			vo.setCountChatRoom(countChatRoom);
			System.out.println("listBoard [goodsId=" + vo.getGoodsId() + ", createdAt=" + vo.getCreatedAt() + ", status=" + vo.getStatus() + ", sellerId="
					+ vo.getSellerId() + ", rlId=" + vo.getRlId() + ", title=" + vo.getTitle() + ", content=" + vo.getContent() + ", price=" + vo.getPrice()
					+ ", categoryId=" + vo.getCategoryId() + ", pgId=" + vo.getPgId() + ",  imgUrl=" + vo.getImgUrl() + ",  realPath=" + vo.getRealPath() 
					+ ", orgFileName=" + vo.getOrgFileName() + ", saveFileName=" + vo.getSaveFileName() + ", fileSize=" + vo.getFileSize()
					+ ", regionName=" + vo.getRegionName() + "]");
			System.out.println("====================================");
			
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
		
		if(category2 == 0) {
			list = mybatis.selectList("BoardDAO.selectGoods", category);
		}else {
			list = mybatis.selectList("BoardDAO.selectGoodsFilter", vo3);
		}
		
		List<BoardVO> list2 = new ArrayList<BoardVO>();
		for(BoardVO vo : list) {
			BoardVO vo2 = null;
			vo2 = mybatis.selectOne("BoardDAO.selectRegionlist", vo.getGoodsId());
			vo.setRegionName(vo2.getRegionName());
			vo2 = mybatis.selectOne("BoardDAO.selectPicturegoods", vo.getGoodsId());
			vo.setOrgFileName(vo2.getOrgFileName());
			vo.setSaveFileName(vo2.getSaveFileName());
			vo.setFileSize(vo2.getFileSize());
			vo.setRlId(vo2.getRlId());
			int countWishList = mybatis.selectOne("BoardDAO.countWishList", vo.getGoodsId());
			int countChatRoom = mybatis.selectOne("BoardDAO.countChatRoom", vo.getGoodsId());
			vo.setCountWishList(countWishList);
			vo.setCountChatRoom(countChatRoom);
			System.out.println("listBoard [goodsId=" + vo.getGoodsId() + ", createdAt=" + vo.getCreatedAt() + ", status=" + vo.getStatus() + ", sellerId="
					+ vo.getSellerId() + ", rlId=" + vo.getRlId() + ", title=" + vo.getTitle() + ", content=" + vo.getContent() + ", price=" + vo.getPrice()
					+ ", categoryId=" + vo.getCategoryId() + ", pgId=" + vo.getPgId() + ",  imgUrl=" + vo.getImgUrl() + ",  realPath=" + vo.getRealPath() 
					+ ", orgFileName=" + vo.getOrgFileName() + ", saveFileName=" + vo.getSaveFileName() + ", fileSize=" + vo.getFileSize()
					+ ", regionName=" + vo.getRegionName() + "]");
			System.out.println("====================================");
			
			list2.add(vo);
		}
		System.out.println("BoardDAO list2 = " + list2);
		return list2;
	}
	
	public BoardVO showGood(int goodsId) {
		BoardVO vo = new BoardVO();
		vo = mybatis.selectOne("BoardDAO.showGood", goodsId);
		BoardVO vo2 = new BoardVO();
		vo2 = mybatis.selectOne("BoardDAO.selectRegionlist", goodsId);
		vo.setRegionName(vo2.getRegionName());
		vo2 = mybatis.selectOne("BoardDAO.selectPicturegoods", vo.getGoodsId());
		vo.setOrgFileName(vo2.getOrgFileName());
		vo.setSaveFileName(vo2.getSaveFileName());
		vo.setFileSize(vo2.getFileSize());
		vo.setRlId(vo2.getRlId());
		int countWishList = mybatis.selectOne("BoardDAO.countWishList", goodsId);
		int countChatRoom = mybatis.selectOne("BoardDAO.countChatRoom", goodsId);
		vo.setCountWishList(countWishList);
		vo.setCountChatRoom(countChatRoom);
		return vo;
	}
}
