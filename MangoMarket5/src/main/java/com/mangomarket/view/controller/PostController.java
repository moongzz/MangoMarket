package com.mangomarket.view.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mangomarket.www.service.BoardService;
import com.mangomarket.www.vo.BoardVO;

@Controller
public class PostController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/writePostOK")
	public String writePost(@ModelAttribute("boardVO") BoardVO vo,
							@ModelAttribute("goodImg") MultipartFile goodImg) throws IOException {
		
		String fullPath = "";
		String fileDir = "/users/Moong/desktop/MangoMarketImages/";
		if(!goodImg.isEmpty()) {
			fullPath = fileDir + goodImg.getOriginalFilename();
			goodImg.transferTo(new File(fullPath));
			vo.setImgUrl(goodImg.getOriginalFilename());
		}
		
		if(vo.getCategory2()==null) {
			vo.setCategory2("0");
		}
		String categoryStr = vo.getCategory() + vo.getCategory2();
		int categoryId = Integer.parseInt(categoryStr);
		vo.setCategoryId(categoryId);
		
		String regionName = vo.getRoadAddress() + " " + vo.getDetailAddress() + " " + vo.getExtraAddress();
		vo.setRegionName(regionName);
		
		System.out.println("FrontController [goodsId=" + vo.getGoodsId() + ", createdAt=" + vo.getCreatedAt() + ", status=" + vo.getStatus() + ", sellerId="
				+ vo.getSellerId() + ", rlId=" + vo.getRlId() + ", title=" + vo.getTitle() + ", content=" + vo.getContent() + ", price=" + vo.getPrice()
				+ ", categoryId=" + vo.getCategoryId() + ", pgId=" + vo.getPgId() + ", myFile=" + vo.getImgUrl()
				+ ", regionName=" + vo.getRegionName() + "]");
		
		boardService.insertGood(vo);
		return "home";
	}
}
