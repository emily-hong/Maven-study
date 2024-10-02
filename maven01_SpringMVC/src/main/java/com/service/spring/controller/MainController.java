package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * ModelAndView API 클래스
 * ::
 * 결과페이지 이름과 페이지 이동방식에 대한 정보를 담고 있는 클래스
 * 데이터를 저장할 수 있다. (Map방식으로 )
 * 결과 페이지의 이동방식을 지정하지않으면 디폴트 이동방식은 Forwarding
 * 데이타를 기본적으로 HttpServletRequest에 바인딩한다.
 */
public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값 받아서 
		 * 2. DAO 리턴받고 비즈니스 로직 호출
		 * 3. 데이터 바인딩
		 * 4. 네비게이션
		 ... 1~4까지 했다치고..
		 */
		// message 라는 이름으로 데이터를 ServletRequest에 바인딩하고
		// result.jsp 결과페이지로 포워딩한다.
		return new ModelAndView("result.jsp", "message", "Hello Spring MVC~!!");
	}

}
