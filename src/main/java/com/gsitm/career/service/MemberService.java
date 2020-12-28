package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.MemberDTO;

/**
 * Member Service
 * @author leejinho
 *
 */
public interface MemberService {
	/**
	 * 멤버 리스트 출력
	 * @return
	 * @throws Exception
	 */
	public ArrayList<MemberDTO> selectUser() throws Exception;

	/**
	 * 회원가입
	 * @param memberDTO
	 * @throws Exception
	 */
	public void memberInsert(MemberDTO memberDTO) throws Exception;

	/**
	 * 로그인
	 * @param memberDTO
	 * @return
	 * @throws Exception
	 */
	public Boolean login(MemberDTO memberDTO) throws Exception;

	/**
	 * 멤버 정보 가져오기
	 * @param memberEmail
	 * @return
	 * @throws Exception
	 */
	public MemberDTO getMemberInfo(String memberEmail) throws Exception;
}
