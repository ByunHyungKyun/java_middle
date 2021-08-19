package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 세션(HttpSession) 객체에 대하여...
 * 
 * -세션을 통해서 사용자(웹브라우저)별로 구분하여 정보를 관리할수있다
 * 	(세션ID 이용)--단위가 사용자ID단위이다 (request객체는 요청단위이기때문에 다르다)
 * (쿠키를 사용할 때 보다 보안이 향상된다.(정보가 서버에 저장되기 때문에...))
 * 
 * -세션 객체를 가져오는 방법
 * HttpSession session = request.getSession(boolean값);
 * boolean값 : true인 경우=> 세션객체가 존재하지 않으면 새로 생성함  == 무조건 세션이 넘어오게된다
 * 			false인 경우=> 세션객체가 존재하지 않으면 null리턴함 == 세션이 존재하는 경우에만 넘어오게 된다
 * --그래서 false로 설정하는게 대부분이다. 무조건 세션이 넘어오는걸 설정하는게 아니라면. 세션존재만 확인하고 싶으면 false
 * 
 * -세션 삭제처리 방법
 * 1. invalidate()메서드 호출
 * 2. setManInactiveInterval(int interval)메서드 호출
 * 	=> 일정시간(초)동안 요청이 없으면 세션객체 삭제됨.
 * 3. web.xml에 <session-config>설정하기(분단위)
 */
public class T06_ServletSessionTest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//세션을 가져오는데 없으면 새로 생성한다
		HttpSession session = req.getSession(true);// request에서 세션객체를 얻어오는 것이다.
		
		//생성 시간 가져오기
		Date createTime = new Date(session.getCreationTime());
		
		
		//마지막 접근시간 가져오기
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		
		String title = "재방문을 환영합니다";
		int visitCount = 0; //방문 횟수
		String userId = "sem"; //사용자 ID
		
		if(session.isNew()){//새로만든 세션이라면...
			title = "처음 방문을 환영합니다";
			session.setAttribute("userId", userId);
		}else {
			visitCount = (Integer)session.getAttribute("visitCount");
			
			visitCount++;
			userId = (String) session.getAttribute("userId");
		}
		
		System.out.println("visitCount: "+visitCount);
		
		//방문횟수 설정
		session.setAttribute("visitCount", visitCount);
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println(
				"<html><head><title>" + title
				+ "</title></head>"
				+ "<body><h1 align=\"center\">" + title
				+ "</h1>"
				+ "<h2 align=\"center\">세션정보</h2>"
				+ "<table border=\"1\" align=\"center\">"
				+ "<tr bgcolor=\"orange\">"
				+ "<th>구분</th><th>값</th>" + "</tr>"
				+ "<tr><td>세션ID</td><td>"
				+ session.getId() + "</td></tr>"
				+ "<tr><td>생성시간</td><td>"
				+ createTime + "</td></tr>"
				+ "<tr><td>마지막 접근시간</td><td>"
				+ lastAccessTime + "</td></tr>"
				+ "<tr><td>User ID</td><td>"
				+ userId + "</td></tr>"
				+ "<tr><td>방문횟수</td><td>"
				+ visitCount + "</td></tr></table>"
				+ "</body></html>" );
		
			session.invalidate();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}







