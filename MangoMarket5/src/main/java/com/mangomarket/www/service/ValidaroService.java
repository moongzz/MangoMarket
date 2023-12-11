package com.mangomarket.www.service;

import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.MemberVO;

public interface ValidaroService {
	
	public String validateSignUp(MemberVO vo);

	public String validateUploadGood(BoardVO vo);
	
	public String validatePwd(String pwd);
}
