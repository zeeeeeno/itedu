package com.gsitm.career.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.career.dto.MemberDTO;
import com.gsitm.career.mapper.DemoMapper;

import lombok.extern.java.Log;

@Log
@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	@Autowired
	DemoMapper demoMapper;

	@Override
	public ArrayList<MemberDTO> selectUser() {
		log.info("MemberServiceImpl - selectUser()");
		log.info(demoMapper.selectUser().toString());

		return demoMapper.selectUser();
	}

	@Override
	public void memberInsert(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - memberInsert()");
		String address = memberDTO.getMember_address() + " " + memberDTO.getMember_addressDetail();

		demoMapper.memberInsert(memberDTO.getMember_email(), memberDTO.getMember_passwd(), memberDTO.getMember_name(), memberDTO.getMember_postNo(), address);
	}

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

	public String getPassword(String email) {
		log.info("MemberServiceImpl - login()");

		return demoMapper.getPassword(email);
	}

	@Override
	public ArrayList<MemberDTO> getMemberInfo(String memberEmail) {
		// TODO Auto-generated method stub
		log.info("MemberServiceImpl - getMemberInfo() - memberEmail: " + memberEmail);


		return demoMapper.getMemberInfo(memberEmail);
	}
}
