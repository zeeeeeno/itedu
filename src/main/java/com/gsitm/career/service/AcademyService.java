package com.gsitm.career.service;

import java.util.ArrayList;

import com.gsitm.career.dto.AcademyDTO;

public interface AcademyService {
	public void signUp(AcademyDTO academyDTO);
	public Boolean login(AcademyDTO academyDTO);
	public ArrayList<AcademyDTO> getAcademyInfo(String memberEmail);
}
