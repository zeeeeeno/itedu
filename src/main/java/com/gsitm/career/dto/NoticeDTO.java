package com.gsitm.career.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Notice Data Transfer Object
 */
import lombok.Data;

@Data
public class NoticeDTO {
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContents;
	private String noticeClickNum;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
	private String createTime;
}
