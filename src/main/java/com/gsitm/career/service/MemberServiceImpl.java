/*
 * Member Service 구현부
 */
package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.mapper.MemberMapper;

import lombok.extern.java.Log;

/**
 * Member Service Implements
 * @author leejinho
 *
 */
@Log
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	/**
	 * 멤버 리스트 출력
	 * @return
	 * @throws Exception
	 */
	@Override
	public ArrayList<MemberDTO> selectUser() throws Exception{
		log.info("MemberServiceImpl - selectUser()");

		return memberMapper.selectUser();
	}


	/**
	 * 회원가입
	 * @param memberDTO
	 * @throws Exception
	 */
	@Override
	public void memberInsert(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - memberInsert()");
		String address = memberDTO.getMemberAddress() + " " + memberDTO.getMemberAddressDetail();

		memberMapper.memberInsert(memberDTO.getMemberEmail(), memberDTO.getMemberPasswd(), memberDTO.getMemberName(), memberDTO.getMemberPostNo(), address);
	}

	/**
	 * 로그인
	 * @param memberDTO
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean login(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - login() memberDTO: " + memberDTO);
		String email = memberDTO.getMemberEmail();
		String dbPW = getPassword(email);
		try {
			if (dbPW.equals(memberDTO.getMemberPasswd())) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	/**
	 * 멤버 정보 가져오기
	 * @param memberEmail
	 * @return
	 * @throws Exception
	 */
	public String getPassword(String email) throws Exception {
		log.info("MemberServiceImpl - getPassword()");

		return memberMapper.getPassword(email);
	}

	/**
	 * 멤버 정보 가져오기
	 * @param memberEmail
	 * @return
	 * @throws Exception
	 */
	@Override
	public MemberDTO getMemberInfo(String memberEmail) throws Exception {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - getMemberInfo() - memberEmail: " + memberEmail);

		return memberMapper.getMemberInfo(memberEmail);
	}
}
