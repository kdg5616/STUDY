package com.ini.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberFavoriteDTO {

	private int board_id;
	private String user_id;
	private Date favorite_date;
	
}
