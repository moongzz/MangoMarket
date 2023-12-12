package com.mangomarket.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import static com.mangomarket.www.constants.ErrorText.*;
import static com.mangomarket.www.constants.ErrorValue.*;
import com.mangomarket.www.dao.ValidaroDAO;
import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.MemberVO;

@Service("validaroService")
public class ValidaroServiceImpl implements ValidaroService {

	@Inject
	ValidaroDAO dao;

	@Override
	public String validateSignUp(MemberVO vo) {
		String errorMsg = BLANK.getPrint();
		errorMsg += validateUserID(vo.getId());
		errorMsg += validateUserPwd(vo.getPwd());
		errorMsg += validateUserNick(vo.getUserNick());
		errorMsg += validateUserEmail(vo.getEmail());
		errorMsg += validateUserPhone(vo.getPhone());

		return errorMsg;
	}

	@Override
	public String validateUploadGood(BoardVO vo) {
		String errorMsg = BLANK.getPrint();
		errorMsg += validateTitleLength(vo.getTitle());
		errorMsg += validateCategory(vo.getCategory(), vo.getCategory2());
		return errorMsg;
	}

	@Override
	public String validatePwd(String pwd) {
		String errorMsg = BLANK.getPrint();
		errorMsg += validateUserPwd(pwd);
		return errorMsg;
	}

	// 회원가입 유효성 체크
	private String validateUserID(String id) {
		if (isUserIDUnique(id))
			return ID_DUPLICATE.getPrint();
		else if (isStringLength(id))
			return ID_LENGTH.getPrint();
		else if (!isAlphanumeric(id))
			return ID_CHARACTERS.getPrint();
		return BLANK.getPrint();
	}

	private boolean isUserIDUnique(String id) {
		int result = dao.isUserIDUnique(id);
		if (result != ZERO.getValue())
			return true;
		return false;
	}

	private boolean isStringLength(String id) {
		if (id.length() > ID_MAX_LENGTH.getValue() && id.length() < ID_MIN_LENGTH.getValue())
			return true;
		return false;
	}

	private boolean isAlphanumeric(String id) {
		return id.matches("^[a-zA-Z0-9]*$");
	}

	private String validateUserPwd(String pwd) {
		if (isPasswordMinLength(pwd))
			return PW_LENGTH.getPrint();
		return BLANK.getPrint();
	}

	private boolean isPasswordMinLength(String pwd) {
		if (pwd.length() < PW_MIN_LENGTH.getValue() || pwd.length() > PW_MAX_LENGTH.getValue())
			return true;
		return false;
	}

	private String validateUserNick(String nick) {
		if (isNickDuplicate(nick))
			return NICK_DUPLICATE.getPrint();
		else if (isNickMaxLength(nick))
			return NICK_LENGTH.getPrint();
		else if (isContainsSpace(nick))
			return SPACES.getPrint();
		return BLANK.getPrint();
	}

	private boolean isNickDuplicate(String nick) {
		int result = dao.isNickDuplicate(nick);
		if (result != ZERO.getValue())
			return true;
		return false;
	}

	private boolean isNickMaxLength(String nick) {
		if (nick.length() > NICK_MAX_LENGTH.getValue())
			return true;
		return false;
	}

	private boolean isContainsSpace(String nick) {
		if (nick.contains(" "))
			return true;
		return false;
	}

	private String validateUserEmail(String email) {
		if (isEmailDuplicate(email))
			return EMAIL_DUPLICATE.getPrint();
		return BLANK.getPrint();
	}

	private boolean isEmailDuplicate(String email) {
		int result = dao.isEmailDuplicate(email);
		if (result != ZERO.getValue())
			return true;
		return false;
	}

	private String validateUserPhone(String phone) {
		if (isPhoneDuplicate(phone))
			return PHONE_DUPLICATE.getPrint();
		else if (!isPhoneFormat(phone))
			return PHONE_FORMAT.getPrint();
		return BLANK.getPrint();
	}

	private boolean isPhoneDuplicate(String phone) {
		int result = dao.isPhoneDuplicate(phone);
		if (result != ZERO.getValue())
			return true;
		return false;
	}

	private boolean isPhoneFormat(String phone) {
		System.out.println(phone);
		if (phone.matches("^\\d{3}-\\d{4}-\\d{4}$"))
			return true;
		return false;
	}

	// 상품 업로드 유효성 체크
	private String validateTitleLength(String title) {
		if (title.length() > TITLE_MAX_LENGTH.getValue())
			return TITLE_LENGTH.getPrint();
		return BLANK.getPrint();
	}

	private String validateCategory(String category1, String category2) {
		if ((!category1.equals("8") && !category1.equals("9")) && category2 == null)
			return CATEGORY_NOT_SELECTED.getPrint();
		return BLANK.getPrint();
	}

}
