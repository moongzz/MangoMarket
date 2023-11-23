package com.mangomarket.www.vo;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
//	원하는 형식으로 데이터를 담아 반환
	private Object data;

	//goods 테이블
	private int goodsId;
	private String createdAt;
	private String status;
	private int sellerId;
//	private int rlId;			
	private String title;
	private String content;
	private int price;
	
	
	private String category;
	private String category2;
	private int categoryId;
	
	//pictureGoods 테이블
//		private int goodsId;
	private int pgId;
	private MultipartFile imgUrl;
	private String orgFileName;
	private String saveFileName;
	private long fileSize;
	
	
	//regionList 테이블
	private int rlId;	//지역Id
	
	private String roadAddress;
	private String jibunAddress;
	private String detailAddress;
	private String extraAddress;
	private String regionName;
	
	private String realPath;
	
	private int countWishList;
	private int countChatRoom;
	
	
	
	
	public int getCountWishList() {
		return countWishList;
	}

	public void setCountWishList(int countWishList) {
		this.countWishList = countWishList;
	}

	public int getCountChatRoom() {
		return countChatRoom;
	}

	public void setCountChatRoom(int countChatRoom) {
		this.countChatRoom = countChatRoom;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public MultipartFile getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(MultipartFile imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getJibunAddress() {
		return jibunAddress;
	}

	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getRlId() {
		return rlId;
	}

	public void setRlId(int rlId) {
		this.rlId = rlId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "BoardVO [data=" + data + ", goodsId=" + goodsId + ", createdAt=" + createdAt + ", status=" + status
				+ ", sellerId=" + sellerId + ", title=" + title + ", content=" + content + ", price=" + price
				+ ", category=" + category + ", category2=" + category2 + ", categoryId=" + categoryId + ", pgId="
				+ pgId + ", imgUrl=" + imgUrl + ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName
				+ ", fileSize=" + fileSize + ", rlId=" + rlId + ", roadAddress=" + roadAddress + ", jibunAddress="
				+ jibunAddress + ", detailAddress=" + detailAddress + ", extraAddress=" + extraAddress + ", regionName="
				+ regionName + ", realPath=" + realPath + ", countWishList=" + countWishList + ", countChatRoom="
				+ countChatRoom + "]";
	}

	
	

	
	
	
}
