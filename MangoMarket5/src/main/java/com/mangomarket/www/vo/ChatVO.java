package com.mangomarket.www.vo;

public class ChatVO {
	private int chatsId;
	private int crId;
	private String createdAt;
	private String updatedAt;
	private String status;
	private String content;
	private int fromId;
	private int toId;
	
	private String toNick;

	public int getChatsId() {
		return chatsId;
	}

	public void setChatsId(int chatsId) {
		this.chatsId = chatsId;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public String getToNick() {
		return toNick;
	}

	public void setToNick(String toNick) {
		this.toNick = toNick;
	}
	
	
}
