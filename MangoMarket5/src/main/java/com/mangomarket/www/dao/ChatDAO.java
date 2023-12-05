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
	
	private final String NAMESPACE = "com.mangomarket.www.dao.ChatDAO";
	
	public void setChatRoom(ChatRoomVO crvo) {
		ChatRoomVO vo = mybatis.selectOne(NAMESPACE + ".selectChatRoom", crvo);
		if(vo == null) mybatis.insert(NAMESPACE + ".insertChatRoom", crvo);
	}
	
	public List<ChatVO> showChat(int crId){
		List<ChatVO> chatList = mybatis.selectList(NAMESPACE + ".selectChat", crId);
		return chatList;
	}
	
	public List<ChatRoomVO> showChatRoom(int userId){
		List<ChatRoomVO> chatRoomList = mybatis.selectList(NAMESPACE + ".selectChatRoomList", userId);
		return chatRoomList;
	}
}
