package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.LectureDTO;

/**
 * Lecture Service
 * @author leejinho
 *
 */
public interface LectureService {
	/**
	 * 모든 강의 리스트 출력
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LectureDTO> lectureListAll() throws Exception;

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LectureDTO> lectureList(String category1) throws Exception;

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @param category2
	 * @return
	 * @throws Exception
	 */
	public ArrayList<LectureDTO> lectureListDetail(String category1, String category2) throws Exception;

	/**
	 * 세부 강의 내용 출력
	 * @param category1
	 * @return
	 * @throws Exception
	 */
	public LectureDTO lectureDetail(String category1) throws Exception;

	/**
	 * 강의 등록
	 * @param lectureDTO
	 * @throws Exception
	 */
	public void insertLecture(LectureDTO lectureDTO) throws Exception;

	/**
	 * 총 강의 수 출력
	 * @return
	 * @throws Exception
	 */
	public int lectureCount() throws Exception;
}
