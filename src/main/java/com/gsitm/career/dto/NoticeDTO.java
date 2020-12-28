package com.gsitm.career.dto;

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
	private int clickNum;
	private String date;
}
