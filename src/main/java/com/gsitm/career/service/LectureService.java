package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.LectureDTO;

public interface LectureService {
	public ArrayList<LectureDTO> lectureList(String category1);
	public void insertLecture(LectureDTO lectureDTO, String id);
}
