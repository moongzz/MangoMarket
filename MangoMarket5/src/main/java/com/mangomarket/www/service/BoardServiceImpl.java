package com.mangomarket.www.service;

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

}
