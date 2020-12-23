/*
 * Member Controller
 * - 회원가입
 */
package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	/*
	 * 회원 로그인
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLogin(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request) {
		log.info("MemberController - memberLogin() memberDTO: " + memberDTO.getMember_email());

		String memberEmail = memberDTO.getMember_email();
		Boolean isLogin = memberService.login(memberDTO);
		System.out.println("memberEmail: " + memberEmail);

		if (isLogin) {
			log.info("로그인 성공");

			ArrayList<MemberDTO> member = memberService.getMemberInfo(memberEmail);
			System.out.println("member: " + member);

			HttpSession session = (HttpSession) request.getSession();
			session.setAttribute("member", member);
			System.out.println("session.getAttribute(\"member\") - " + session.getAttribute("member"));

			return "redirect:/";
		} else {
			return "redirect:/login/signIn";
		}
	}

	/*
	 * 회원가입
	 */
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String memberSignUp(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request) {
		log.info("MemberController - memberSignUp() memberDTO: " + memberDTO.getMember_email());
		memberService.memberInsert(memberDTO);

		return "forward:/login/signIn";
	}

	/*
	 * member list for test
	 */
	@RequestMapping(value = "select", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MemberDTO>> selectUser() {
		log.info("MemberController - selectUser()");
		return ResponseEntity.ok(memberService.selectUser());
	}
}
