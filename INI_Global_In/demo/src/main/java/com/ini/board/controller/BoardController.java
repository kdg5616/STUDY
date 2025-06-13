package com.ini.board.controller;

import com.ini.board.mapper.BoardMapper;
import com.ini.board.service.BoardService;
import com.ini.board.vo.BoardCategoryVO;
import com.ini.board.vo.BoardDTO;
import com.ini.board.vo.BoardDetailDTO;
import com.ini.board.vo.BoardTagVO;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @PostMapping("/write")
    public String submitPost(@RequestParam("board_title") String boardTitle,
                             @RequestParam("board_content") String boardContent,
                             @RequestParam("board_category") String boardCategory,
                             @RequestParam("board_tag") String boardTag,
                             @RequestParam("image") MultipartFile imageFile,
                             HttpSession session) throws IOException {

        // 이미지 파일 저장
        String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
        String uploadPath = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
        File destFile = new File(uploadPath + fileName);
        destFile.getParentFile().mkdirs();
        imageFile.transferTo(destFile);

        // 게시글 정보 구성
        BoardDTO dto = new BoardDTO();
        dto.setBoard_title(boardTitle);
        dto.setBoard_content(boardContent);
        dto.setBoard_category(boardCategory);
        dto.setBoard_tag(boardTag);
        dto.setBoard_views(0);
        dto.setBoard_write_date(new Date());
        dto.setBoard_update_date(new Date());

        // 로그인 사용자 ID 세션에서 가져오기 (예: "loginUser")
        String userId = (String) session.getAttribute("loginUser");
        dto.setUser_id(userId != null ? userId : "guest"); // 임시 처리

        // 이미지 경로를 content에 포함 (간단히 처리)
        dto.setBoard_content(boardContent + "<br><img src='/uploads/" + fileName + "'>");

        boardService.savePost(dto);
        return "redirect:/board/list"; // 또는 작성 완료 페이지로
    }
    
    @GetMapping("/list")
    public String postList(Model model) {
        model.addAttribute("postList", boardService.getPostList());
        return "board/list";
    }
    
    @GetMapping("/write")
    public String showWriteForm(Model model) {
    	List<BoardTagVO> tags = boardMapper.getAllTags(); // 말머리 목록
    	List<BoardCategoryVO> categories = boardMapper.getAllCategories(); // 카테고리 목록

    	 model.addAttribute("tags", tags);
         model.addAttribute("categories", categories);
        model.addAttribute("boardDTO", new BoardDTO());

        return "board/write"; // templates/board/write.html
    }
    
    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable("id") int id, Model model) {
        BoardDetailDTO post = boardService.getPostById(id);
        model.addAttribute("post", post);
        return "board/view";
    }

}
