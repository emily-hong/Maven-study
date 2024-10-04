package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		
		System.out.println("list ====> " + list);
		
		return new ModelAndView("book/bookList","list",list);
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView register(Book book, String isbn1, String isbn2, String isbn3)throws Exception{
		System.out.println("register BookVO before:: "+book);//?
		
		String msg = "";
		String path = "Error.jsp";
		
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		
		System.out.println("isbn : " + isbn);
		List<Book> list=bookService.getBooks();
		
		try {
			Book rvo = new Book();
			rvo.setIsbn(isbn);
			rvo.setTitle(book.getTitle());
			rvo.setCatalogue(book.getCatalogue());
			rvo.setNation(book.getNation());
			rvo.setPublishDate(book.getPublishDate());
			rvo.setPublisher(book.getPublisher());
			rvo.setAuthor(book.getAuthor());
			rvo.setPrice(book.getPrice());
			rvo.setCurrency(book.getCurrency());
			rvo.setDescription(book.getDescription());
			
			bookService.insertBook(rvo);
			
			path="book/bookList";
			
		}catch(Exception e) {
			msg="책등록에 실패했습니다.";
		}
	
		return new ModelAndView(path, "list", list);
	}
	
	@RequestMapping("bookSearch.do")
    public ModelAndView search(String searchField, String searchText) throws Exception{ 
		
		List<Book> list = null;
		String path = "find_fail";
		
		try {
			if(searchField.equalsIgnoreCase("LIST")) {
				list = bookService.getBooks();
			}else if(searchField.equalsIgnoreCase("TITLE")) {
				list = bookService.searchByTitle(searchText);
			}else if(searchField.equalsIgnoreCase("PUBLISHER")) {
				list = bookService.searchByPublisher(searchText);
			}else if(searchField.equalsIgnoreCase("PRICE")) {
				list = bookService.searchByPrice(searchText);
			}
			path = "book/bookList";
		}catch(Exception e) {
			
		}
		return new ModelAndView(path);
	}
	@RequestMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
		
		Book book = new Book();
		System.out.println("bookView.do : " + isbn);
		
		try {
			book = bookService.getIsbn(isbn);
		}catch(Exception e) {
			
		}
		return new ModelAndView("book/bookView", "book", book);
	}	
	

}//





