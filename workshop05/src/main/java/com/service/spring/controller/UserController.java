package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("memberLogin.do")
	public ModelAndView login(User user, HttpServletRequest request) throws Exception{
		// form에서 값받은 객체
		System.out.println("getUser Before : " + user); // name, email값은 null
		User rvo = userService.getUser(user);
		System.out.println("getUser After : " + rvo); // 값이 꽉찬 rvo
		
		String path = "index.jsp";
		String msg = "아이디 혹은 패스워드가 틀렸습니다.";
		
		if(rvo != null) { // 로그인 성공했다면.. 세션에 바인딩
			request.getSession().setAttribute("user", rvo); // request해서 받아온 정보를 사용
			msg = "성공적으로 로그인 됐습니다.";
		}
		request.setAttribute("msg", msg); // 로그인 성공 여부에 따라서 저장되는 msg가 달라진다.
		// 리다이렉트
		return new ModelAndView("redirect:" + path); //응답을하고 이 페이지로 다시 요청이 들어가게됨
	}
	
	@RequestMapping("memberLogout.do")
	public ModelAndView logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return new ModelAndView("redirect:index.jsp");
	}
}















