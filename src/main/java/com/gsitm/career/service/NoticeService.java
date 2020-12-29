package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.NoticeDTO;

/**
 * Notice Interface
 * @author leejinho
 *
 */
public interface NoticeService {
	/**
	 * Print Notice List
	 * @param displayPost
	 * @param postNum
	 * @return Notice List
	 * @throws Exception
	 */
	public ArrayList<NoticeDTO> noticeList(int displayPost, int postNum) throws Exception;

	/**
	 * Save notice post
	 * @param dto
	 * @throws Exception
	 */
	public void savePost(NoticeDTO dto) throws Exception;

	/**
	 * Print notice detail
	 * @param boardNo
	 * @return notice detail contents
	 * @throws Exception
	 */
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo) throws Exception;

	/**
	 * Update notice contents
	 * @param noticeNo
	 * @param Title
	 * @param Contents
	 * @throws Exception
	 */
	public void updateNotice(Long noticeNo, String Title, String Contents) throws Exception;

	/**
	 * Delete notice post
	 * @param noticeNo
	 * @throws Exception
	 */
	public void deleteNotice(Long noticeNo) throws Exception;

	/**
	 * Add postview
	 * @param noticeNo
	 * @throws Exception
	 */
	public void countViews(Long noticeNo) throws Exception;

	/**
	 * All Count Notice
	 * @return count of tuple
	 * @throws Exception
	 */
	public int noticeCount() throws Exception;

	public ArrayList<NoticeDTO> noticeSearch(String category, String keyword) throws Exception;
}
