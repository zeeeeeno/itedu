package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.CommentsDTO;

/**
 * Call Comments SQL
 * @author leejinho
 *
 */
@Mapper
public interface CommentsMapper {
	/**
	 * 댓글 등록
	 * @param contents
	 * @param writer
	 * @param lectureNo
	 * @throws Exception
	 */
	void register(@Param("contents")String contents, @Param("writer")String writer, @Param("lectureNo")String lectureNo) throws Exception;

	/**
	 * 댓글 리스트 출력
	 * @param lectureNo
	 * @return
	 * @throws Exception
	 */
	ArrayList<CommentsDTO> list(String lectureNo) throws Exception;

	void delete(@Param("commentsNo")String commentsNo);
}
