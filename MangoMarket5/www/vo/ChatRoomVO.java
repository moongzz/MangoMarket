package com.mangomarket.www.vo;

public class ChatRoomVO {
	private int crId;
    private String createdAt;
    private String updatedAt;
    private int buyerId;
    private String buyerStatus;
    private int sellerId;
    private String sellerStatus;
    private int goodsId;
    
    private String buyerNick;
    private String sellerNick;
    
    private String title;
    
    private String saveFileName;
    
    private int countChatRoom;

    
    
	public int getCrId() {
		return crId;
	}

	public void setCrId(int crId) {
		this.crId = crId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerStatus() {
		return buyerStatus;
	}

	public void setBuyerStatus(String buyerStatus) {
		this.buyerStatus = buyerStatus;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerStatus() {
		return sellerStatus;
	}

	public void setSellerStatus(String sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public int getCountChatRoom() {
		return countChatRoom;
	}

	public void setCountChatRoom(int countChatRoom) {
		this.countChatRoom = countChatRoom;
	}
    
    
}
