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
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView memberLogin(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		log.info("MemberController - memberLogin() memberDTO: " + memberDTO.getMemberEmail());

		String memberEmail = memberDTO.getMemberEmail();

		String errorMsg = null;

		if (memberDTO.getMemberEmail() == "" || memberDTO.getMemberPasswd() == "") {
			errorMsg = "빈칸이 존재 합니다.";
			modelAndView.addObject("errorMsg", errorMsg);
			modelAndView.setViewName("/login/signIn");

			return modelAndView;
		}

		Boolean isLogin = memberService.login(memberDTO);

		if (isLogin) {
			MemberDTO member = memberService.getMemberInfo(memberEmail);
			HttpSession session = (HttpSession) request.getSession();

			session.setAttribute("member", member);
			modelAndView.setViewName("index");

			return modelAndView;
		} else {
			errorMsg = "아이디와 비밀번호가 일치하지 않습니다.";
			modelAndView.addObject("errorMsg", errorMsg);
			modelAndView.setViewName("/login/signIn");

			return modelAndView;
		}
	}

	/*
	 * 회원가입
	 */
	@PostMapping("/signUp")
	public ModelAndView memberSignUp(@ModelAttribute(name = "memberDTO") MemberDTO memberDTO, HttpServletRequest request, ModelAndView modelAndView) throws Exception {
		log.info("MemberController - memberSignUp() memberDTO: " + memberDTO.getMemberEmail());

		String errorMsg = null;
		modelAndView.setViewName("login/signIn");

		if (memberDTO.getMemberPostNo() == "") {
			errorMsg = "빈칸이 존재 합니다.";
			modelAndView.addObject("errorMsg", errorMsg);

			return modelAndView;
		}

		String patternEmail = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		if (!java.util.regex.Pattern.matches(patternEmail, memberDTO.getMemberEmail())) {
			errorMsg = "Email 형식이 다릅니다.";
			modelAndView.addObject("errorMsg", errorMsg);

			return modelAndView;
		}

		// 영문, 숫자 (10~20 자리)
		String patternPW = "^[A-Za-z[0-9]]{10,20}$";
		if (!java.util.regex.Pattern.matches(patternPW, memberDTO.getMemberPasswd())) {
			errorMsg = "비밀번호는 영문, 숫자 (10~20 자리)이어야 합니다.";
			modelAndView.addObject("errorMsg", errorMsg);

			return modelAndView;
		}

		// 비밀번호가 비밀번호 재확인과 다를 경우
		if (!memberDTO.getMemberPasswd().equals(memberDTO.getMemberPasswdCheck())) {
			errorMsg = "입력하신 비밀번호가 다릅니다.";
			modelAndView.addObject("errorMsg", errorMsg);

			return modelAndView;
		}

		memberService.memberInsert(memberDTO);

		modelAndView.addObject("errorMsg", errorMsg);

		return modelAndView;
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
