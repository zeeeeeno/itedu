package com.gsitm.career.dto;

import lombok.Data;

/**
 * Comments Data Transfer Object
 * @author leejinho
 *
 */
@Data
public class CommentsDTO {
	private int commentNoMain;
	private int commentNoSub;
	private String commentsContents;
	private String lectureLectureNo;
	private String userEmail;
	private String updateTime;
}
