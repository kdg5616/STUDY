package com.ini.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {

	private int board_id;
	private String board_title;
	private String board_content;
	private String user_id;
	private int board_views;
	private String board_category;
	private Date board_write_date;
	private Date board_update_date;
	private String board_tag;
	
}
