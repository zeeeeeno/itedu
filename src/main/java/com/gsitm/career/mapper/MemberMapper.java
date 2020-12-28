package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	ArrayList<MemberDTO> selectUser();
	void memberInsert(@Param("id")String id, @Param("password")String password, @Param("name")String name, @Param("postCode")String postCode, @Param("address")String address);
	String getPassword(String email);
	MemberDTO getMemberInfo(String email);
}
