// Notice Data Transfer Object

package com.gsitm.career.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContents;
	private int clickNum;
	private String date;
}
