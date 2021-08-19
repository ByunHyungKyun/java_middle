package kr.or.ddit.board.service;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	
	
	public int insertBoard(BoardVO bv);
	
	public List<BoardVO> getAllBoardList();
	
	public int updateBoard(BoardVO bv);
	
	
	public int deleteBoard(String boardNum);
	
	public BoardVO getBoard(String boardNum);

}
