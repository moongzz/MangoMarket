package com.mangomarket.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/memberRegister")
	public String memberRegister(Model model) {
		return "memberRegister";
	}
	
	@RequestMapping("/myPage")
	public String myPage(Model model) {
		return "myPage";
	}
}