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
		ChatRoomVO vo = getChatRoom(crvo);
		if (vo == null)
			mybatis.insert(NAMESPACE + ".insertChatRoom", crvo);
	}

	public List<ChatVO> showChat(int crId) {
		return mybatis.selectList(NAMESPACE + ".selectChat", crId);
	}

	public List<ChatRoomVO> showChatRoom(int userId) {
		return mybatis.selectList(NAMESPACE + ".selectChatRoomList", userId);
	}

	public void sendMessage(ChatVO cvo) {
		mybatis.insert(NAMESPACE + ".insertMessage", cvo);
	}

	public int getCrId(ChatRoomVO crvo) {
		ChatRoomVO vo = getChatRoom(crvo);
		return vo.getCrId();
	}

	private ChatRoomVO getChatRoom(ChatRoomVO crvo) {
		return mybatis.selectOne(NAMESPACE + ".selectChatRoom", crvo);
	}
}
