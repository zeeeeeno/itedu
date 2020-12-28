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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/login")
	public String memberLogin(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		log.info("MemberController - memberLogin() memberDTO: " + memberDTO.getMemberEmail());

		String memberEmail = memberDTO.getMemberEmail();
		Boolean isLogin = memberService.login(memberDTO);

		if (isLogin) {
			MemberDTO member = memberService.getMemberInfo(memberEmail);
			HttpSession session = (HttpSession) request.getSession();

			session.setAttribute("member", member);

			return "redirect:/";
		} else {
			return "redirect:/login/signIn";
		}
	}

	/*
	 * 회원가입
	 */
	@PostMapping("/signUp")
	public String memberSignUp(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		log.info("MemberController - memberSignUp() memberDTO: " + memberDTO.getMemberEmail());
		memberService.memberInsert(memberDTO);

		return "redirect:/login/signIn";
	}

	/*
	 * member list for test
	 */
	@GetMapping("select")
	public ResponseEntity<ArrayList<MemberDTO>> selectUser() throws Exception {
		log.info("MemberController - selectUser()");
		return ResponseEntity.ok(memberService.selectUser());
	}
}
