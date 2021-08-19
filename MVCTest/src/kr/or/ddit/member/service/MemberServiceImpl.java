package kr.or.ddit.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberServiceImpl implements IMemberService{
	
	// 사용할 DAO의 객체변수를 선언한다
	private IMemberDao memDao;
	private Connection conn;
	
	
	public MemberServiceImpl() {
		memDao = new MemberDaoImpl();
	}
	
	
	
	@Override
	public int insertMember(MemberVO mv) {
		
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			cnt = memDao.insertMember(conn, mv);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		
		return cnt;
	}
	/*
	 * conn.setAutoCommit(false);//이렇게 해놓으면 자동커밋이 안된다 
			
			cnt = memDao.insertMember(conn, mv);
			
			//sql이 에러가 나면 이밑으로 가지않아서 DB가 영향을 받지 않는다
			conn.commit(); //이분으로 와야 커밋이 된다 
			
		} catch (SQLException e) {
			try {
				conn.rollback(); //위에서 sql이 에러가 났을때 롤백을 해주는 메서드
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	 */

	
	@Override
	public boolean checkMember(String memId) {
		boolean chk = false;
		
		try {
			conn = JDBCUtil3.getConnection();
			chk = memDao.checkMember(conn, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		
		return chk;
	}

	
	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn = JDBCUtil3.getConnection();
			memList = memDao.getAllMemberList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return memList;
	}

	
	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		
		try {
			conn=JDBCUtil3.getConnection();
			cnt = memDao.updateMember(conn, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		
		return cnt;
	}

	
	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		
		try {
			conn = JDBCUtil3.getConnection();
			cnt = memDao.deleteMember(conn, memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return cnt;
	}

	
	
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			
			conn = JDBCUtil3.getConnection();
			memList = memDao.getSearchMember(conn, mv);
			
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil3.disConnect(conn, null, null, null);
		}
		return memList;
	}
	
	
	
	
	
}



















































