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

	@RequestMapping("/")
	public String notice(Model model) {
		log.info("NoticeController - notice()");

		ArrayList<NoticeDTO> arrayList = noticeService.noticeList();

		model.addAttribute("notice", arrayList);

		return "notice/noticeList";
	}

	@RequestMapping("/create")
	public String noticeCreate(Model model) {
		log.info("NoticeController - noticeCreate()");

		return "notice/noticeCreate";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String noticeinsert(@ModelAttribute(name = "noticeDTO") NoticeDTO noticeDTO, HttpServletRequest request) {
		log.info("NoticeController - noticeinsert() noticeDTO: " + noticeDTO);
		noticeService.savePost(noticeDTO);
		return "notice/noticeList";
	}

	@RequestMapping(value = "/detail/{noticeNo}", method = RequestMethod.GET)
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);
		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeDetail";
	}

	@RequestMapping(value = "/update/{noticeNo}", method = RequestMethod.GET)
	public String noticeUpdate(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) {
		log.info("NoticeController - noticeDetail() noticeNo: " + noticeNo);
		ArrayList<NoticeDTO> notice = noticeService.noticeDetail(noticeNo);
		model.addAttribute("notice", notice);

		return "notice/noticeModify";
	}

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
