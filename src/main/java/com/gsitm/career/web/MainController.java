/*
 * Main Controller
 * - 로그인
 * - 로그아웃
 * - 화면 전환
 */
package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.service.AcademyService;
import com.gsitm.career.service.LectureService;
import com.gsitm.career.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
public class MainController {

	@Autowired
	AcademyService academyService;

	@Autowired
	LectureService lectureService;

	@Autowired
	MemberService memberSerivce;

	@GetMapping("/")
	public ModelAndView main(ModelAndView modelAndView) throws Exception {
		log.info("MainController - main()");
		modelAndView.setViewName("index");

		return modelAndView;
	}

	/*
	 * 회원가입 페이지 이동
	 */
	@GetMapping("/login/signIn")
	public ModelAndView login(ModelAndView modelAndView) throws Exception {
		log.info("MainController - login()");
		modelAndView.setViewName("login/signIn");

		return modelAndView;
	}

	/*
	 * 로그아웃
	 */
	@GetMapping("/logout")
	public String memberLogout(HttpSession session) throws Exception {
		log.info("MainController - memberLogout()");
		session.setAttribute("member", null);
		session.setAttribute("academy", null);

		return "redirect:/";
	}

	/*
	 * 로그아웃
	 */
	@GetMapping("/admin")
	public ModelAndView admin(HttpSession session) throws Exception {
		log.info("MainController - admin()");

		ModelAndView modelAndView = new ModelAndView();

		ArrayList<AcademyDTO> academyList = academyService.academyList();
		ArrayList<LectureDTO> lectureList = lectureService.lectureListAll();
		ArrayList<MemberDTO> memberList = memberSerivce.selectUser();

		modelAndView.addObject("academyList", academyList);
		modelAndView.addObject("lectureList", lectureList);
		modelAndView.addObject("memberList", memberList);

		modelAndView.setViewName("admin/admin");

		return modelAndView;
	}
}
