package com.mangomarket.www.service;

import java.util.List;

import com.mangomarket.www.vo.ChatRoomVO;
import com.mangomarket.www.vo.ChatVO;

public interface ChatService {

	void setChatRoom(ChatRoomVO crvo);
	
	List<ChatVO> showChat(int crId);

	List<ChatRoomVO> showChatRoom(int userId);
	
	void sendMessage(ChatVO cvo);
	
	int getCrId(ChatRoomVO crvo);
}
