package com.mangomarket.view.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mangomarket.www.service.BoardService;
import com.mangomarket.www.vo.BoardVO;

@RestController
public class DataController {

	@Autowired
	private BoardService boardService;

	@RequestMapping(value = "/goodListOK", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, BoardVO> goodListOK(@RequestParam("menu") int menuNum) {
		String realPath = "/uploadImg/";

		Map<String, BoardVO> map = new HashMap<String, BoardVO>();
		List<BoardVO> list = boardService.listBoard(menuNum, realPath);

		for (int i = 0; i < list.size(); i++) {
			map.put(i + "", list.get(i));
		}

		return map;
	}

	@RequestMapping(value = "/goodListOKFilter", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, BoardVO> goodListOKFilter(@RequestParam("category") int category,
			@RequestParam("category2") int category2) {
		Map<String, BoardVO> map = new HashMap<String, BoardVO>();
		List<BoardVO> list = boardService.listBoardFilter(category, category2);

		for (int i = 0; i < list.size(); i++) {
			map.put(i + "", list.get(i));
		}

		return map;
	}

	@RequestMapping(value = "/searchGoodsOK", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, BoardVO> searchGoods(@RequestParam("search") String searchValue) {
		Map<String, BoardVO> map = new HashMap<String, BoardVO>();
		List<BoardVO> list = boardService.searchGoods(searchValue);

		for (int i = 0; i < list.size(); i++) {
			map.put(i + "", list.get(i));
		}

		return map;
	}
}
