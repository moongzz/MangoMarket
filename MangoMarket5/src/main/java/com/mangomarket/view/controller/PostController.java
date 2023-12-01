package com.mangomarket.view.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mangomarket.www.service.BoardService;
import com.mangomarket.www.service.ValidaroService;
import com.mangomarket.www.vo.BoardVO;

@Controller
public class PostController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ValidaroService validaroService;
	
	@RequestMapping("/writePostOK")
	public String writePost(@ModelAttribute("boardVO") BoardVO vo,
							@ModelAttribute("goodImg") MultipartFile goodImg,
							HttpServletRequest request) throws IOException {
		String errorMsg = validaroService.validateUploadGood(vo);
		String path = "";
		
		if(errorMsg.equals("")) {
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
			
			boardService.insertGood(vo);
			path = "home";
		} else {
			request.setAttribute("errMSG", errorMsg);
			request.setAttribute("url", "writePost");
			path = "error";
		}
		
		return path;
	}
}
