package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.gsitm.career.dto.AcademyDTO;
import com.gsitm.career.dto.LectureDTO;
import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.dto.NoticeDTO;

@Component
@Mapper
public interface DemoMapper {
	ArrayList<MemberDTO> selectUser();
	void memberInsert(String id, String pw, String name, String postCode, String address);
	String getPassword(String email);
	ArrayList<MemberDTO> getMemberInfo(String email);

	ArrayList<NoticeDTO> selectNotice();
	void savePost(String title, String contents);
	ArrayList<NoticeDTO> noticeRead(long noticeNo);
	void updateNotice(Long noticeNo, String Title, String Contents);
	void deleteNotice(Long noticeNo);

	ArrayList<LectureDTO> lectureList1(String category1);
	ArrayList<LectureDTO> lectureList2(String category1, String category2);

	void signUp(String id, String pw, String name);
	String getPasswordAcademy(String email);
	ArrayList<AcademyDTO> getAcademyInfo(String memberEmail);
	void insertLecture(String title, String teacher, String period, String price, String category1, String category2, String contents, String thumbnail, String id);
}
