package com.gsitm.career.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


/**
 * Academy Data Transfer Object
 * @author leejinho
 *
 */
@Data
public class AcademyDTO {
	private String academyNo;
	private String academyEmail;
	private String academyPw;
	private String academyName;
	private String academyUseYN;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
	private String academyCreDate;
}
