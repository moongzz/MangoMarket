package com.mangomarket.www.constants;

public enum Path {
	HOME("home"),
	ERROR_PAGE("eroor"),
	CHAT_PAGE("chat"),
	CHAT_ROOM_PAGE("chatRoom"),
	MEMBER_REGISTER_PATH("memberRegister"),
	MY_PAGE("myPage"),
	WRITE_POST_PAGE("writePost"),
	GOOD_LIST_PAGE("goodList"),
	GOOD_PAGE("good"),
	USER_HISTORY_PAGE("userHistory"),
	FIND_ID_PAGE("findID"),
	FIND_PASSWORD_PAGE("findPassword");
	
	private final String path;
	
	Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
