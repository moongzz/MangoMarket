package com.mangomarket.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangomarket.www.dao.BoardDAO;
import com.mangomarket.www.dao.WishListDAO;
import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.WishListVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private WishListDAO wishListDao;
	
	@Override
	public void insertGood(BoardVO vo) {
		dao.insertGood(vo);
	}

	@Override
	public List<BoardVO> listBoard(int menuNum, String realPath) {
		List<BoardVO> list = dao.listBoard(menuNum, realPath);
		return list;
	}

	@Override
	public List<BoardVO> listBoardFilter(int category, int category2) {
		List<BoardVO> list = dao.listBoardFilter(category, category2);
		return list;
	}

	@Override
	public BoardVO showGood(int goodsId) {
		BoardVO vo = dao.showGood(goodsId);
		return vo;
	}

	@Override
	public void wishList(WishListVO vo) {
		if(wishListDao.checkWishList(vo) != null) {
			wishListDao.deleteWishList(vo);
		} else {
			wishListDao.wishList(vo);
		}
	}

	@Override
	public List<BoardVO> showWishList(int userId) {
		List<BoardVO> list = dao.showWishList(userId);
		return list;
	}

	@Override
	public List<BoardVO> sellHistory(int userId) {
		List<BoardVO> list = dao.sellHistory(userId);
		return list;
	}
	
	@Override
	public List<BoardVO> buyHistory(int userId) {
		List<BoardVO> list = dao.buyHistory(userId);
		return list;
	}

	@Override
	public void completeSale(BoardVO vo) {
		dao.completeSale(vo);
	}

	
}
