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

@Log
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	/*
	 * member list print
	 */
	@Override
	public ArrayList<MemberDTO> selectUser() {
		log.info("MemberServiceImpl - selectUser()");
		log.info(memberMapper.selectUser().toString());

		return memberMapper.selectUser();
	}


	/*
	 * 회원가입
	 * - parameter
	 * 	1) memberDTO: 회원정보
	 */
	@Override
	public void memberInsert(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - memberInsert()");
		String address = memberDTO.getMember_address() + " " + memberDTO.getMember_addressDetail();

		memberMapper.memberInsert(memberDTO.getMember_email(), memberDTO.getMember_passwd(), memberDTO.getMember_name(), memberDTO.getMember_postNo(), address);
	}

	/*
	 * 로그인
	 * - parameter
	 * 	1) memberDTO: 회원정보
	 * - return: true/false
	 */
	@Override
	public Boolean login(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - login()");
		String email = memberDTO.getMember_email();
		String dbPW = getPassword(email);
		if (dbPW.equals(memberDTO.getMember_passwd())) {
			return true;
		} else
			return false;
	}

	/*
	 * 패스워드 가져오기
	 * - parameter
	 * 	1) email: 회원 아이디
	 */
	public String getPassword(String email) {
		log.info("MemberServiceImpl - login()");

		return memberMapper.getPassword(email);
	}

	/*
	 * 회원정보 가져오기
	 * - parameter
	 * 	1) email: 회원 아이디
	 */
	@Override
	public ArrayList<MemberDTO> getMemberInfo(String memberEmail) {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - getMemberInfo() - memberEmail: " + memberEmail);


		return memberMapper.getMemberInfo(memberEmail);
	}
}
