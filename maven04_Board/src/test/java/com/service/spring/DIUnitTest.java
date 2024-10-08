package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

public class DIUnitTest {
	// myBatis와 DI연동 부분의 단위테스트.. bean 설정문서를 읽어야 한다.
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/application.xml");
	
	BoardService service = (BoardService) factory.getBean("boardService");

	@Test
	public void write() throws Exception{
		// 테스트 유저 조회
		Member member = new Member("kosta1", "1234", "1234", "1234");

		Board pvo = new Board();
		pvo.setTitle("제목5");
		pvo.setContent("게시물 내용5");
		pvo.setMember(member);
	
		service.write(pvo);	
	}
	
	@Test
	public void getBoardList() throws Exception{
		List<Board> list = service.getBoardList();
		for(Board b : list) System.out.println(b);
	}
	
	@Test
	public void showContent() throws Exception{
		Board pvo = service.showContent(4);
		System.out.println("showContent " + pvo );
	}
	
}