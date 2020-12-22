package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.dto.NoticeDTO;
import com.gsitm.career.service.LectureService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	LectureService lectureService;

	@RequestMapping("/upload")
	public String lectureUpload() {
		log.info("LectureController - lectureUpload()");
		return "lecture/upload";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String lectureInsert(@ModelAttribute(name = "lectureDTO") LectureDTO lectureDTO, HttpServletRequest request) {
		log.info("LectureController - lectureInsert()");
		HttpSession session = (HttpSession) request.getSession();
		AcademyDTO academyDTO = (AcademyDTO) session.getAttribute("academy");
		String email = academyDTO.getAcademy_email();

		lectureService.insertLecture(lectureDTO, email);
		return "lecture/upload";
	}


	@RequestMapping(value = {"/{category1}"}, method = RequestMethod.GET)
	public String lecture(@PathVariable("category1") String category1, HttpServletRequest request, Model model) {
		log.info("LectureController - lecture()");
		ArrayList<LectureDTO> lectureList =  lectureService.lectureList(category1);

		String path = request.getSession().getServletContext().getRealPath("");// 절대경로
		log.info("path: " + path);

		model.addAttribute("lecture", lectureList);

		return "lecture/programming/programming";
	}
}
