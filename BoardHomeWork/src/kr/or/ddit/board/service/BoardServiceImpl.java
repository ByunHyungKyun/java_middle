package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class BoardServiceImpl  implements IBoardService{

	private IBoardDao boardDao;
	private SqlMapClient smc;
	
	private static IBoardService boardService;
	 
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(boardService==null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.insertBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.getAllBoardList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt = 0;
		
		try {
			cnt = boardDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteBoard(String boardNum) {
		int cnt = 0;
		
		try {
			cnt = boardDao.deleteBoard(smc, boardNum);
			System.out.println("딜리트 결과다잉"+cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public BoardVO getBoard(String boardNum) {
		
		BoardVO bv = null;
		
		
		try {
			bv = boardDao.getBoard(smc, boardNum);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return bv;
	}

	
	
	
	
	
}
