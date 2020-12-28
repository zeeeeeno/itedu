package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.ClassesDTO;
import com.gsitm.career.mapper.ClassesMapper;

import lombok.extern.java.Log;

/**
 * Classes Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesMapper classesMapper;

	/**
	 * 강의 수강 여부
	 * @param lectureNo
	 * @param id
	 * @return true/false
	 */
	@Override
	public Boolean isListenLecture(String lectureNo, String id) throws Exception {
		log.info("isListenLecture(String lectureNo, String id): " + lectureNo + ", " + id);
		Boolean isListen = false;

		int num = classesMapper.isListenClasses(lectureNo, id);

		if(num == 0) {
			isListen = false;
		} else {
			isListen = true;
		}

		return isListen;
	}

	/**
	 * 수강신청 리스트 출력
	 */
	@Override
	public ArrayList<ClassesDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 수강신청
	 * @param lectureNo
	 * @param memberEmail
	 */
	@Override
	public void apply(String lectureNo, String memberEmail) throws Exception {
		log.info("apply(): lectureNo: " + lectureNo + ", memberEmail" + memberEmail);
		classesMapper.apply(lectureNo, memberEmail);
	}
}
