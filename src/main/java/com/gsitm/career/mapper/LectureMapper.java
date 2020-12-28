package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.LectureDTO;

/**
 *
 * @author leejinho
 *
 */
@Mapper
public interface LectureMapper {
	ArrayList<LectureDTO> lectureListAll();
	ArrayList<LectureDTO> lectureList1(String category1);
	ArrayList<LectureDTO> lectureList2(@Param("category1")String category1, @Param("category2")String category2);
	void insertLecture(LectureDTO lectureDTO);
	LectureDTO lectureDetail(String lectureNo);
	int lectureCount();
}
