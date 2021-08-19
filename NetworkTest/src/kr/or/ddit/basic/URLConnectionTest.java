package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
		//URLConnection => 애플리케이션(java프로그램)과 URL간의 통신 연결을 위한
		//					추상클래스
		
		//특정서버(예:naver)의 정보와 파일 내용을 출력하기
		URL url = new URL("https://www.naver.com/index.html");
		
		//Header 정보 가져오기
		
		//URLConnection 객체 구하기
		URLConnection urlCon = url.openConnection(); //네이버와 연결을 해주는곳
		
		System.out.println("Content-Type : "+urlCon.getContentType());
		System.out.println("Encoding : "+urlCon.getContentEncoding());
		System.out.println("Content : "+urlCon.getContent());
		System.out.println();
		
		//전체 Header정보 출력하기
		Map<String,List<String>> headerMap = 
				urlCon.getHeaderFields();//헤더정보를 가져올수있는 메소드가 getHeaderFields()이다 //맵으로 리턴해준다
		
		//Header의 key값 구하기
		Iterator<String> it = headerMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+headerMap.get(key));
		}
		
		System.out.println("--------------------------------------------");
		
		
		//해당 호스트의 페이지 내용 가져오기
		
		//파일을 읽어오기 위한 스트림 생성
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8"); //바이트 단위를 한글로 읽을려고 보조스트림을 썻다
		
		
		int c= 0;
		while((c = isr.read()) != -1) {
			System.out.print((char)c);
		}
		
		isr.close();//스트림 닫기(보조스트림만 닫아도된다)
		
	}
}














































