package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.ClassesDTO;
import com.gsitm.career.mapper.ClassesMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesMapper classesMapper;

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

	@Override
	public ArrayList<ClassesDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apply(String lectureNo, String memberEmail) throws Exception {
		log.info("apply(): lectureNo: " + lectureNo + ", memberEmail" + memberEmail);
		classesMapper.apply(lectureNo, memberEmail);
	}
}
