package com.gsitm.career.dto;

import lombok.Data;

@Data
public class CommentsDTO {
	private int commentNoMain;
	private int commentNoSub;
	private String commentsContents;
	private String lectureLectureNo;
	private String userEmail;
	private String updateTime;
}
