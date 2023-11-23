package com.mangomarket.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mangomarket.www.vo.ChatRoomVO;
import com.mangomarket.www.vo.ChatVO;

@Repository
public class ChatDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setChatRoom(ChatRoomVO crvo) {
		ChatRoomVO vo = mybatis.selectOne("ChatDAO.selectChatRoom", crvo);
		if(vo == null){
			mybatis.insert("ChatDAO.insertChatRoom", crvo);
		} else{
			crvo.setCrId(vo.getCrId());
			System.out.println("이미 채팅방이 있습니다.");
		}
	}

	public List<ChatVO> showChat(int crId) {
		List<ChatVO> chatList = mybatis.selectList("ChatDAO.selectChat", crId);
		return chatList;
	}

	public List<ChatRoomVO> showChatRoom(int userId) {
		List<ChatRoomVO> chatRoomList = mybatis.selectList("ChatDAO.selectChatRoomList", userId);
		return chatRoomList;
	}
	
	public void sendMessage(ChatVO cvo) {
		mybatis.insert("ChatDAO.insertMessage", cvo);
	}
}
