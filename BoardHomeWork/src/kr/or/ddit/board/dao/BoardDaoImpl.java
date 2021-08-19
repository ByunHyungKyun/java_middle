package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{

	
private static IBoardDao boardDao;
	
	private BoardDaoImpl() { //외부에서 객체생성 방지 메서드 
	}
	
	public static IBoardDao getInstance() { //내부에서는 객체를 만들수있어서 여기서 만들어 준다 ,이미 있다면 만들었던 객체를 리턴해준다
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = 0;
		
		Object obj=smc.insert("board.insertBoard", bv);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoardList(SqlMapClient smc) throws SQLException {
		List<BoardVO> memList =smc.queryForList("board.allListBoard");
		
		return memList;
	}

	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = 0;
		
		cnt = smc.update("board.updateBoard",bv);
		
		return cnt;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, String boardNum) throws SQLException {
			int cnt=0;
		
		cnt = smc.delete("board.deleteBoard", boardNum);
		System.out.println("딜리트 결과다잉"+cnt);
		return cnt;
	}

	@Override
	public BoardVO getBoard(SqlMapClient smc, String boardNum) throws SQLException {
		BoardVO bv = (BoardVO)smc.queryForObject("board.getBoardInfo",boardNum);
		
		
		return bv;
	}

	
	
	
}
