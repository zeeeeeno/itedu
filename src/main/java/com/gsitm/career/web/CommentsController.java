package com.gsitm.career.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsitm.career.dto.CommentsDTO;
import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.service.CommentsService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	private HttpSession session;

	@PostMapping("/register/{lecutreNo}")
	public String registerComments(@PathVariable("lecutreNo") String lecutreNo, @ModelAttribute(name = "commentsDTO") CommentsDTO commentsDTO, HttpServletRequest request) throws Exception {
		log.info("CommentsController - registerComments() lecutreNo: " + lecutreNo + ", commentsDTO: " + commentsDTO);

		session = (HttpSession) request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("member");
		String email = member.getMemberEmail();
		String contents = commentsDTO.getCommentsContents();

		commentsService.regiser(contents, email, lecutreNo);

		String redirect = "redirect:/lecture/detail/" + lecutreNo ;
		return redirect;
	}
}
