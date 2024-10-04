package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.dao.MyProductDAO;
import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductCatalog;

@Controller
public class MyProductController {
	@Autowired
	private MyProductDAO myProductDAO;
	
	@Autowired
	private MyProductCatalog myProductCatalog;
	
	@RequestMapping("/insertProduct.do")
	public ModelAndView addProduct(MyProduct pvo) throws Exception {
		myProductCatalog.addProduct(pvo);
//		List<MyProduct> list = myProductCatalog.findProducts();
		
		// 결과페이지 이름은 insert_result.jsp 포워딩 / vo 이름으로 Request에 바인딩
		return new ModelAndView("insert_result", "pvo", pvo);
	}
	
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct(String command, String word) throws Exception {
		List<MyProduct> list = new ArrayList<MyProduct>();
		String viewPage = "find_result";
		
		if(command.equalsIgnoreCase("findProducts")) {
			list = myProductCatalog.findProducts();
		}else if(command.equalsIgnoreCase("findProductByName")) {
			list = myProductCatalog.findProductByName(word);			
		}else if(command.equalsIgnoreCase("findProductByMaker")) {
			list = myProductCatalog.findProductByMaker(word);			
		}
		
		return new ModelAndView(viewPage, "list", list);
	}
}
