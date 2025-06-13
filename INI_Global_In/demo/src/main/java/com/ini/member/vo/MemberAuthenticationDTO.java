package com.ini.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberAuthenticationDTO {

	private String user_id;
	private Date last_login;
	private Date create_date;
	private Date update_date;
	private int report_count;
	private String user_status;
	private String role;
	
	
}
