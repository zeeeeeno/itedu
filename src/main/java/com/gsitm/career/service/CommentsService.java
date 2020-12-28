package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.CommentsDTO;

public interface CommentsService {
	public void regiser(String contetns, String writer, String lectureNo) throws Exception;
	public ArrayList<CommentsDTO> list(String lectureNo) throws Exception;
}
