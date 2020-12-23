package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.gsitm.career.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	ArrayList<MemberDTO> selectUser();
	void memberInsert(String id, String pw, String name, String postCode, String address);
	String getPassword(String email);
	ArrayList<MemberDTO> getMemberInfo(String email);
}
