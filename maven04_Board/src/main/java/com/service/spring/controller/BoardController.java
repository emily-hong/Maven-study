package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write(Board bvo, HttpSession session, Model model) {
		//세션에서 mvo 정보를 받아와서 자동바인딩 되는 Board bvo에 set으로 넣음, write(bvo)
		Member mvo = (Member) session.getAttribute("mvo");

		if(mvo==null) return "redirect:index.jsp"; // 로그인 안된상태라면..
		try {
			bvo.setMember(mvo);
			model.addAttribute("bvo", bvo);
			boardService.write(bvo); // 인자값으로 들어온 위의 bvo 와는 다르다!!
			return "board/show_content";
		}catch (Exception e) {
			model.addAttribute("message","Spring Board 게시글 작성 - 에러발생");
			return "Error";
		}
	}
	
	@RequestMapping("list.do")
	public String list(HttpSession session, Model model) {
		try {
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list", list);
			return "board/list"; //InternalResourceViewResolver의 영향을 받는다.
		} catch (Exception e) {
			model.addAttribute("message","Spring Board - 게시글 검색중 에러발생");
			return "Error";
		}
	}
	
	@RequestMapping("showContent.do")
	public String showDetail(int no, HttpSession session, Model model) {
		Member mvo = (Member) session.getAttribute("mvo");
		// 로그인한 사람만 게시글을 볼수있음
		if(mvo==null) return "redirect:index.jsp"; // 로그인 안된상태라면..
		
		try {
			// 조회수 증가
			boardService.updateCount(no); // 상세글 보려할때 카운트 하나 올려놓고
			
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			return "board/show_content"; //InternalResourceViewResolver의 영향을 받는다.
		} catch (Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 상세보기 중 에러발생");
			return "Error";
		}
	}
	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model) { //함수명에 do는 행위. -> login() 해당 메소드를 실행하면 로그인을 할 수 있는 폼이 나온다. /doLogin() 해당 메소드에서 직접 로그인 기능이 나온다.  
		/*
		try {
			boardService.deleteBoard(no);
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list", list); //forwarding
			return "board/list";
		}catch (Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 삭제 중 에러발생");
			return "Error";
		}
		*/
		try {
			boardService.deleteBoard(no);
			return "redirect:list.do";
		}catch (Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 삭제 중 에러발생");
			return "Error.jsp";
		}

	}
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model) { // 수정은 폼을 거치기 때문에 do를 붙이지 않았음
		// update.jsp 가 결과 페이지.. 여기서 수정을 하는 곳
		try {
			// 여기서는 진짜 수정이 진행되는 것이 아니라.. service.updateBoard()가 호출되는 것이 아니라
			// 폼안에 bvo값이 들어간 상태에서 그 값을 부분 수정하는 것.. no에 해당하는 bvo값을 받아올려면?
			// bvo값을 바인딩 한 상태에서 update.jsp 결과 페이지로 연결되어야 한다.
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo",bvo);
			return "board/update";
		}catch (Exception e) {
			model.addAttribute("message", "Spring Board - 게시글  수정 중 에러발생");
			return "Error";
		}
	}
	
	@RequestMapping("updateBoard.do")
	public String doUpdate(Board pvo, Model model) { // 수정후 show_content로 
		try {
			boardService.updateBoard(pvo); // 실질적으로 수정이 진행
			Board board = boardService.showContent(pvo.getNo());
			model.addAttribute("bvo", board);
			return "board/show_content";
		} catch (Exception e) {
			model.addAttribute("message", "Spring Board - 게시글 수정 중 에러발생");
			return "Error.jsp";
		}
	}
	
}
