package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import java.sql.DriverManager;
import kr.or.ddit.board.vo.BoardVO;


public  class BoardDaoImpl implements IBoardDao{

	
	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		
		int cnt=0;
		
		Object obj=smc.insert("board.insertBoard", bv);
		
		
		if(obj == null) {
			cnt=1;
		}
	return cnt;
		
	}
	
	
	public boolean checkBoard(SqlMapClient smc, String boardno) throws SQLException {
		boolean chk = false;
		
		
		int cnt = (int) smc.queryForObject("board.getBoard",boardno);
		
		
		if(cnt > 0) {
			chk =true;
		}
		
		
		return chk;
	}
	@Override
	public List<BoardVO> getAllBoardList(SqlMapClient smc) throws SQLException {
		
		List<BoardVO> boardList = smc.queryForList("board.getBoardAll");
		
		return boardList;	
	}
	
	
	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		
		int cnt = 0;
		
		cnt = smc.update("board.updateBoard",bv);
		
		return cnt;	
		
	}

	
	
	
	
	

	@Override
	public int deleteBoard(SqlMapClient smc, String boardno) throws SQLException {

		int cnt=0;
		
		
		cnt = smc.delete("board.deleteBoard", boardno);
		
		return cnt;
	}
	
	
	
	@Override
	public List<BoardVO> getSearchBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		
		List<BoardVO> memList = smc.queryForList("board.getSearchBoard", bv);
		
		return memList;
	}
	

}
