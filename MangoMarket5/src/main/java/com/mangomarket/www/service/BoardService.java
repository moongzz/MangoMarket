package com.mangomarket.www.service;

import java.util.List;

import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.WishListVO;

public interface BoardService {

	void insertGood(BoardVO vo);
	
	List<BoardVO> listBoard(int menuNum, String realPath);
	
	List<BoardVO> listBoardFilter(int category, int category2);
	
	BoardVO showGood(int goodsId);
	
	void wishList(WishListVO vo);
	
	List<BoardVO> showWishList(int userId);
	
	List<BoardVO> sellHistory(int userId);
	
	List<BoardVO> buyHistory(int userId);
}
