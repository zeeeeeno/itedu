/*
 * Lecture Controller
 * - 강의 등록
 * - 강의 리스트 출력
 */
package com.gsitm.career.web;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.dto.CommentsDTO;
import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.service.ClassesService;
import com.gsitm.career.service.CommentsService;
import com.gsitm.career.service.LectureService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	LectureService lectureService;

	@Autowired
	CommentsService commentsService;

	@Autowired
	ClassesService classesService;

	private HttpSession session;
	private String errorMsg = "";

	/*
	 * 강의 업로드 페이지 이동
	 */
	@GetMapping("/upload")
	public String lectureUpload() {
		log.info("LectureController - lectureUpload()");
		return "lecture/upload";
	}

	/*
	 * 강의 업로등 - 구현 중
	 */
	@PostMapping("/insert")
	public String lectureInsert(@RequestParam("lectureDTO") MultipartFile files, HttpServletRequest request) throws Exception {
		log.info("LectureController - lectureInsert()");
		session = (HttpSession) request.getSession();

		session = request.getSession();
		AcademyDTO academyDTO = (AcademyDTO) session.getAttribute("academy");
		String academyEmail = academyDTO.getAcademyEmail();
		LectureDTO lectureDTO = new LectureDTO();

		int num = lectureService.lectureCount();
        File destinationFile;
        String destinationFileName;
        String fileName = "lecture" + num +".PNG";
        String fileUrl = "C:\\fileUpload\\images"+fileName;

        String lectureStartDate = request.getParameter("lectureStartDate");
        String lectureEndDate = request.getParameter("lectureEndDate");
        String period = lectureStartDate + " ~ " + lectureEndDate;

        lectureDTO.setLectureName(request.getParameter("lectureName"));
        lectureDTO.setLectureTeacher(request.getParameter("lectureTeacher"));
        lectureDTO.setLecturePeriod(period);
        lectureDTO.setLecturePrice(request.getParameter("lecturePrice"));
        lectureDTO.setLectureCategoryMainCategory(request.getParameter("lectureCategory1"));
        lectureDTO.setLectureCategorySubCategory(request.getParameter("lectureCategory2"));
        lectureDTO.setLectureThumbnail(fileName);
        lectureDTO.setLectureContents(request.getParameter("lectureContents"));
        lectureDTO.setLectureAcaedmy(academyEmail);

        do {
            destinationFileName =".PNG" ;
            destinationFile = new File(fileUrl + destinationFileName);
        } while (destinationFile.exists());

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        lectureService.insertLecture(lectureDTO);

		return "redirect:/";
	}

	/*
	 * 강의 리스트 출력
	 */
	@GetMapping("/{category1}")
	public String lecture(@PathVariable(value = "category1", required = true) String category1, HttpServletRequest request, Model model) throws Exception {
		log.info("LectureController - lecture() category1: " + category1);
		ArrayList<LectureDTO> lectureList = null;

		lectureList =  lectureService.lectureList(category1);

		model.addAttribute("lecture", lectureList);
		model.addAttribute("category1", category1);

		String redirect ="lecture/" + category1;

		return redirect;
	}

	/*
	 * 강의 리스트 출력
	 */
	@GetMapping("/{category1}/{category2}")
	public String lectureList(@PathVariable(value = "category1", required = true) String category1, @PathVariable(value = "category2", required = true) String category2, HttpServletRequest request, Model model) throws Exception {
		log.info("LectureController - lecture() category1: " + category1 + ", category2: " + category2);
		ArrayList<LectureDTO> lectureList = null;

		lectureList =  lectureService.lectureListDetail(category1, category2);

		model.addAttribute("lecture", lectureList);
		model.addAttribute("category1", category1);
		model.addAttribute("category2", category2);

		String redirect ="lecture/" + category1 + "/" + category1 + "Category";

		return redirect;
	}


	@SuppressWarnings("finally")
	@GetMapping("/detail/{lectureNo}")
	public String lectureDetail(@PathVariable("lectureNo") String lectureNo, HttpServletRequest request, Model model) throws Exception {
		log.info("LectureController - lecture() category1: " + lectureNo);
		session = (HttpSession) request.getSession();

		String lecNo = lectureNo;
		LectureDTO lecture = null;
		ArrayList<CommentsDTO> commentList = null;
		MemberDTO member = null;
		Boolean isClassListen = false;

		lecture =  lectureService.lectureDetail(lectureNo);
		commentList = commentsService.list(lecNo);

		try {
			member = (MemberDTO) session.getAttribute("member");
			String memberEmail = member.getMemberEmail();

			isClassListen = classesService.isListenLecture(lecNo, memberEmail);

		} catch (NullPointerException e) {
			model.addAttribute("error", errorMsg);
			log.info("lectureDetail: " + member.toString());

		} finally {
			model.addAttribute("lecture", lecture);
			model.addAttribute("commentList", commentList);
			model.addAttribute("isClassListen", isClassListen);
			this.errorMsg = "";

			String redirect = "lecture/detail";

			return redirect;
		}
	}

	@SuppressWarnings("finally")
	@PostMapping("apply/{lectureNo}")
	public String lectureApply(@PathVariable("lectureNo") String lectureNo, HttpServletRequest request, Model model) {
		log.info("lectureApply() lectureNo: " + lectureNo);

		session = (HttpSession) request.getSession();
		MemberDTO member = null;
		String memberEmail = null;
		String redirect = "redirect:/lecture/detail/" + lectureNo;

		try {
			member = (MemberDTO) session.getAttribute("member");
			memberEmail = member.getMemberEmail();

			classesService.apply(lectureNo, memberEmail);
		} catch (NullPointerException e) {
			this.errorMsg = "로그인을 해야합니다.";
			log.info("lectureApply: " + member.toString());

			return redirect;
		} finally {
			return redirect;
		}
	}
}
