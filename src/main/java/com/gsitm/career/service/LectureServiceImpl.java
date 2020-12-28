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
	public ArrayList<LectureDTO> lectureList(String category1) throws Exception{
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
	public void insertLecture(LectureDTO lectureDTO) throws Exception{
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - insertLecture() lectureDTO: " + lectureDTO);
		lectureMapper.insertLecture(lectureDTO);
	}

	@Override
	public LectureDTO lectureDetail(String lectureNo) throws Exception {
		log.info("lectureDetail() lectureNo: " + lectureNo);

		return lectureMapper.lectureDetail(lectureNo);
	}

	@Override
	public ArrayList<LectureDTO> lectureListDetail(String category1, String category2) throws Exception {
		log.info("lectureDetail() category1: " + category1 + ", category2: " + category2);

		return lectureMapper.lectureList2(category1, category2);
	}

	@Override
	public int lectureCount() throws Exception {
		log.info("lectureDetail() lectureCount()");

		return lectureMapper.lectureCount();
	}

	@Override
	public ArrayList<LectureDTO> lectureListAll() throws Exception {
		log.info("lectureDetail() lectureListAll()");

		return lectureMapper.lectureListAll();
	}
}
