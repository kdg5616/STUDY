package com.ini.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardEmoticonDTO {

	private String emoticon_name;
	private String emoticon_file_name;
	private String emoticon_creator;
	private Date emoticon_create_date;
	private String emoticon_status;
	
}
