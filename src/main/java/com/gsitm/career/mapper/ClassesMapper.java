package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.ClassesDTO;

@Mapper
public interface ClassesMapper {
	ArrayList<ClassesDTO> list(String email) throws Exception;
	int isListenClasses(@Param("lectureNo")String lectureNo, @Param("memberEmail")String id) throws Exception;
	void apply(@Param("lectureNo")String lectureNo, @Param("memberEmail")String memberEmail) throws Exception;
}
