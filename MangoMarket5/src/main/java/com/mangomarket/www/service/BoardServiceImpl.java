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
		if (menuNum == 0)
			return dao.getPopularItems(realPath);
		else
			return dao.listBoard(menuNum, realPath);
	}

	@Override
	public List<BoardVO> listBoardFilter(int category, int category2) {
		return dao.listBoardFilter(category, category2);
	}

	@Override
	public BoardVO showGood(int goodsId) {
		return dao.showGood(goodsId);
	}

	@Override
	public void wishList(WishListVO vo) {
		if (wishListDao.checkWishList(vo) != null)
			wishListDao.deleteWishList(vo);
		else
			wishListDao.wishList(vo);
	}

	@Override
	public List<BoardVO> showWishList(int userId) {
		return dao.showWishList(userId);
	}

	@Override
	public List<BoardVO> sellHistory(int userId) {
		return dao.sellHistory(userId);
	}

	@Override
	public List<BoardVO> buyHistory(int userId) {
		return dao.buyHistory(userId);
	}

	@Override
	public void completeSale(BoardVO vo) {
		dao.completeSale(vo);
	}

	@Override
	public List<BoardVO> searchGoods(String searchValue) {
		return dao.searchGoods(searchValue);
	}

}
