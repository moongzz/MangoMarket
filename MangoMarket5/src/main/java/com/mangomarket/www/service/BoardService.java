package com.mangomarket.www.service;

import java.util.List;

import com.mangomarket.www.vo.BoardVO;

public interface BoardService {

	void insertGood(BoardVO vo);
	
	List<BoardVO> listBoard(int menuNum, String realPath);
	
	List<BoardVO> listBoardFilter(int category, int category2);
}
