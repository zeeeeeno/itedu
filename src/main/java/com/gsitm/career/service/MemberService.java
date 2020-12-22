package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.MemberDTO;

public interface MemberService {
	public ArrayList<MemberDTO> selectUser();
	public void memberInsert(MemberDTO memberDTO);
	public Boolean login(MemberDTO memberDTO);
	public ArrayList<MemberDTO> getMemberInfo(String memberEmail);
}
