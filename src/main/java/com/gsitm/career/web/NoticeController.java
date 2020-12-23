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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsitm.career.dto.NoticeDTO;
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
	@RequestMapping("/")
	public String notice(Model model) {
		log.info("NoticeController - notice()");

		ArrayList<NoticeDTO> arrayList = noticeService.noticeList();
		model.addAttribute("notice", arrayList);

		return "notice/noticeList";
	}

	/*
	 * 공지사항 작성 페이지로 이동
	 */
	@RequestMapping("/create")
	public String noticeCreate(Model model) {
		log.info("NoticeController - noticeCreate()");

		return "notice/noticeCreate";
	}

	/*
	 * 공지사항 입력
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String noticeinsert(@ModelAttribute(name = "noticeDTO") NoticeDTO noticeDTO, HttpServletRequest request) {
		log.info("NoticeController - noticeinsert() noticeDTO: " + noticeDTO);

		noticeService.savePost(noticeDTO);

		return "notice/noticeList";
	}

	/*
	 * 공지사항 상세 내용 출력
	 */
	@RequestMapping(value = "/detail/{noticeNo}", method = RequestMethod.GET)
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);

		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeDetail";
	}

	/*
	 * 공자사항 수정 페이지 이동
	 */
	@RequestMapping(value = "/update/{noticeNo}", method = RequestMethod.GET)
	public String noticeUpdate(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);

		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeModify";
	}

	/*
	 * 공지사항 수정
	 */
	@RequestMapping(value = "/update/{noticeNo}", method = RequestMethod.POST)
	public String noticeModify(@PathVariable("noticeNo") Long noticeNo, @ModelAttribute(name = "modifyDTO") NoticeDTO modifyDTO, HttpServletRequest request) {
		log.info("NoticeController - noticeinsert() noticeDTO: " + modifyDTO);

		noticeService.updateNotice(noticeNo, modifyDTO.getNoticeTitle(), modifyDTO.getNoticeContents());

		String redirect = "redirect:/notice/detail/" + noticeNo;

		return redirect;
	}

	@RequestMapping(value = "/delete/{noticeNo}", method = RequestMethod.GET)
	public String noticeDelete(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request) {
		log.info("NoticeController - noticeDelete() noticeNo: " + noticeNo);

		noticeService.deleteNotice(noticeNo);

		String redirect = "redirect:/notice/";
		return redirect;
	}
}
