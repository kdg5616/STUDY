package com.ini.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDetailDTO {
	private int board_id;
    private String board_title;
    private String board_content;
    private String user_id;
    private String user_nickname;
    private int board_views;
    private String board_category;
    private String category_name;
    private String board_tag;
    private String tag_name;
    private Date board_write_date;
}
