package com.mangomarket.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.mangomarket.www.constants.Path.*;

@Controller
public class FrontController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		return HOME.getPath();
	}
	
	@RequestMapping("/memberRegister")
	public String memberRegister(Model model) {
		return MEMBER_REGISTER_PATH.getPath();
	}
	
	@RequestMapping("/myPage")
	public String myPage(Model model) {
		return MY_PAGE.getPath();
	}
	
	@RequestMapping("/writePost")
	public String writePost(Model model) {
		return WRITE_POST_PAGE.getPath();
	}
	
	@RequestMapping("/goodList")
	public String goodList(@RequestParam("menu") int menuNum, Model model) {
		model.addAttribute("menu", menuNum);
		return GOOD_LIST_PAGE.getPath();
	}
	
	@RequestMapping("/findID")
	public String findID() {
		return FIND_ID_PAGE.getPath();

	}
	
	@RequestMapping("/findPassword")
	public String findPassword() {
		return FIND_PASSWORD_PAGE.getPath();
	}
	
}