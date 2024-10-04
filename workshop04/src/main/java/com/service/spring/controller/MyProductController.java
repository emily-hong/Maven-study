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

	// TODO 확인 테스트 
	@RequestMapping("addProduct.do")
    public ModelAndView addProduct(MyProduct myProduct) throws Exception {
        myProductCatalog.addProduct(myProduct); // 등록
        
        List<MyProduct> productList = myProductCatalog.findProducts();
        
        return new ModelAndView("result", "productList", productList);
    }

	// 상품검색
	@RequestMapping("searchProduct.do")
	public ModelAndView searchProduct(String searchOption, String keyword) throws Exception{
		List<MyProduct> productList = null;
		
		if("name".equals(searchOption)) {
			productList = myProductCatalog.findProductByName(keyword);
		}else if("maker".equals(searchOption)) {
			productList = myProductCatalog.findProductByMaker(keyword);
		}else if("all".equals(searchOption)) {
			productList = myProductCatalog.findProducts();
		}
		
		return new ModelAndView("result", "productList", productList);
	}
}