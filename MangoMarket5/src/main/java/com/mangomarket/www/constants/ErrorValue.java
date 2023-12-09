package com.mangomarket.www.constants;

public enum ErrorValue {
	ZERO(0),
	ID_MIN_LENGTH(4),
	ID_MAX_LENGTH(20),
	PW_MIN_LENGTH(8),
	PW_MAX_LENGTH(20),
	NICK_MAX_LENGTH(20),
	TITLE_MAX_LENGTH(20);
	
	private final int errorValue;
	
	ErrorValue(int errorValue) {
        this.errorValue = errorValue;
    }

    public int getValue() {
        return errorValue;
    }
}
