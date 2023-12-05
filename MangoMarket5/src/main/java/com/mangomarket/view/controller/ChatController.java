package com.mangomarket.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mangomarket.www.service.BoardService;
import com.mangomarket.www.service.ChatService;
import com.mangomarket.www.vo.BoardVO;
import com.mangomarket.www.vo.ChatRoomVO;
import com.mangomarket.www.vo.ChatVO;
import com.mangomarket.www.vo.MemberVO;

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = {"/setChatRoom", "/chat"})
	public String chat(Model model, HttpServletRequest request, @RequestParam("goodsId") String goodsId, @RequestParam("buyerId") String buyerId, @RequestParam("sellerId") String sellerId) {
		BoardVO bvo = new BoardVO();
		MemberVO mvo = new MemberVO();
		ChatVO cvo = new ChatVO();
		ChatRoomVO crvo = new ChatRoomVO();
		
		String path = "";
		
		int goodId = Integer.parseInt(goodsId);
		
		bvo = boardService.showGood(goodId);
		model.addAttribute("bvo", bvo);
		
		crvo.setBuyerId(Integer.parseInt(buyerId));
		crvo.setSellerId(Integer.parseInt(sellerId));
		crvo.setBuyerStatus("O");
		crvo.setSellerStatus("O");
		
		if(buyerId.equals(sellerId)) {
			request.setAttribute("errMSG", "본인 게시글에는 메시지를 보낼 수 없습니다.");
			request.setAttribute("url", "home");
			path = "error";
		} else {
			crvo.setGoodsId(goodId);
			//chatRoom 테이블에 crvo 값 넣기
			chatService.setChatRoom(crvo);
			
			model.addAttribute("crvo", crvo);
			
			List<ChatVO> chatList = chatService.showChat(crvo.getCrId());
			request.setAttribute("chatList", chatList);
			
			path = "chat";
		}
		
		return path;
	}
}
