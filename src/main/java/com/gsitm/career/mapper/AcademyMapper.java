package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.gsitm.career.dto.AcademyDTO;

/**
 *
 * @author leejinho
 *
 */
@Mapper
public interface AcademyMapper {
	void signUp(String id, String pw, String name);
	String getPasswordAcademy(String email);
	ArrayList<AcademyDTO> getAcademyInfo(String memberEmail);
	void insertLecture(String title, String teacher, String period, String price, String category1, String category2, String contents, String thumbnail, String id);
}
