package com.ini.board.vo;

import lombok.Data;
import java.util.Date;

@Data
public class BoardListDTO {
	
    private int board_id;
    private String board_title;
    private String category_name;   // 게시글 카테고리 이름
    private String tag_name;        // 말머리 이름
    private String user_id;
    private String user_nickname;
    private int board_views;
    private Date board_write_date;
    private int like_count;
    private int reply_count;
}
