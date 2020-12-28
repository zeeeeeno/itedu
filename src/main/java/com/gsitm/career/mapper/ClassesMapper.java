package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.ClassesDTO;

/**
 * Call Classes SQL
 * @author leejinho
 *
 */
@Mapper
public interface ClassesMapper {

	/**
	 * 사용자 수강 정보 출력
	 * @param email
	 * @return 사용자 수강 정보 리스트
	 * @throws Exception
	 */
	ArrayList<ClassesDTO> list(String email) throws Exception;

	/**
	 * 강의 수강 여부 확인
	 * @param lectureNo
	 * @param id
	 * @return count(*)
	 * @throws Exception
	 */
	int isListenClasses(@Param("lectureNo")String lectureNo, @Param("memberEmail")String id) throws Exception;

	/**
	 * 수강 신청
	 * @param lectureNo
	 * @param memberEmail
	 * @throws Exception
	 */
	void apply(@Param("lectureNo")String lectureNo, @Param("memberEmail")String memberEmail) throws Exception;
}
