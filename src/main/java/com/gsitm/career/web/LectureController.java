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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.service.LectureService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	LectureService lectureService;

	/*
	 * 강의 업로드 페이지 이동
	 */
	@RequestMapping("/upload")
	public String lectureUpload() {
		log.info("LectureController - lectureUpload()");
		return "lecture/upload";
	}

	/*
	 * 강의 업로등 - 구현 중
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String lectureInsert(@ModelAttribute(name = "lectureDTO") LectureDTO lectureDTO, @RequestParam("lectureThumbnail") MultipartFile files, HttpServletRequest request) {
		log.info("LectureController - lectureInsert()");

		try {
            String origFilename = files.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
            /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
            String savePath = System.getProperty("user.dir") + "\\files";
            /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
            if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }
            log.info("filename: " + filename);

            String filePath = savePath + "\\" + filename;
            files.transferTo(new File(filePath));

			HttpSession session = (HttpSession) request.getSession();
			AcademyDTO academyDTO = (AcademyDTO) session.getAttribute("academy");
			String email = academyDTO.getAcademy_email();

			lectureDTO.setLectureThumbnail(filename);

			lectureService.insertLecture(lectureDTO, email);

		} catch(Exception e) {
            e.printStackTrace();
        }
		return "redirect:/";
	}

	/*
	 * 강의 리스트 출력
	 */
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
