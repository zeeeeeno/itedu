package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> selectUser() throws Exception;
	public void memberInsert(MemberDTO memberDTO) throws Exception;
	public Boolean login(MemberDTO memberDTO) throws Exception;
	public MemberDTO getMemberInfo(String memberEmail) throws Exception;
}
