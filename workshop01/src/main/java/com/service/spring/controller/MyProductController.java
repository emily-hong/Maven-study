package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductCatalog;

@Controller
public class MyProductController {
	@Autowired
	private MyProductCatalog myProductCatalog;
	
	
	@RequestMapping("result.do")
	public ModelAndView myProductList() throws Exception{
		List<MyProduct> list = myProductCatalog.findProducts();
		return new ModelAndView("result", "list", list);
	}
}
