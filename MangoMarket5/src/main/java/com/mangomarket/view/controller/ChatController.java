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

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = {"/setChatRoom", "/chat"})
	public String chat(Model model, HttpServletRequest request, @RequestParam("goodsId") int goodsId, @RequestParam("buyerId") int buyerId, @RequestParam("sellerId") int sellerId) {
		BoardVO bvo = new BoardVO();
		ChatRoomVO crvo = new ChatRoomVO();
		
		String path = "";
		
		
		bvo = boardService.showGood(goodsId);
		model.addAttribute("bvo", bvo);
		
		crvo.setBuyerId(buyerId);
		crvo.setSellerId(sellerId);
		crvo.setBuyerStatus("O");
		crvo.setSellerStatus("O");
		
		if(buyerId == sellerId) {
			request.setAttribute("errMSG", "본인 게시글에는 메시지를 보낼 수 없습니다.");
			request.setAttribute("url", "home");
			path = "error";
		} else {
			crvo.setGoodsId(goodsId);
			//chatRoom 테이블에 crvo 값 넣기
			chatService.setChatRoom(crvo);
			
			model.addAttribute("crvo", crvo);
			
			int crId = chatService.getCrId(crvo);
			
			List<ChatVO> chatList = chatService.showChat(crId);
			request.setAttribute("chatList", chatList);
			
			path = "chat";
		}
		
		return path;
	}
	
	@RequestMapping("/chatRoom")
	public String chatRooms(@RequestParam("userId") int userId, Model model) {
		List<ChatRoomVO> chatRoomList = chatService.showChatRoom(userId);
		model.addAttribute("chatRoomList", chatRoomList);
		return "chatRoom";
	}
	
	@RequestMapping("/sendMessage")
	public String sendMessage(Model model,
							@RequestParam("content") String content,
				    		@RequestParam("fromId") int fromId,
				    		@RequestParam("buyer") int buyer, 
				    		@RequestParam("seller") int seller,
				    		@RequestParam("goodsId") int goodsId) {
		
		BoardVO bvo = new BoardVO();
    	bvo = boardService.showGood(goodsId);
		model.addAttribute("bvo", bvo);
		
		ChatRoomVO crvo = new ChatRoomVO();
		crvo.setBuyerId(buyer);
		crvo.setSellerId(seller);
		crvo.setGoodsId(goodsId);
		int crId = chatService.getCrId(crvo);
		
		ChatVO cvo = new ChatVO();
		
		cvo.setCrId(crId);
		cvo.setContent(content);
		cvo.setFromId(fromId);
		if(fromId == buyer) {
			cvo.setToId(seller);
		}else if(fromId == seller) {
			cvo.setToId(buyer);
		}
		
		chatService.sendMessage(cvo);
		List<ChatVO> chatList = chatService.showChat(crId);
		model.addAttribute("chatList", chatList);
		model.addAttribute("crvo", crvo);
		return "chat";
	}
}
