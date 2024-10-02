package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.vo.User;

@Controller
public class FormController {
	// 자동바인딩
	/* @PostMapping("/form.do") */ // 버전이 4이상이어야함
	@RequestMapping("/form.do")
	public ModelAndView form(User user) { //  html의 폼의 값이 자동으로 컨트롤러에 바인딩... 폼의 이름과 일치되어야함
		/*
		 * 1. 폼값 받아서
		 * 	  String name = request.getParameter("userName")
		 * 	  String addr = request.getParameter("userAddr")
		 * 	  String id = request.getParameter("id")
		 * 2. pvo 생성
		 * 	  User pvo = new User();
		 * 	  pvo.set() 으로 주입이 일어난다. (기본생성자도 있어야함)
		 */
		
		return new ModelAndView("result", "info", user);
	}
}
