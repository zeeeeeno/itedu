package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.mapper.DemoMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class LectureServiceImpl implements LectureService {
	@Autowired
	DemoMapper demoMapper;

	@Override
	public ArrayList<LectureDTO> lectureList(String category1) {
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - lectureList() category1: " + category1);

		return demoMapper.lectureList1(category1);
	}

	@Override
	public void insertLecture(LectureDTO lectureDTO, String id) {
		// TODO Auto-generated method stub
		log.info("LectureServiceImpl - insertLecture() lectureDTO: " + lectureDTO);
		String period = lectureDTO.getLectureStartDate() + " " + lectureDTO.getLectureEndDate();
		demoMapper.insertLecture(lectureDTO.getLectureTitle(), lectureDTO.getLectureTeacher(), period, lectureDTO.getLecturePrice(), lectureDTO.getLectureCategory1(), lectureDTO.getLectureCategory2(), lectureDTO.getLectureContents(), lectureDTO.getLectureThumbnail(), id);
	}

}
