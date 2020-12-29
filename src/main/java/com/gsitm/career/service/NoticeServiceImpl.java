package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.NoticeDTO;
import com.gsitm.career.mapper.NoticeMapper;

import lombok.extern.java.Log;

/**
 * Notice Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeMapper noticeMapper;

	/**
	 * Print Notice List
	 * @param displayPost
	 * @param postNum
	 * @return Notice List
	 * @throws Exception
	 */
	@Override
	public ArrayList<NoticeDTO> noticeList(int displayPost, int postNum) throws Exception {
		log.info("NoticeServiceImpl - noticeList()");
		// TODO Auto-generated method stub
		return noticeMapper.selectNotice(displayPost, postNum);
	}

	/**
	 * Save notice post
	 * @param dto
	 * @throws Exception
	 */
	@Override
	public void savePost(NoticeDTO dto) throws Exception {
		log.info("NoticeServiceImpl - savePost() dto: " + dto.getNoticeContents());
		noticeMapper.savePost(dto.getNoticeTitle(), dto.getNoticeContents());
	}

	/**
	 * Print notice detail
	 * @param boardNo
	 * @return notice detail contents
	 * @throws Exception
	 */
	@Override
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo) throws Exception {
		log.info("NoticeServiceImpl - noticeDetail() boardNo: " + boardNo);
		return noticeMapper.noticeRead(boardNo);
	}

	/**
	 * Update notice contents
	 * @param noticeNo
	 * @param Title
	 * @param Contents
	 * @throws Exception
	 */
	@Override
	public void updateNotice(Long noticeNo, String Title, String Contents) throws Exception {
		log.info("NoticeServiceImpl - updateNotice() boardNo: " + noticeNo);
		noticeMapper.updateNotice(noticeNo, Title, Contents);
	}

	/**
	 * Delete notice post
	 * @param noticeNo
	 * @throws Exception
	 */
	@Override
	public void deleteNotice(Long noticeNo) throws Exception {
		log.info("NoticeServiceImpl - deleteNotice() boardNo: " + noticeNo);
		noticeMapper.deleteNotice(noticeNo);
	}

	/**
	 * All Count Notice
	 * @return count of tuple
	 * @throws Exception
	 */
	@Override
	public int noticeCount() throws Exception {
		log.info("NoticeServiceImpl - noticeCount()");

		return noticeMapper.noticeCount();
	}

	/**
	 * Add postview
	 * @param noticeNo
	 * @throws Exception
	 */
	@Override
	public void countViews(Long noticeNo) throws Exception {
		log.info("NoticeServiceImpl - countViews() noticeNo: " + noticeNo);
		int selectViews = noticeMapper.selectViews(noticeNo);
		int addNum = selectViews + 1;
		noticeMapper.updateSelectViews(noticeNo, addNum);
	}

	@Override
	public ArrayList<NoticeDTO> noticeSearch(String category, String keyword) throws Exception {
		log.info("NoticeServiceImpl - noticeSearch() category: " + category + ", keyword: " + keyword);

		ArrayList<NoticeDTO> arrayList = null;

		if(category.equals("notice_title")) {
			arrayList =  noticeMapper.noticeSearchTitle(keyword);
		} else if(category.equals("notice_title")) {
			arrayList =  noticeMapper.noticeSearchDate(keyword);
		}

		return arrayList;
	}
}
