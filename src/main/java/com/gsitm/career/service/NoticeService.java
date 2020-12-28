package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.NoticeDTO;

public interface NoticeService {
	public ArrayList<NoticeDTO> noticeList(int displayPost, int postNum) throws Exception;
	public void savePost(NoticeDTO dto) throws Exception;
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo) throws Exception;
	public void updateNotice(Long noticeNo, String Title, String Contents) throws Exception;
	public void deleteNotice(Long noticeNo) throws Exception;
	public void countViews(Long noticeNo) throws Exception;
	public int noticeCount() throws Exception;
}
