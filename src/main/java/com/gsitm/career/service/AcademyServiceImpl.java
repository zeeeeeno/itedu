package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.mapper.AcademyMapper;

import lombok.extern.java.Log;

/**
 * Academy Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class AcademyServiceImpl implements AcademyService{

	@Autowired
	AcademyMapper academyMapper;

	/**
	 * Sign Up Function Implements
	 * @param academyDTO
	 */
	@Override
	public void signUp(AcademyDTO academyDTO) throws Exception {
		log.info("AcademyServiceImpl - signUp()");

		academyMapper.signUp(academyDTO.getAcademyEmail(), academyDTO.getAcademyPw(), academyDTO.getAcademyName());
	}

	/**
	 * Login Function Implements
	 * @param true/false
	 */
	@Override
	public Boolean login(AcademyDTO academyDTO) throws Exception {
		log.info("AcademyServiceImpl - login()");
		String email = academyDTO.getAcademyEmail();
		String dbPW = getPassword(email);
		log.info("dbPW: " + dbPW +", " + academyDTO.getAcademyPw());

		if (dbPW.equals(academyDTO.getAcademyPw())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get Password Function Implements
	 * @param password
	 */
	public String getPassword(String email) throws Exception {
		log.info("AcademyServiceImpl - getPassword() email: " + email);

		return academyMapper.getPasswordAcademy(email);
	}

	/**
	 * Get Academy Info Function Implements
	 * @param Academy Information
	 */
	@Override
	public AcademyDTO getAcademyInfo(String memberEmail) throws Exception {
		log.info("AcademyServiceImpl - getAcademyInfo() - memberEmail: " + memberEmail);

		return academyMapper.getAcademyInfo(memberEmail);
	}

	/**
	 * Print Academy List Info Function Implements
	 * @param List of Academy
	 */
	@Override
	public ArrayList<AcademyDTO> academyList() throws Exception {
		log.info("AcademyServiceImpl - academyList()");

		return academyMapper.academyList();
	}

	/**
	 * Approve Academy List Info Function Implements
	 * @param List of Academy
	 */
	@Override
	public void academyApprove(String academyEmail) throws Exception {
		log.info("AcademyServiceImpl - academyApprove() academyEmail: " + academyEmail);
		academyMapper.academyApprove(academyEmail);
	}
}
