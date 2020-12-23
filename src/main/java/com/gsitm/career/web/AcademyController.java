/*
 * Academy Controller
 * - 회원가입
 * - 로그인
 */
package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.service.AcademyService;

import lombok.extern.java.Log;

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
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String academySignUp(@ModelAttribute(name = "academyDTO") AcademyDTO academyDTO, HttpServletRequest request) {
		log.info("AcademyController - academySignUp() AcademyDTO: " + academyDTO.getAcademy_email());
		academyService.signUp(academyDTO);

		return "redirect:/login/signIn";
	}

	/*
	 * 학원 로그인
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String academyLogin(@ModelAttribute(name = "academyDTO") AcademyDTO academyDTO, HttpServletRequest request) {
		log.info("MemberController - academyLogin() academyDTO: " + academyDTO.getAcademy_email());
		String acadmyEmail = academyDTO.getAcademy_email();
		Boolean isLogin = academyService.login(academyDTO);

		if (isLogin) {
			log.info("로그인 성공");

			ArrayList<AcademyDTO> academy = academyService.getAcademyInfo(acadmyEmail);
			System.out.println("academy: " + academy);

			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("academy", academy);

			return "redirect:/";
		} else {
			return "redirect:/login/signIn";
		}
	}
}
