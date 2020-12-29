package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import com.gsitm.career.dto.AcademyDTO;

/**
 * Connect Academy SQL
 * @author leejinho
 *
 */
@Mapper
public interface AcademyMapper {
	/**
	 * Academy SignUp
	 * @param id
	 * @param pw
	 * @param name
	 * @throws Exception
	 */
	void signUp(String id, String pw, String name) throws Exception;

	/**
	 * Admin approve academy Sign Up
	 * @param academyEmail
	 * @throws Exception
	 */
	void academyApprove(String academyEmail) throws Exception;

	/**
	 * Get Academy Password
	 * @param email
	 * @return
	 * @throws Exception
	 */
	String getPasswordAcademy(String email) throws Exception;

	/**
	 * Get Academy Information
	 * @param memberEmail
	 * @return
	 * @throws Exception
	 */
	AcademyDTO getAcademyInfo(String memberEmail) throws Exception;

	/**
	 * Print Academy List
	 * @return
	 * @throws Exception
	 */
	ArrayList<AcademyDTO> academyList() throws Exception;
}
