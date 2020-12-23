// Member Data Transfer Object
package com.gsitm.career.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private String member_no;
	private String member_email;
	private String member_passwd;
	private String member_name;
	private String member_postNo;
	private String member_address;
	private String member_addressDetail;
	private String member_auth;
}
