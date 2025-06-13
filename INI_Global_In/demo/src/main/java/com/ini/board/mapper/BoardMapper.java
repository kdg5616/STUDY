package com.ini.board.mapper;

import com.ini.board.vo.BoardCategoryVO;
import com.ini.board.vo.BoardDTO;
import com.ini.board.vo.BoardDetailDTO;
import com.ini.board.vo.BoardListDTO;
import com.ini.board.vo.BoardTagVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 등록
    void insertPost(BoardDTO dto);

    // 카테고리, 말머리 목록 조회
    List<BoardTagVO> getAllTags();
    List<BoardCategoryVO> getAllCategories();

    // 게시글 목록 (검색 + 필터 + 페이징)
    List<BoardListDTO> getPostList(
        @Param("keyword") String keyword,
        @Param("category") String category,
        @Param("tag") String tag,
        @Param("offset") int offset,
        @Param("limit") int limit
    );

    // 게시글 전체 개수 (페이징을 위해)
    int getPostCount(
        @Param("keyword") String keyword,
        @Param("category") String category,
        @Param("tag") String tag
    );
    
    List<BoardTagVO> selectAllBoardTags();
    List<BoardCategoryVO> selectAllBoardCategories();
    BoardDetailDTO selectPostById(@Param("id") int id);

}
