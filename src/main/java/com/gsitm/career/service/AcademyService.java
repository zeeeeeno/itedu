package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.AcademyDTO;

/**
 * Academy Service
 * @author leejinho
 *
 */
public interface AcademyService {
	/**
	 * Academy Sign Up
	 * @param academyDTO
	 * @throws Exception
	 */
	public void signUp(AcademyDTO academyDTO) throws Exception;

	/**
	 * Academy Approve
	 * @param academyEmail
	 * @throws Exception
	 */
	public void academyApprove(String academyEmail) throws Exception;

	/**
	 * 로그인 여부
	 * @param academyDTO
	 * @return
	 * @throws Exception
	 */
	public Boolean login(AcademyDTO academyDTO) throws Exception;

	/**
	 * Get Academy Info
	 * @param memberEmail
	 * @return
	 * @throws Exception
	 */
	public AcademyDTO getAcademyInfo(String memberEmail) throws Exception;

	/**
	 * Print Academy List
	 * @return
	 * @throws Exception
	 */
	public ArrayList<AcademyDTO> academyList() throws Exception;
}
