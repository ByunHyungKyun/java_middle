package kr.or.ddit.board.vo;

public class BoardVO {

	
	private long boardNum        ;
	private String memId           ;
	private String boardTitle      ;
	private String boardContent    ;
	private String boardDate       ;
	private long boardReple      ;
	private long boardCount      ;
	private String boardPath       ;
	
	private long atchFileId = -1     ;
	
	
	
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(long boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public long getBoardReple() {
		return boardReple;
	}
	public void setBoardReple(long boardReple) {
		this.boardReple = boardReple;
	}
	public long getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(long boardCount) {
		this.boardCount = boardCount;
	}
	public String getBoardPath() {
		return boardPath;
	}
	public void setBoardPath(String boardPath) {
		this.boardPath = boardPath;
	}
	
	
	
	
	
	
	
	
	
}
