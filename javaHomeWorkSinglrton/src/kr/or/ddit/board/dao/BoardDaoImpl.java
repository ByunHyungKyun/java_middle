package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.JDBCUtil3;


public  class BoardDaoImpl implements IBoardDao{

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static IBoardDao boardDao;
	
	private BoardDaoImpl() {
		
	}
	
	public static IBoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	
	
	
	
	
	
	
	
	public int insertBoard(Connection conn, BoardVO bv) throws SQLException {
		
		int cnt=0;
		try {
			String sql = "insert into jdbc_board(board_no,board_title,board_writer,board_date,board_content)"
					+ "values(board_seq.NEXTVAL,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getWriter());
			pstmt.setString(3, bv.getContent());
		
		cnt = pstmt.executeUpdate();
		}finally {
			JDBCUtil3.disConnect(null, null, pstmt,null);
		}
	return cnt;
		
	}
	
	
	public boolean checkBoard(Connection conn, String boardno) throws SQLException {
		boolean chk = false;
		try {
			String sql = "select count(*) as cnt from jdbc_board where board_no= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardno);//pstmt는 0이 아니라 1부터 시작한다
			
			rs = pstmt.executeQuery();
			
			int cnt =0;
			while(rs.next()) {
				cnt =rs.getInt("cnt");	
			}
			
			if(cnt > 0) {
				chk = true;
			}				
		}finally {
			JDBCUtil3.disConnect(null, null, pstmt, rs);
		}
		return chk;
	}
	@Override
	public List<BoardVO> getAllBoardList(Connection conn) throws SQLException {
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
	try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("select * from jdbc_board");
			
			while(rs.next()) {
				BoardVO bv = new BoardVO();
				String boardno =rs.getString("board_no");
				String title =rs.getString("board_title");
				String writer =rs.getString("board_writer");
				String date =rs.getString("board_date");
				String content =rs.getString("board_content");
				
				bv.setBoardno(boardno);
				bv.setTitle(title);
				bv.setWriter(writer);
				bv.setDate(date);
				
				boardList.add(bv);
			}
		}finally {
			JDBCUtil3.disConnect(null, stmt, null, rs);
		}
		
		
		
		
		
		return boardList;	
	}
	
	
	@Override
	public int updateBoard(Connection conn, BoardVO bv) throws SQLException {
		
		int cnt = 0;
		try {
			
			String sql = "update jdbc_board"
					+ " set board_title =?"
					+ " ,board_writer =?"
					+ " ,board_content =?"
					+ " where board_no =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, bv.getTitle());
			pstmt.setString(2, bv.getWriter());
			pstmt.setString(3, bv.getContent());
			pstmt.setString(4, bv.getBoardno());
			
			cnt = pstmt.executeUpdate();
			
		}finally {
			JDBCUtil3.disConnect(null, null, pstmt, null);
		}
		
		return cnt;	
		
	}

	
	
	
	
	

	@Override
	public int deleteBoard(Connection conn, String boardno) throws SQLException {

		int cnt=0;
		
		try {
			
			String sql = "delete from jdbc_board where board_no =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, boardno);
			
			cnt = pstmt.executeUpdate();
			
		}finally {
			JDBCUtil3.disConnect(null, null, pstmt, null);
		}
		return cnt;
	}
	
	
	
	@Override
	public List<BoardVO> getSearchBoard(Connection conn, BoardVO bv) throws SQLException {
	List<BoardVO> memList = new ArrayList<>();
		
		//아이디나 비밀번호나 주소나 전화번호 어떤것이 나올줄 모르니까이렇게 만든다
		try {
			String sql = "select * from jdbc_board where 1=1";
			if(bv.getBoardno() != null && !bv.getBoardno().equals("")) {
				sql += " and board_no = ? ";
			}
			if(bv.getTitle() != null && !bv.getTitle().equals("")) {
				sql += " and board_title = ? ";
			}
			if(bv.getWriter() != null && !bv.getWriter().equals("")) {
				sql += " and board_writer = ? ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1;
			//위에 물음표가 몇개일지 몰라 이렇게 만들었는데 인덱스는 1부터 시작해서 넣어준다
			if(bv.getBoardno() != null && !bv.getBoardno().equals("")) {
				pstmt.setString(index++, bv.getBoardno());
			}
			if(bv.getTitle() != null && !bv.getTitle().equals("")) {
				pstmt.setString(index++, bv.getTitle());
			}
			if(bv.getWriter() != null && !bv.getWriter().equals("")) {
				pstmt.setString(index++, bv.getWriter());
			}

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO mv2 = new BoardVO();
				mv2.setBoardno(rs.getString("board_no"));
				mv2.setTitle(rs.getString("board_title"));
				mv2.setWriter(rs.getString("board_writer"));
				mv2.setContent(rs.getString("board_content"));
				mv2.setDate(rs.getString("board_date"));
				
				memList.add(mv2);
			}
		}finally {
			JDBCUtil3.disConnect(null, null, pstmt, rs);
		}
		return memList;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
