package com.service.spring;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Book;
import com.service.spring.domain.User;

public class MyBatisJUnitTest {

	@Test
	public void user() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
//		User pvo1 = new User();
//		pvo1.setUserId("kosta");
//		pvo1.setPassword("1234");		
//		// getUser
//		User userinfo = session.selectOne("ns.sql.UserMapper.getUser", pvo1);
//		
//		System.out.println("-------------------------------");
//		
//		User pvo2 = new User();
//		pvo2.setUserId("admin");
//		System.out.println((User)session.selectOne("ns.sql.UserMapper.getUser", pvo2));
//		
//		System.out.println("-------------------------------");
//		User pvo3= new User();
//		pvo3.setUserId("hahash");
//		pvo3.setPassword("7777");
//		pvo3.setName("공지영");
//		pvo3.setEmail("kong@google.com");
//		System.out.println(session.insert("ns.sql.UserMapper.addUser", pvo3));
	}
	
	@Test
	public void book() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
//		List<Book> list = new ArrayList<Book>();
		// searchByPrice
		List<Book> list1 = session.selectList("ns.sql.BookMapper.searchByPrice", 1000);
		for(Book b : list1) System.out.println(b);
		
		// update
//		Book pvo = new Book();
//		pvo.setIsbn("1000-123-456");
//		pvo.setTitle("책1004");
//		pvo.setAuthor("수정");
//		pvo.setDescription("수정");
//		session.update("ns.sql.BookMapper.update", pvo);
//		session.commit();
		
		// getbooks
//		List<Book> list2 = session.selectList("ns.sql.BookMapper.getBooks");
//		for(Book b: list2) System.out.println(b);
		
//		Book pvo = new Book();
//		pvo.setIsbn("5465-333-000");
//		pvo.setTitle("도서22");
//		pvo.setCatalogue("프로그래밍");
//		pvo.setNation("국내");
//		pvo.setPublishDate("2024-01-11");
//		pvo.setPublisher("영진출판사");
//		pvo.setAuthor("저자11");
//		pvo.setPrice(10000);
//		pvo.setCurrency("원");
//		pvo.setDescription("요약");
//		
//		session.insert("ns.sql.BookMapper.insertBook", pvo);
//		session.commit();
//		
	}
}
