package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.LectureDTO;

/**
 * Connect Lecture SQL
 * @author leejinho
 *
 */
@Mapper
public interface LectureMapper {
	/**
	 * 모든 강의 리스트 출력
	 * @return 모든 강의 리스트
	 */
	ArrayList<LectureDTO> lectureListAll();

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @return 카테고리 기반 강의 리스트
	 */
	ArrayList<LectureDTO> lectureList1(String category1);

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @param category2
	 * @return 카테고리 기반 강의 리스트
	 */
	ArrayList<LectureDTO> lectureList2(@Param("category1")String category1, @Param("category2")String category2);

	/**
	 * 강의 등록
	 * @param lectureDTO
	 */
	void insertLecture(LectureDTO lectureDTO);

	/**
	 * 강의 세부 내용 출력
	 * @param lectureNo
	 * @return
	 */
	LectureDTO lectureDetail(String lectureNo);

	/**
	 * 총 강의 수
	 * @return
	 */
	int lectureCount();
}
