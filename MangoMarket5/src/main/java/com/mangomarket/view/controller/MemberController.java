package com.mangomarket.view.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mangomarket.www.constants.ErrorText;
import com.mangomarket.www.constants.Path;
import com.mangomarket.www.service.MemberService;
import com.mangomarket.www.vo.MemberVO;

import com.mangomarket.www.service.ValidaroService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private ValidaroService ValidaroService;
	
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
			path = Path.HOME.getPath();
			memberService.loginCheck(vo, seesion);
		} else if(result != 1){
			request.setAttribute("errMSG", ErrorText.LOGIN_ERROR.getPrint());
			request.setAttribute("url", Path.HOME.getPath());
			path = Path.ERROR_PAGE.getPath();
		}
		
		return path; 
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		memberService.logout(session);
		return Path.HOME.getPath();
	}
	
	@RequestMapping("/memberRegisterOK")
	public String memberRegisterOK(MemberVO vo,HttpServletRequest request) throws Exception {
		//중복 체크
		String errorMsg = ValidaroService.validateSignUp(vo);
		String path = "";
		
		if(errorMsg.equals("")) {
			memberService.insert(vo);
			path = Path.HOME.getPath();
		} else {
			request.setAttribute("errMSG", errorMsg);
			request.setAttribute("url", "memberRegister");
			path = Path.ERROR_PAGE.getPath();
		}
		
		return path;
	}
	
	@RequestMapping("/uploadUserImg")
	public String uploadUserImg(@RequestParam("imgUrl") MultipartFile file,
								@RequestParam("userId") int userId,
								HttpServletRequest request,
								HttpSession seesion) throws IOException {
		String fullPath = "";
		String fileDir = "/users/Moong/desktop/MangoMarketImages/";
		if(!file.isEmpty()) {
			fullPath = fileDir + file.getOriginalFilename();
			file.transferTo(new File(fullPath));
		}
		MemberVO vo = new MemberVO();
		vo.setImgUrl(file.getOriginalFilename());
		vo.setUserId(userId);
		memberService.insertUserImg(vo, request, seesion);
		return Path.HOME.getPath();
	}
	
	@RequestMapping("/userModify")
	public String userModify(MemberVO vo, int userId, HttpSession session, HttpServletRequest request) {
		MemberVO vo2 = memberService.userModify(vo, userId);
		request.getSession().setAttribute("userInfo", vo2);
		return Path.HOME.getPath();
	}
}
