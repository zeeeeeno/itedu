package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.NoticeDTO;
import com.gsitm.career.mapper.DemoMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	DemoMapper demoMapper;

	@Override
	public ArrayList<NoticeDTO> noticeList() {
		log.info("NoticeServiceImpl - noticeList()");
		// TODO Auto-generated method stub
		return demoMapper.selectNotice();
	}

	@Override
	public void savePost(NoticeDTO dto) {
		log.info("NoticeServiceImpl - savePost() dto: " + dto.getNoticeContents());
		demoMapper.savePost(dto.getNoticeTitle(), dto.getNoticeContents());
	}

	@Override
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo) {
		log.info("NoticeServiceImpl - noticeDetail() boardNo: " + boardNo);
		return demoMapper.noticeRead(boardNo);
	}

	@Override
	public void updateNotice(Long noticeNo, String Title, String Contents) {
		log.info("NoticeServiceImpl - updateNotice() boardNo: " + noticeNo);
		demoMapper.updateNotice(noticeNo, Title, Contents);
	}

	@Override
	public void deleteNotice(Long noticeNo) {
		log.info("NoticeServiceImpl - deleteNotice() boardNo: " + noticeNo);
		demoMapper.deleteNotice(noticeNo);
	}

}
