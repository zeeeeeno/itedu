package com.gsitm.career.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gsitm.career.dto.MemberDTO;

/**
 * Call Member SQL
 * @author leejinho
 *
 */
@Mapper
public interface MemberMapper {
	/**
	 * Print User List
	 * @return
	 */
	ArrayList<MemberDTO> selectUser();

	/**
	 * 회원가입
	 * @param id
	 * @param password
	 * @param name
	 * @param postCode
	 * @param address
	 */
	void memberInsert(@Param("id")String id, @Param("password")String password, @Param("name")String name, @Param("postCode")String postCode, @Param("address")String address);

	/**
	 * Get Password
	 * @param email
	 * @return
	 */
	String getPassword(String email);

	/**
	 * 회원 정보 가져오기
	 * @param email
	 * @return
	 */
	MemberDTO getMemberInfo(String email);
}
