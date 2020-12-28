package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.LectureDTO;

public interface LectureService {
	public ArrayList<LectureDTO> lectureListAll() throws Exception;
	public ArrayList<LectureDTO> lectureList(String category1) throws Exception;
	public ArrayList<LectureDTO> lectureListDetail(String category1, String category2) throws Exception;
	public LectureDTO lectureDetail(String category1) throws Exception;
	public void insertLecture(LectureDTO lectureDTO) throws Exception;
	public int lectureCount() throws Exception;
}
