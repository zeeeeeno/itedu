package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.NoticeDTO;
import com.gsitm.career.mapper.NoticeMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public ArrayList<NoticeDTO> noticeList(int displayPost, int postNum) throws Exception {
		log.info("NoticeServiceImpl - noticeList()");
		// TODO Auto-generated method stub
		return noticeMapper.selectNotice(displayPost, postNum);
	}

	@Override
	public void savePost(NoticeDTO dto) throws Exception {
		log.info("NoticeServiceImpl - savePost() dto: " + dto.getNoticeContents());
		noticeMapper.savePost(dto.getNoticeTitle(), dto.getNoticeContents());
	}

	@Override
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo) throws Exception {
		log.info("NoticeServiceImpl - noticeDetail() boardNo: " + boardNo);
		return noticeMapper.noticeRead(boardNo);
	}

	@Override
	public void updateNotice(Long noticeNo, String Title, String Contents) throws Exception {
		log.info("NoticeServiceImpl - updateNotice() boardNo: " + noticeNo);
		noticeMapper.updateNotice(noticeNo, Title, Contents);
	}

	@Override
	public void deleteNotice(Long noticeNo) throws Exception {
		log.info("NoticeServiceImpl - deleteNotice() boardNo: " + noticeNo);
		noticeMapper.deleteNotice(noticeNo);
	}

	@Override
	public int noticeCount() throws Exception {
		log.info("NoticeServiceImpl - noticeCount()");

		return noticeMapper.noticeCount();
	}

	@Override
	public void countViews(Long noticeNo) throws Exception {
		log.info("NoticeServiceImpl - countViews() noticeNo: " + noticeNo);
		noticeMapper.countViews(noticeNo);
	}

}
