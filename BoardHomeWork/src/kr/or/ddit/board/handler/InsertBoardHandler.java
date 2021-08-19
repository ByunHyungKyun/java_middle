package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.AtchFileServiceImpl;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IAtchFileService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.AtchFileVO;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class InsertBoardHandler implements CommandHandler{
	private static final String VIEW_PAGE = "/WEB-INF/view/boardInsert.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // Get방식인 경우.
			return false;
		}else { // POST 방식인 경우... 
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //POST 방식인 경우 isRedirect를 한다 
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			atchFileVO = fileService.saveAtchFile(item);
			
			
			// 1. 요청파라티터 정보 가져오기
			String boardTitle = req.getParameter("boardTitle");
			String boardContent = req.getParameter("boardContent");
			
			// 2. 서비스 객체 생성하기
			IBoardService boardService = 
					BoardServiceImpl.getInstance();
			
			HttpSession session = req.getSession();
			
			String memId = (String)session.getAttribute("signedUser");

			
			// 3. 회원정보 등록하기
			BoardVO bv = new BoardVO();
			bv.setMemId(memId);
			bv.setBoardTitle(boardTitle);
			bv.setBoardContent(boardContent);
			bv.setAtchFileId(atchFileVO.getAtchFileId());
			
			int cnt = boardService.insertBoard(bv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			
			// 4. 목록 조회화면으로 이동
			String redirectUrl = req.getContextPath() +
					"/HW/board/list.do?msg=" 
					+ URLEncoder.encode(msg, "UTF-8");
			
			return redirectUrl;
		}
	}
	
	
	
	
	
	
	
}