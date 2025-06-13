package com.ini.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ini.member.service.MemberService;
import com.ini.member.vo.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {

	private final MemberService memberservice;
	
	@GetMapping("memberTest")
	public String memberTest(Model model) {
		
		MemberDTO memberVO = memberservice.findAllMember();
		
		model.addAttribute("members" ,memberVO);
		
		return "/member/test";
		
	}
	
	@GetMapping("myPage")
	public String myPageTest(Model model) {
		
		model.addAttribute("member_info", memberservice.findMemberById("test"));
		model.addAttribute("member_follow", memberservice.findFollowById("test"));
		model.addAttribute("member_board", memberservice.findBoardById("test"));
		model.addAttribute("member_like", memberservice.findLikeById("test"));
		model.addAttribute("member_reply", memberservice.findReplyById("test"));
		model.addAttribute("member_favorite", memberservice.findFavoriteById("test"));
		
		return "/member/MemberMyPage";
	}
	
}
