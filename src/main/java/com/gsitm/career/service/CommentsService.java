package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.CommentsDTO;

/**
 * Comments Service
 * @author leejinho
 *
 */
public interface CommentsService {
	/**
	 * 댓글 작성
	 * @param contetns
	 * @param writer
	 * @param lectureNo
	 * @throws Exception
	 */
	public void regiser(String contetns, String writer, String lectureNo) throws Exception;

	/**
	 * 댓글 출력
	 * @param lectureNo
	 * @return 댓글 리스트
	 * @throws Exception
	 */
	public ArrayList<CommentsDTO> list(String lectureNo) throws Exception;

	public void deleteComments(String commentsNo) throws Exception;
}
