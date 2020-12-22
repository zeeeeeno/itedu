package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.mapper.DemoMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class AcademyServiceImpl implements AcademyService{

	@Autowired
	DemoMapper demoMapper;

	@Override
	public void signUp(AcademyDTO academyDTO) {
		log.info("AcademyServiceImpl - signUp()");

		demoMapper.signUp(academyDTO.getAcademy_email(), academyDTO.getAcademy_pw(), academyDTO.getAcademy_name());
	}

	@Override
	public Boolean login(AcademyDTO academyDTO) {
		log.info("AcademyServiceImpl - login()");
		String email = academyDTO.getAcademy_email();
		String dbPW = getPassword(email);
		log.info("dbPW: " + dbPW +", " + academyDTO.getAcademy_pw());

		if (dbPW.equals(academyDTO.getAcademy_pw())) {
			log.info("로그인 성공");
			return true;
		} else {
			log.info("로그인 실패");
			return false;
		}
	}

	public String getPassword(String email) {
		log.info("AcademyServiceImpl - getPassword() email: " + email);

		return demoMapper.getPasswordAcademy(email);
	}

	@Override
	public ArrayList<AcademyDTO> getAcademyInfo(String memberEmail) {
		log.info("AcademyServiceImpl - getAcademyInfo() - memberEmail: " + memberEmail);

		return demoMapper.getAcademyInfo(memberEmail);
	}
}
