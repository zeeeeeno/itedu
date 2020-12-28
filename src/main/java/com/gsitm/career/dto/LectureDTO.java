package com.gsitm.career.dto;

import lombok.Data;

/**
 * Lecture Data Transfer Object
 * @author leejinho
 *
 */
@Data
public class LectureDTO {
	private int lectureNo;
	private String lectureName;
	private String lectureTeacher;
	private String lecturePrice;
	private String lecturePeriod;
	private String lectureStartDate;
	private String lectureEndDate;
	private String lectureCategoryMainCategory;
	private String lectureCategorySubCategory;
	private String lectureContents;
	private String lectureThumbnail;
	private String lectureCreDate;
	private String lectureAcaedmy;
}
