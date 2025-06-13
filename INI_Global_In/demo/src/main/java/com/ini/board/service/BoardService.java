package com.ini.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ini.board.mapper.BoardMapper;
import com.ini.board.vo.BoardCategoryVO;
import com.ini.board.vo.BoardDTO;
import com.ini.board.vo.BoardDetailDTO;
import com.ini.board.vo.BoardListDTO;
import com.ini.board.vo.BoardTagVO;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public void savePost(BoardDTO dto) {
        boardMapper.insertPost(dto);
    }

    public List<String> getCategoryList() {
    	return boardMapper.selectAllBoardCategories()
                .stream()
                .map(BoardCategoryVO::getCategoryName)
                .toList(); // Java 16 이상
    }

    public List<String> getHeadList() {
    	return boardMapper.selectAllBoardTags()
                .stream()
                .map(BoardTagVO::getTagName)
                .toList(); // Java 16 이상
    }
    
    // 게시글 목록 조회 (기본 조건, limit 10개로 테스트)
    public List<BoardListDTO> getPostList() {
        String keyword = null;
        String category = null;
        String tag = null;
        int offset = 0;
        int limit = 10;

        return boardMapper.getPostList(keyword, category, tag, offset, limit);
    }
    
    public List<BoardTagVO> getAllTags() {
        return boardMapper.selectAllBoardTags();
    }

    public List<BoardCategoryVO> getAllCategories() {
        return boardMapper.selectAllBoardCategories();
    }
    
    @Autowired
    private BoardMapper BoardMapper;

    public BoardDetailDTO getPostById(int id) {
        return boardMapper.selectPostById(id);
    }


}