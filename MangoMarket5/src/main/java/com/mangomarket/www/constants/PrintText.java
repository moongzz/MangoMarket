package com.mangomarket.www.constants;

public enum PrintText {
	WISHLIST("WISHLIST"),
	SELL_HISTORY("판매내역"),
	BUY_HISTORY("구매내역");

	private final String text;
	
	PrintText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
