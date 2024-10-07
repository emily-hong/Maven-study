package com.service.spring;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;

public class MyBatisJUnitTest {
	@Test
	public void board() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		// 테스트 유저 조회
		Member member = new Member("kosta1", "1234", "1234", "1234");

		Board pvo1 = new Board();
		
		// write
		pvo1.setTitle("제목2");
		pvo1.setContent("게시물 내용2");
		pvo1.setMember(member);
		session.insert("ns.sql.Board.write", pvo1);
		session.commit();
		
		// getBoard
		List<Board> list1 = session.selectList("ns.sql.Board.getBoardList");
		for(Board b : list1) System.out.println(b);

		// showContent
		Board pvo2 = session.selectOne("ns.sql.Board.showContent", 2);
		System.out.println("showContent : " + pvo2);
		
	}
	
}
