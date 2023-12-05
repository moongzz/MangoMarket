package com.mangomarket.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangomarket.www.dao.ChatDAO;
import com.mangomarket.www.vo.ChatRoomVO;
import com.mangomarket.www.vo.ChatVO;

@Service("chatService")
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDAO dao;
	
	@Override
	public void setChatRoom(ChatRoomVO crvo) {
		dao.setChatRoom(crvo);
	}

	@Override
	public List<ChatVO> showChat(int crId) {
		List<ChatVO> chatList = dao.showChat(crId);
		return chatList;
	}

}
