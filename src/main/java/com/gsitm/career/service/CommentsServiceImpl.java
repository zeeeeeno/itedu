package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.CommentsDTO;
import com.gsitm.career.mapper.CommentsMapper;

import lombok.extern.java.Log;

/**
 * Comments Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	CommentsMapper commentsMapper;

	/**
	 * 댓글 작성
	 * @param contetns
	 * @param writer
	 * @param lectureNo
	 * @throws Exception
	 */
	@Override
	public void regiser(String contents, String writer, String lectureNo) throws Exception {
		log.info("register() contents: " + contents + ", writer: " + writer + ", lectureNo: " + lectureNo);
		commentsMapper.register(contents, writer, lectureNo);
	}

	/**
	 * 댓글 출력
	 * @param lectureNo
	 * @return 댓글 리스트
	 * @throws Exception
	 */
	@Override
	public ArrayList<CommentsDTO> list(String lectureNo) throws Exception {
		log.info("list() lectureNo: " + lectureNo);

		return commentsMapper.list(lectureNo);
	}

	@Override
	public void deleteComments(String commentsNo) throws Exception {
		log.info("deleteComments() commentsNo: " + commentsNo);
		commentsMapper.delete(commentsNo);
	}
}
