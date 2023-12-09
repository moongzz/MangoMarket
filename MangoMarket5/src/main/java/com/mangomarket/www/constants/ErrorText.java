package com.mangomarket.www.constants;

public enum ErrorText {
	ID_DUPLICATE("이미 등록된 아이디입니다."),
	ID_LENGTH("아이디는 4자 이상 20자 이하까지 가능합니다."),
	ID_CHARACTERS("아이디는 영어와 숫자만 입력 가능합니다."),
	PW_LENGTH("비밀번호는 최소 8자 이상 20자 이하까지 가능합니다."),
	NICK_DUPLICATE("중복된 닉네임입니다."),
	NICK_LENGTH("닉네임은 최대 20자까지 가능합니다."),
	SPACES("공백은 입력할 수 없습니다."),
	EMAIL_DUPLICATE("이미 등록된 이메일입니다."),
	PHONE_DUPLICATE("이미 등록된 전화번호입니다."),
	PHONE_FORMAT("전화번호를 다시 확인해주세요."),
	TITLE_LENGTH("제목은 20자 이하까지 입력 가능합니다."),
	CATEGORY_NOT_SELECTED("세부 카테코리를 선택해주세요."),
	BLANK(""),
	
	MESSAGE_TO_OWN_POST("본인 게시글에는 메시지를 보낼 수 없습니다."),
	LOGIN_ERROR("유효하지 않은 아이디와 비밀번호 입니다.");
	
	private final String print;
	
	ErrorText(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
