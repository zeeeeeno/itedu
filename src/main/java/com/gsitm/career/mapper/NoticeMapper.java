package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.gsitm.career.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	ArrayList<NoticeDTO> selectNotice();
	void savePost(String title, String contents);
	ArrayList<NoticeDTO> noticeRead(long noticeNo);
	void updateNotice(Long noticeNo, String Title, String Contents);
	void deleteNotice(Long noticeNo);
}
