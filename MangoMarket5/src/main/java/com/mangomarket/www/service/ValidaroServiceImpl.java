package com.mangomarket.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mangomarket.www.dao.ValidaroDAO;
import com.mangomarket.www.vo.MemberVO;

@Service("validaroService")
public class ValidaroServiceImpl implements ValidaroService {

	@Inject
	ValidaroDAO dao;
	
	@Override
	public String validateSignUp(MemberVO vo) {
		String errorMsg = "";
		errorMsg += validateUserID(vo.getId());
		errorMsg += validateUserPwd(vo.getPwd());
		errorMsg += validateUserNick(vo.getUserNick());
		
		return errorMsg;
	}
	
	private String validateUserID(String id) {
		if(isUserIDUnique(id)) return "이미 등록된 아이디입니다.";
		else if(isStringLength(id)) return "아이디는 4자 이상 20자 이하까지 가능합니다.";
		else if(!isAlphanumeric(id)) return "아이디는 영어와 숫자만 입력 가능합니다.";
		return "";
	}
	
	private boolean isUserIDUnique(String id) {
		int result = dao.isUserIDUnique(id);
		if(result != 0) return true;
		return false;
	}
	
	private boolean isStringLength(String id) {
		if(id.length() > 20 && id.length() < 4) return true;
		return false;
	}

	private boolean isAlphanumeric(String id) {
		return id.matches("^[a-zA-Z0-9]*$");
	}
	
	private String validateUserPwd(String pwd) {
		if(isPasswordMinLength(pwd)) return "비밀번호는 최소 8자 이상 20자 이하까지 가능합니다.";
		return "";
	}

	private boolean isPasswordMinLength(String pwd) {
		if(pwd.length() < 8 && pwd.length() > 20) return true;
		return false;
	}
	
	private String validateUserNick(String nick) {
		if(isNicknameDuplicate(nick)) return "중복된 닉네임입니다.";
		else if(isNickMaxLength(nick)) return "닉네임은 최대 20자까지 가능합니다.";
		else if(isContainsSpace(nick)) return "공백은 입력할 수 없습니다.";
		return "";
	}
	
	private boolean isNicknameDuplicate(String nick) {
		int result = dao.isNicknameDuplicate(nick);
		if(result != 0) return true;
		return false;
	}
	
	private boolean isNickMaxLength(String nick) {
		if(nick.length() > 20) return true;
		return false;
	}
	
	private boolean isContainsSpace(String nick) {
		if(nick.contains(" ")) return true;
		return false;
	}
}
