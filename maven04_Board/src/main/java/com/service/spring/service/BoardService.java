package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO ;
	
	// int 
//	public void write(Board vo) {
//		boardDAO.write(vo);
//	}
	public int write(Board vo) {
		int row=boardDAO.write(vo);
		System.out.println("Before vo :: "+vo);
		
		String date=boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		
		System.out.println("After vo :: "+vo);
		return row;
	}
	// 게시물 목록
	public List<Board> getBoardList() {
		List<Board> list = boardDAO.getBoardList();
		return list;
	}
	// 게시물 상세
	public Board showContent(int no) {
		System.out.println("showContent service");
		Board board = boardDAO.showContent(no);
		return board;
	}

	public void deleteBoard(int no) {
		boardDAO.deleteBoard(no);
	}
	public void updateCount(int no) {
		boardDAO.updateCount(no);
	}
	public void updateBoard(Board vo) {
		boardDAO.updateBoard(vo);		
	}	
}
