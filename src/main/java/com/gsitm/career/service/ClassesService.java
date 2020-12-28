package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.ClassesDTO;

/**
 * Classes Service
 * @author leejinho
 *
 */
public interface ClassesService {
	/**
	 * Print List of Classes
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ClassesDTO> list() throws Exception;

	/**
	 * 강의 수강여부 함수
	 * @param lectureNo
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Boolean isListenLecture(String lectureNo, String id) throws Exception;

	/**
	 * 수강신청
	 * @param lectureNo
	 * @param memberEmail
	 * @throws Exception
	 */
	public void apply(String lectureNo, String memberEmail) throws Exception;
}
