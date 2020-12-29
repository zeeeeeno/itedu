package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.NoticeDTO;

/**
 * Call Notice SQL
 * @author leejinho
 *
 */
@Mapper
public interface NoticeMapper {
	/**
	 * Print Notice List
	 * @param displayPost
	 * @param postNum
	 * @return Notice List
	 */
	ArrayList<NoticeDTO> selectNotice(@Param("displayPost")int displayPost, @Param("postNum")int postNum);

	/**
	 * Sava Notice post
	 * @param title
	 * @param contents
	 */
	void savePost(String title, String contents);

	/**
	 * Read Notice Detail
	 * @param noticeNo
	 * @return
	 */
	ArrayList<NoticeDTO> noticeRead(long noticeNo);

	/**
	 * Update to Notice
	 * @param noticeNo
	 * @param Title
	 * @param Contents
	 */
	void updateNotice(@Param("noticeNo")Long noticeNo, @Param("title")String title, @Param("Contents")String Contents);

	/**
	 * Delete Notice(UseYN = 0)
	 * @param noticeNo
	 */
	void deleteNotice(Long noticeNo);

	/**
	 * Count Number of Notice
	 * @return
	 */
	int noticeCount();

	/**
	 * Add countview
	 * @param noticeNo
	 * @return
	 */
	int selectViews(@Param("noticeNo")Long noticeNo);


	void updateSelectViews(@Param("noticeNo")Long noticeNo, @Param("addClickNum")int addClickNum);

	/**
	 *
	 * @param category
	 * @param keyword
	 * @return
	 */
	ArrayList<NoticeDTO> noticeSearchTitle(@Param("keyword")String keyword);

	/**
	 *
	 * @param category
	 * @param keyword
	 * @return
	 */
	ArrayList<NoticeDTO> noticeSearchDate(@Param("keyword")String keyword);
}
