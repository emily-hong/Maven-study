package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

public class MyBatisDITest {
	// myBatis와 DI연동 부분의 단위테스트.. 빈 설정문서를 읽어야 한다.
	ApplicationContext factory = 
			new ClassPathXmlApplicationContext("/beans/businessBean.xml");
	
	@Test
	public void addTest() throws Exception{
		// IOC로부터 MyProductDAO 객체를 반환
		BookService service = (BookService)factory.getBean("bookService");
		
		List<Book> list = service.searchByTitle("보안");
		for(Book b : list) System.out.println(b);
	}
	
	
}