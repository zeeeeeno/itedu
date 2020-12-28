package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.AcademyDTO;

public interface AcademyService {
	public void signUp(AcademyDTO academyDTO) throws Exception;
	public void academyApprove(String academyEmail) throws Exception;
	public Boolean login(AcademyDTO academyDTO) throws Exception;
	public AcademyDTO getAcademyInfo(String memberEmail) throws Exception;
	public ArrayList<AcademyDTO> academyList() throws Exception;
}
