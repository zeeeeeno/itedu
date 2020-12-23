/*
 * Academy Service 구현부
 */
package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.mapper.AcademyMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class AcademyServiceImpl implements AcademyService{

	@Autowired
	AcademyMapper academyMapper;

	/*
	 * Academy Sign Up
	 * - parameter
	 * 	1) academyDTO: 학원 회원가입 정보
	 */
	@Override
	public void signUp(AcademyDTO academyDTO) {
		log.info("AcademyServiceImpl - signUp()");

		academyMapper.signUp(academyDTO.getAcademy_email(), academyDTO.getAcademy_pw(), academyDTO.getAcademy_name());
	}

	/*
	 * Academy 로그인
	 * - parameter
	 * 	1) academyDTO: 로그인 입력 정보
	 */
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

	/*
	 * Academy 패스워드 가져오기
	 * - parameter
	 * 	1) email: 학원 아이디
	 */
	public String getPassword(String email) {
		log.info("AcademyServiceImpl - getPassword() email: " + email);

		return academyMapper.getPasswordAcademy(email);
	}

	/*
	 * Academy 정보 가져오기
	 * - parameter
	 * 	1) memberEmail: 학원 아이디
	 */
	@Override
	public ArrayList<AcademyDTO> getAcademyInfo(String memberEmail) {
		log.info("AcademyServiceImpl - getAcademyInfo() - memberEmail: " + memberEmail);

		return academyMapper.getAcademyInfo(memberEmail);
	}
}
