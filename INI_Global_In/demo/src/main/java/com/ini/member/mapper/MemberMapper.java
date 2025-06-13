package com.ini.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ini.board.vo.BoardDTO;
import com.ini.board.vo.BoardLikeDTO;
import com.ini.board.vo.BoardReplyDTO;
import com.ini.member.vo.MemberDTO;
import com.ini.member.vo.MemberFavoriteDTO;
import com.ini.member.vo.MemberFollowDTO;

@Mapper
public interface MemberMapper {

	public MemberDTO findAllMember();
	
	public MemberDTO findMemberById(String user_id);
	
	public List<MemberFollowDTO> findFollowById(String user_id);
	
	public List<BoardDTO> findBoardById(String user_id);
	
	public List<BoardLikeDTO> findLikeById(String user_id);
	
	public List<BoardReplyDTO> findReplyById(String user_id);
	
	public List<MemberFavoriteDTO> findFavoriteById(String user_id);
	
	
}
