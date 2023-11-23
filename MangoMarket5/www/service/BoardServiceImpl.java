package com.mangomarket.www.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mangomarket.www.dao.BoardDAO;
import com.mangomarket.www.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;

	@Override
	public void insertGood(BoardVO vo, HttpServletRequest request) {

		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값 얻어오기 
	      MultipartFile myFile=vo.getImgUrl();
	      //원본 파일명
	      String orgFileName=myFile.getOriginalFilename();
	      //파일의 크기
	      long fileSize=myFile.getSize();
	      
	      // webapp/resources/upload 폴더 까지의 실제 경로(서버의 파일시스템 상에서의 경로)
	      String realPath=request.getServletContext().getRealPath("/resources/upload");
	      System.out.println("realPath = " + realPath);
	      vo.setRealPath(realPath);
	      
	      //저장할 파일의 상세 경로
	      String filePath=realPath+File.separator;
	      //디렉토리를 만들 파일 객체 생성
	      File upload=new File(filePath);
	      if(!upload.exists()) {//만일 디렉토리가 존재하지 않으면 
	         upload.mkdir(); //만들어 준다.
	      }
	      
	      //저장할 파일 명을 구성한다.
	      String saveFileName=
	            System.currentTimeMillis()+orgFileName;
	      try {
	         //upload 폴더에 파일을 저장한다.
	         myFile.transferTo(new File(filePath+saveFileName));
	         System.out.println(filePath+saveFileName);
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      //dto 에 업로드된 파일의 정보를 담는다.
	      vo.setOrgFileName(orgFileName);
	      vo.setSaveFileName(saveFileName);
	      vo.setFileSize(fileSize);
	      
	      dao.insertGood(vo);
	      //view 페이지에서 사용할 모델 담기 
	      //mView.addObject("fileVO", vo);
	}

//	@Override
//	public List<BoardVO> listBoard(int menuNum) {
//		List<BoardVO> list = dao.listBoard(menuNum);
//		return list;
//	}
	
	@Override
	public List<BoardVO> listBoard(int menuNum, String realPath) {
		List<BoardVO> list = dao.listBoard(menuNum, realPath);
		System.out.println("menuNum = " + menuNum);
//		Map<Integer, Object> boardMap = new HashMap<Integer, Object>();
//		for(int i = 0; i<list.size(); i++) {
//			boardMap.put(i, list.get(i));
//		}
//		System.out.println(boardMap);
		return list;
	}

	@Override
	public List<BoardVO> listBoardFilter(int category, int category2) {
		List<BoardVO> list = dao.listBoardFilter(category, category2);
		
		return list;
	}
	
	@Override
	public BoardVO showGood(int goodsId) {
		BoardVO vo = dao.showGood(goodsId);
		return vo;
	}
	
}
