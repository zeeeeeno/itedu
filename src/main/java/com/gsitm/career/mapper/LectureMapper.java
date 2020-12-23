package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.gsitm.career.dto.LectureDTO;

@Mapper
public interface LectureMapper {
	ArrayList<LectureDTO> lectureList1(String category1);
	ArrayList<LectureDTO> lectureList2(String category1, String category2);
	void insertLecture(String title, String teacher, String period, String price, String category1, String category2, String contents, String thumbnail, String id);
}
