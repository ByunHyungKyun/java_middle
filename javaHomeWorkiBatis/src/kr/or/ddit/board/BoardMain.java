package kr.or.ddit.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardMain {

	private IBoardService boardService;
	
	public BoardMain() {
		boardService = BoardServiceImpl.getInstance();
	}
	
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
		System.out.println("검색할 정보를 입력하시오");
		 scan.nextLine();
		System.out.print("번호 입력 >> ");
		String boardno = scan.nextLine();
		
		System.out.println("제목입력 >>");
		String content = scan.nextLine();
		
		System.out.println("글쓴이 입력 >>");
		String writer = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardno(boardno);
		bv.setContent(content);
		bv.setWriter(writer);
		
		List<BoardVO> boardList = boardService.getSearchBoard(bv);
		
		
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println(" 글번호\t제  목\t이  름\t내용\t날  짜");
			System.out.println("----------------------------------------");
			for (BoardVO bv2 : boardList) {
				System.out.println(bv2.getBoardno()
						+"\t"+bv2.getTitle()
						+"\t"+bv2.getWriter()
						+"\t"+bv2.getContent()
						+"\t"+bv2.getDate());
			}
			
			System.out.println("-----------------------------------------------------");
			System.out.println("출력 작업 끝...");
			
	
	}

	private void deleteboard() {
		System.out.println();
		System.out.println("삭제할 글번호를 입력하시오");
		 scan.nextLine();
		System.out.print("번호 입력 >> ");
		String boardno = scan.nextLine();
		
		int cnt = boardService.deleteBoard(boardno);
		
		if(cnt > 0) {
			System.out.println(boardno+"글을 삭제 작업 성공");
		}else {
			System.out.println(boardno+"글을 삭제 실패!!");
		}
		
	}

	private void displayAll() {
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println(" 글번호\t제  목\t이  름\t날  짜");
		System.out.println("----------------------------------------");
		
		
		List<BoardVO> boardList = boardService.getAllBoardList();
		
		for (BoardVO bv : boardList) {
			System.out.println(bv.getBoardno()+"\t"+bv.getTitle()+
					"\t"+bv.getWriter()+"\t"+bv.getDate());
		}
		
			System.out.println("-----------------------------------------------------");
			System.out.println("출력 작업 끝...");
	}

	private void updateboard() {
		boolean chk = false;
		String boardno = null;
		
		do {
			System.out.println();
			System.out.println("수정할 글의 번호를 입력하시오");
			System.out.print("번호입력 >> ");
			scan.nextLine();
			boardno = scan.nextLine();
			
			chk =boardService.checkBoard(boardno);
			
			if(chk == false) {
				System.out.println("글의 번호가 "+boardno+"인 번호가 없습니다");
				System.out.println("다시 입력해주세요");
			}	
		}while(chk == false);
		
		
		scan.nextLine();
		//제목,작성자,작성날짜,내용
		System.out.println("제목 입력하시오>> ");
		String title = scan.nextLine();
		
		System.out.println("작성자 이름을 입력하시오>> ");
		String writer = scan.next();
		
		scan.nextLine();
		System.out.println("내용을 입력하시오 >> ");
		String content = scan.nextLine();
		
			
		BoardVO bv = new BoardVO();
		bv.setContent(content);
		bv.setWriter(writer);
		bv.setContent(content);
			
		int cnt = boardService.updateBoard(bv);
			
			if(cnt > 0) {
				System.out.println(boardno+"번글 수정성공");
			}else {
				System.out.println(boardno+"번글 수정실패");
			}
			
		
	}
	
	
	private void insertboard() {
		
		scan.nextLine();
		//제목,작성자,작성날짜,내용
		System.out.println("제목 입력하시오>> ");
		String title = scan.nextLine();
		
		System.out.println("작성자 이름을 입력하시오>> ");
		String writer = scan.next();
		
		scan.nextLine();
		System.out.println("내용을 입력하시오 >> ");
		String content = scan.nextLine();
		
		
		
		BoardVO bv = new BoardVO();
		bv.setTitle(title);
		bv.setWriter(writer);
		bv.setContent(content);
			
			int cnt = boardService.insertBoard(bv);
			
			if(cnt > 0) {
				System.out.println(writer+"님의 글이 정상적으로 등록 되었습니다");
			}else {
				System.out.println(writer+"님의 글이 등록 되지않았습니다.다시 시도해주세요!");
			}
	}	
	
	public static void main(String[] args) {
		BoardMain homework = new BoardMain();
		homework.start();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
