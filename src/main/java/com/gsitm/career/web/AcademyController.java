package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.service.AcademyService;

import lombok.extern.java.Log;

/*
 * Academy Controller
 * - 회원가입
 * - 로그인
 */
@Log
@Controller
@RequestMapping("/academy")
public class AcademyController {

	@Autowired
	AcademyService academyService;

	/*
	 * 학원 회원가입 페이지 이동
	 */
	@RequestMapping("/")
	public String academy() {
		log.info("AcademyController - academy()");

		return "academy/signUp";
	}

	/*
	 * 회원가입 수행 후 로그인 페이지 이동
	 */
	@PostMapping(value = "/signUp")
	public String academySignUp(@ModelAttribute(name = "academyDTO") AcademyDTO academyDTO, HttpServletRequest request) throws Exception {
		log.info("AcademyController - academySignUp() AcademyDTO: " + academyDTO.getAcademyEmail());
		academyService.signUp(academyDTO);

		return "redirect:/login/signIn";
	}

	/*
	 * 학원 로그인
	 */
	@PostMapping(value = "/login")
	public String academyLogin(@ModelAttribute(name = "academyDTO") AcademyDTO academyDTO, HttpServletRequest request) throws Exception {
		log.info("AcademyController - academyLogin() academyDTO: " + academyDTO.getAcademyEmail());
		String acadmyEmail = academyDTO.getAcademyEmail();
		Boolean isLogin = academyService.login(academyDTO);

		if (isLogin) {
			log.info("로그인 성공");

			AcademyDTO academy = academyService.getAcademyInfo(acadmyEmail);
			System.out.println("academy: " + academy);

			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("academy", academy);

			return "redirect:/";
		} else {
			return "redirect:/login/signIn";
		}
	}

	/*
	 * 학원 로그인
	 */
	@PostMapping("/approve/{academyEmail}")
	public String academyApprove(@PathVariable("academyEmail") String academyEmail, HttpServletRequest request) throws Exception {
		log.info("AcademyController - academyApprove() academyEmail: " + academyEmail);

		academyService.academyApprove(academyEmail);

		return "redirect:/admin";
	}
}
