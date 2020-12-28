package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.ClassesDTO;

public interface ClassesService {
	public ArrayList<ClassesDTO> list() throws Exception;
	public Boolean isListenLecture(String lectureNo, String id) throws Exception;
	public void apply(String lectureNo, String memberEmail) throws Exception;
}
