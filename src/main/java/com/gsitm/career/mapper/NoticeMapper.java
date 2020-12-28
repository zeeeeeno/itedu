package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	ArrayList<NoticeDTO> selectNotice(@Param("displayPost")int displayPost, @Param("postNum")int postNum);
	void savePost(String title, String contents);
	ArrayList<NoticeDTO> noticeRead(long noticeNo);
	void updateNotice(Long noticeNo, String Title, String Contents);
	void deleteNotice(Long noticeNo);
	int noticeCount();
	void countViews(@Param("noticeNo")Long noticeNo);
}
