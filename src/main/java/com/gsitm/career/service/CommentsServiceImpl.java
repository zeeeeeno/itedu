package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.CommentsDTO;
import com.gsitm.career.mapper.CommentsMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsMapper commentsMapper;

	@Override
	public void regiser(String contents, String writer, String lectureNo) throws Exception {
		log.info("register() contents: " + contents + ", writer: " + writer + ", lectureNo: " + lectureNo);
		commentsMapper.register(contents, writer, lectureNo);
	}

	@Override
	public ArrayList<CommentsDTO> list(String lectureNo) throws Exception {
		log.info("list() lectureNo: " + lectureNo);

		return commentsMapper.list(lectureNo);
	}
}
