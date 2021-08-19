package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

public class HomeWork {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");

	}
	
	public void start() {
		int choice;
		do {
			displayMenu();
			choice=scan.nextInt();
			switch(choice) {
			case 1: //전체 목록 출력
				displayAll();
				break;
			case 2: //새글작성
				insertboard();
				break;
			case 3: //수정
				updateboard();
				break;
			case 4: //삭제
				deleteboard();
				break;
			case 5: //검색
				searchboard();
				break;
			case 6: //작업 끝
				System.out.println("작업을 종료합니다. 이용해주셔서 감사합니다^^");
				break;
			default :
			System.out.println("번호를 잘못입력하셨습니다. 다시입력해주세요");
			
			}
			
		}while(choice !=6 );
		
		
	}

	private void searchboard() {
		System.out.println();
		System.out.println("검색할 글번호를 입력하시오");
		 scan.nextLine();
		System.out.print("번호 입력 >> ");
		String board_number = scan.nextLine();
		
		try {
			conn = JDBCUtil3.getConnection(); 
			String sql = "select * from jdbc_board where board_no =?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, board_number);
			
			rs=pstmt.executeQuery();
			
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println(" 글번호\t제  목\t이  름\t내용\t날  짜");
			System.out.println("----------------------------------------");
			
			
			while(rs.next()) {
				String board_no=rs.getString("board_no");
				String board_title=rs.getString("board_title");
				String board_name=rs.getString("board_writer");
				String board_content=rs.getString("board_content");
				String board_date=rs.getString("board_date");
				System.out.println(board_no+"\t"+board_title+"\t"+board_name
						+"\t"+board_content+"\t"+board_date);
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("출력 작업 끝...");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
	}

	private void deleteboard() {
		System.out.println();
		System.out.println("삭제할 글번호를 입력하시오");
		 scan.nextLine();
		System.out.print("번호 입력 >> ");
		String board_number = scan.nextLine();
		
		try {
		conn = JDBCUtil3.getConnection(); 
		
		String sql = "delete from jdbc_board where board_no =?";
		pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, board_number);
		
		
		int cnt = pstmt.executeUpdate();
		
		if(cnt > 0) {
			System.out.println(board_number+"글을 삭제 작업 성공");
		}else {
			System.out.println(board_number+"글을 삭제 실패!!");
		}
		
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println(board_number+"글을 삭제 실패하였습니다.");
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
	}

	private void displayAll() {
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println(" 글번호\t제  목\t이  름\t날  짜");
		System.out.println("----------------------------------------");
		
		try {
			
			
			conn=JDBCUtil.getConnection();
			
			stmt = conn.createStatement();
			
			rs=stmt.executeQuery("select * from jdbc_board");
			while(rs.next()) {
				String board_no=rs.getString("board_no");
				String board_title=rs.getString("board_title");
				String board_name=rs.getString("board_writer");
				String board_date=rs.getString("board_date");
				System.out.println(board_no+"\t"+board_title+"\t"+board_name
						+"\t"+board_date);
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("출력 작업 끝...");
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
	}

	private void updateboard() {
		boolean chk = false;
		String board_no = null;
		
		do {
			System.out.println();
			System.out.println("수정할 글의 번호를 입력하시오");
			System.out.print("번호입력 >> ");
			board_no = scan.nextLine();
			
			chk = checkboard(board_no);
			
			if(chk == false) {
				System.out.println("글의 번호가 "+board_no+"인 번호가 없습니다");
				System.out.println("다시 입력해주세요");
			}	
		}while(chk == false);
		
		
		scan.nextLine();
		//제목,작성자,작성날짜,내용
		System.out.println("제목 입력하시오>> ");
		String title = scan.nextLine();
		
		System.out.println("작성자 이름을 입력하시오>> ");
		String name = scan.next();
		
		scan.nextLine();
		System.out.println("내용을 입력하시오 >> ");
		String content = scan.nextLine();
		
		try {
			
			
			conn=JDBCUtil.getConnection();
			
			String sql = "update jdbc_board"
					+ " set board_title =?"
					+ " ,board_writer =?"
					+ " ,board_content =?"
					+ " where board_no =?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			pstmt.setString(4, board_no);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(board_no+"번글 수정성공");
			}else {
				System.out.println(board_no+"번글 수정실패");
			}
			
		} catch (Exception e) {
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
			
		}	
	}

	private boolean checkboard(String board_no) {
		boolean chk = false;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			String sql = "select count(*) as cnt from jdbc_board where board_no= ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, board_no);
			
			rs=pstmt.executeQuery();
			
			int cnt=0;
			while(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
			if(cnt>0) {
				chk =true;
				return true;
			}
		} catch (Exception e) {
		}finally {
			
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return false;
	}

	
	
	private void insertboard() {
		
		scan.nextLine();
		//제목,작성자,작성날짜,내용
		System.out.println("제목 입력하시오>> ");
		String title = scan.nextLine();
		
		System.out.println("작성자 이름을 입력하시오>> ");
		String name = scan.next();
		
		scan.nextLine();
		System.out.println("내용을 입력하시오 >> ");
		String content = scan.nextLine();
		
		try {
			
			conn = JDBCUtil.getConnection();
			String sql = "insert into jdbc_board(board_no,board_title,board_writer,board_date,board_content)"
					+ "values(board_seq.NEXTVAL,?,?,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println(name+"님의 글이 정상적으로 등록 되었습니다");
			}else {
				System.out.println(name+"님의 글이 등록 되지않았습니다.다시 시도해주세요!");
			}
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}

	}	
	
	
	public static void main(String[] args) {
		HomeWork homework = new HomeWork();
		homework.start();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
