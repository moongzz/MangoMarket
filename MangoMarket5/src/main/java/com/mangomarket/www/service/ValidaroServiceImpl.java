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
		if(result == 1) return true;
		return false;
	}
	
	private boolean isStringLength(String id) {
		if(id.length() > 20 && id.length() < 4) return true;
		return false;
	}

	private boolean isAlphanumeric(String id) {
		return id.matches("^[a-zA-Z0-9]*$");
	}

}
