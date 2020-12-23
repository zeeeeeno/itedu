/*
 * Main Controller
 * - 로그인
 * - 로그아웃
 * - 화면 전환
 */
package com.gsitm.career.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {

	@RequestMapping("/")
	public ModelAndView main(ModelAndView modelAndView) {
		log.info("MainController - main()");
		modelAndView.setViewName("index");

		return modelAndView;
	}

	/*
	 * 회원가입 페이지 이동
	 */
	@RequestMapping("/login/signIn")
	public ModelAndView login(ModelAndView modelAndView) {
		log.info("MainController - login()");
		modelAndView.setViewName("login/signIn");

		return modelAndView;
	}

	/*
	 * 로그아웃
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session) {
		log.info("MemberController - memberLogout()");
		session.setAttribute("member", null);
		session.setAttribute("academy", null);

		return "redirect:/";
	}
}
