package com.service.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Member;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("login.do")
	public String doLogin(Member pvo, HttpSession session, Model model){
		String path = "Error";
		
		try {
			Member rvo = memberService.selectUser(pvo);
			if(rvo!=null) { // 로그인 성공했다면
				session.setAttribute("mvo", rvo);
				path = "member/login_result";
			}
			return path;
		} catch (Exception e) {
			model.addAttribute("message", "로그인작업 - 에러발생");
			return path;
		}
	}
	
	//로그아웃
	@RequestMapping("logout.do")
	public String doLogout(HttpSession session) {
		Member mvo = (Member) session.getAttribute("mvo");
		if(mvo!=null) session.invalidate();
		
		return "redirect:index.jsp";
	}
	
}
