/*
 * Notice Controller
 * - Create
 * - Read
 * - Update
 * - Delete
 */
package com.gsitm.career.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsitm.career.dto.NoticeDTO;
import com.gsitm.career.dto.Page;
import com.gsitm.career.service.NoticeService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	/*
	 * 공지사항 출력
	 */
	@GetMapping("/list")
	public String notice(Model model, HttpServletRequest request) throws Exception {
		log.info("NoticeController - notice()");

		int num = Integer.parseInt(request.getParameter("num"));

		Page page = new Page();
		page.setNum(num);
		int noticeSize = noticeService.noticeCount();
		log.info("noticeSize: " + noticeSize);
		page.setCount(noticeSize);

		ArrayList<NoticeDTO> arrayList = noticeService.noticeList(page.getDisplayPost(), page.getPostNum());
		model.addAttribute("notice", arrayList);
		model.addAttribute("select", num);
		model.addAttribute("page", page);
		model.addAttribute("noticeSize", noticeSize);

		return "notice/noticeList";
	}

	/*
	 * 공지사항 작성 페이지로 이동
	 */
	@GetMapping("/create")
	public String noticeCreate(Model model) {
		log.info("NoticeController - noticeCreate()");

		return "notice/noticeCreate";
	}

	/*
	 * 공지사항 입력
	 */
	@PostMapping("/insert")
	public String noticeinsert(@ModelAttribute(name = "noticeDTO") NoticeDTO noticeDTO, HttpServletRequest request) throws Exception {
		log.info("NoticeController - noticeinsert() noticeDTO: " + noticeDTO);

		noticeService.savePost(noticeDTO);

		return "notice/noticeList";
	}

	/*
	 * 공지사항 상세 내용 출력
	 */
	@GetMapping("/detail/{noticeNo}")
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) throws Exception {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);

		noticeService.countViews(noticeNo);

		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeDetail";
	}

	/*
	 * 공자사항 수정 페이지 이동
	 */
	@GetMapping("/update/{noticeNo}")
	public String noticeUpdate(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) throws Exception {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);

		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeModify";
	}

	/*
	 * 공지사항 수정
	 */
	@PostMapping("/update/{noticeNo}")
	public String noticeModify(@PathVariable("noticeNo") Long noticeNo, @ModelAttribute(name = "modifyDTO") NoticeDTO modifyDTO, HttpServletRequest request) throws Exception {
		log.info("NoticeController - noticeinsert() noticeDTO: " + modifyDTO);

		noticeService.updateNotice(noticeNo, modifyDTO.getNoticeTitle(), modifyDTO.getNoticeContents());

		String redirect = "redirect:/notice/detail/" + noticeNo;

		return redirect;
	}

	@GetMapping("/delete/{noticeNo}")
	public String noticeDelete(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request) throws Exception {
		log.info("NoticeController - noticeDelete() noticeNo: " + noticeNo);

		noticeService.deleteNotice(noticeNo);

		String redirect = "redirect:/notice/";
		return redirect;
	}

	@GetMapping("/search")
	public String noticeSearch(HttpServletRequest request, Model model) throws Exception {
		log.info("NoticeController - noticeSearch()");

		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");


		if (category.equals("제목")) {
			category = "notice_title";
		} else if (category.equals("날짜")) {
			category = "create_time";
		}

		log.info("category: " + category + ", keyword: " + keyword);

		ArrayList<NoticeDTO> noticeList = noticeService.noticeSearch(category, keyword);
		log.info("noticeList.toString(): " + noticeList.toString());

		model.addAttribute("noticeList", noticeList);

		return "notice/noticeSearch";
	}
}
