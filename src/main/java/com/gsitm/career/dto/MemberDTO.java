// Member Data Transfer Object
package com.gsitm.career.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private String memberNo;
	private String memberEmail;
	private String memberPasswd;
	private String memberPasswdCheck;
	private String memberName;
	private String memberPostNo;
	private String memberAddress;
	private String memberAddressDetail;
	private String memberAuth;
}
