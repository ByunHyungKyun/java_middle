package kr.or.ddit.board.vo;

public class BoardVO {

	@Override
	public String toString() {
		return "BoardVO [boardno=" + boardno + ", title=" + title + ", writer=" + writer + ", date=" + date
				+ ", content=" + content + "]";
	}
	private String boardno;
	private String title;
	private String writer;
	private String date;
	private String content;
	
	public String getBoardno() {
		return boardno;
	}
	public void setBoardno(String boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
