package com.mangomarket.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mangomarket.www.service.MemberService;
import com.mangomarket.www.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/login")
	public String login(@RequestParam("id") String id
						,@RequestParam("pwd") String pwd
						,HttpServletRequest request
						,HttpSession seesion) throws Exception {
		String path = "";
		
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setPwd(pwd);
		
		int result = memberService.login(vo);
		
		if(result == 1) {
			path = "home";
			memberService.loginCheck(vo, seesion);
		} else if(result != 1){
			request.setAttribute("errMSG", "유효하지 않은 아이디와 비밀번호 입니다.");
			request.setAttribute("url", "home");
			path = "error";
		}
		
		return path; 
	}
}
