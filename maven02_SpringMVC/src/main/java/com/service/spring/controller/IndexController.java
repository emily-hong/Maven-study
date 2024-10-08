package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Controller를 작성하는 방법
 * 1. Controller 인터페이스를 상속
 * 2. POJO로 만드는 방법 ---> @ Annotation으로 만든다 --> <bean> 이 부분이 생략됨
 */

@Controller
public class IndexController {
	// 인자값 필요하면 넣음
	// 리턴 타입 ModelAndView
	// index.do 요청이들어올때 동작함
	@RequestMapping("/index.do")
	public ModelAndView doIndex() {
		/*
		 * 1. 폼값 받아서
		 * 2. DAO 리턴받고 비지니스 로직 호출
		 * 3. (바인딩 --> 디폴트로 ServletRequest에 자동 바인딩)
		 * 4. (네비게이션 --> 디폴트로 forwarding)
		 */
		return new ModelAndView("result","info","Plain Old Java Object~~");
	}
}


