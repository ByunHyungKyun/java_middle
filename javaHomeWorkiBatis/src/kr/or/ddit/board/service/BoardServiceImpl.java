package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;


public  class BoardServiceImpl implements IBoardService{

	private IBoardDao boardDao;
	private SqlMapClient smc;
	
	private static IBoardService boardService;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	
	
	public static IBoardService getInstance() {
		
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		
		return boardService;
	}
	
	
	
	
	public int insertBoard(BoardVO bv) {
		
		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(smc, bv);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	
	
	public boolean checkBoard(String boardno) {
		boolean chk = false;
		
		try {
			chk = boardDao.checkBoard(smc, boardno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getAllBoardList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	
	
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	
	
	public int deleteBoard(String boardno) {
		int cnt = 0;
		
		try {
			cnt = boardDao.deleteBoard(smc, boardno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bv) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getSearchBoard(smc, bv);
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return boardList;
	}
	
	
	
	
	
	
	
	
	
	
	
}
