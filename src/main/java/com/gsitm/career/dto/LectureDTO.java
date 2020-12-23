 // Lecture Data Transfer Object

package com.gsitm.career.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureDTO {
	private int lectureNo;
	private String lectureTitle;
	private String lectureTeacher;
	private String lecturePrice;
	private String lectureStartDate;
	private String lectureEndDate;
	private String lectureCategory1;
	private String lectureCategory2;
	private String lectureContents;
	private String lectureThumbnail;
	private String lecture_creDate;
	private String lecture_acaedmy;
}
