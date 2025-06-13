package com.ini.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberFollowDTO {

	private String follower_id;
	private String user_id;
	private Date follow_date;
	
}
