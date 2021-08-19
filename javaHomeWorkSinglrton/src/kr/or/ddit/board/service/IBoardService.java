package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardService {
	

	public int insertBoard(BoardVO bv);
	
	
	public boolean checkBoard(String boardno);

	
	public List<BoardVO> getAllBoardList();
	
	public int updateBoard (BoardVO bv);
	
	public int deleteBoard(String boardno);
	
	public List<BoardVO> getSearchBoard(BoardVO bv);
}
