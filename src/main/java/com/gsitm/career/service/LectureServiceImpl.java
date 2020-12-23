/*
 * Lecture Service 구현부
 */
package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.mapper.LectureMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	@Autowired
	LectureMapper lectureMapper;

	/*
	 * 강의 리스트 출력
	 * - parameter
	 * 	1) category1: 첫 번째 카테고리
	 */
	@Override
	public ArrayList<LectureDTO> lectureList(String category1) {
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - lectureList() category1: " + category1);

		return lectureMapper.lectureList1(category1);
	}

	/*
	 * 강의 리스트 출력
	 * - parameter
	 * 	1) lectureDTO: 강의 정보
	 * 	1) id: 학원 아이디
	 */
	@Override
	public void insertLecture(LectureDTO lectureDTO, String id) {
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - insertLecture() lectureDTO: " + lectureDTO);
		String period = lectureDTO.getLectureStartDate() + " " + lectureDTO.getLectureEndDate();
		lectureMapper.insertLecture(lectureDTO.getLectureTitle(), lectureDTO.getLectureTeacher(), period, lectureDTO.getLecturePrice(), lectureDTO.getLectureCategory1(), lectureDTO.getLectureCategory2(), lectureDTO.getLectureContents(), lectureDTO.getLectureThumbnail(), id);
	}

}
