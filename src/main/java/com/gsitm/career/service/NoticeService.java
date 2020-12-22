package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.NoticeDTO;

public interface NoticeService {
	public ArrayList<NoticeDTO> noticeList();
	public void savePost(NoticeDTO dto);
	public ArrayList<NoticeDTO> noticeDetail(Long boardNo);
	public void updateNotice(Long noticeNo, String Title, String Contents);
	public void deleteNotice(Long noticeNo);
}
