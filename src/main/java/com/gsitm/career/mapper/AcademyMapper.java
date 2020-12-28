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
	void signUp(String id, String pw, String name) throws Exception;
	void academyApprove(String academyEmail) throws Exception;
	String getPasswordAcademy(String email) throws Exception;
	AcademyDTO getAcademyInfo(String memberEmail) throws Exception;
	void insertLecture(String title, String teacher, String period, String price, String category1, String category2, String contents, String thumbnail, String id) throws Exception;
	ArrayList<AcademyDTO> academyList() throws Exception;
}
