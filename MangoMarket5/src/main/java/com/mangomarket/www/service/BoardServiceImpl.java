package com.mangomarket.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangomarket.www.dao.BoardDAO;
import com.mangomarket.www.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void insertGood(BoardVO vo) {
		dao.insertGood(vo);
	}

	@Override
	public List<BoardVO> listBoard(int menuNum, String realPath) {
		List<BoardVO> list = dao.listBoard(menuNum, realPath);
		return list;
	}

}
