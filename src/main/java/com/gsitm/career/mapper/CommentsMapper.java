package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.CommentsDTO;

@Mapper
public interface CommentsMapper {
	void register(@Param("contents")String contents, @Param("writer")String writer, @Param("lectureNo")String lectureNo) throws Exception;
	ArrayList<CommentsDTO> list(String lectureNo) throws Exception;
}
