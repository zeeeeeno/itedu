package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.mapper.LectureMapper;

import lombok.extern.java.Log;

/**
 * Lecture Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	@Autowired
	LectureMapper lectureMapper;

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<LectureDTO> lectureList(String category1) throws Exception{
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - lectureList() category1: " + category1);

		return lectureMapper.lectureList1(category1);
	}

	/**
	 * 강의 등록
	 * @param lectureDTO
	 * @throws Exception
	 */
	@Override
	public void insertLecture(LectureDTO lectureDTO) throws Exception{
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - insertLecture() lectureDTO: " + lectureDTO);
		lectureMapper.insertLecture(lectureDTO);
	}

	/**
	 * 세부 강의 내용 출력
	 * @param category1
	 * @return
	 * @throws Exception
	 */
	@Override
	public LectureDTO lectureDetail(String lectureNo) throws Exception {
		log.info("lectureDetail() lectureNo: " + lectureNo);

		return lectureMapper.lectureDetail(lectureNo);
	}

	/**
	 * 카테고리 기반 강의 리스트 출력
	 * @param category1
	 * @param category2
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<LectureDTO> lectureListDetail(String category1, String category2) throws Exception {
		log.info("lectureDetail() category1: " + category1 + ", category2: " + category2);

		return lectureMapper.lectureList2(category1, category2);
	}

	/**
	 * 총 강의 수 출력
	 * @return
	 * @throws Exception
	 */
	@Override
	public int lectureCount() throws Exception {
		log.info("lectureDetail() lectureCount()");

		return lectureMapper.lectureCount();
	}

	/**
	 * 모든 강의 리스트 출력
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<LectureDTO> lectureListAll() throws Exception {
		log.info("lectureDetail() lectureListAll()");

		return lectureMapper.lectureListAll();
	}
}
