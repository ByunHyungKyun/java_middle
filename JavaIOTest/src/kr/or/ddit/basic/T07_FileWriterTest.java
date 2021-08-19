package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * FileWriter(문자기반 스트림) 예제
 */
public class T07_FileWriterTest {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준 입력장치)과 연결된 입력용 문자 스트림 생성
		//InputStreamReader = > 바이트 기반 스트림 을 문자 기반 스트림으로 
		//					=>변환해 주는 보조 스트림
		//기반스트림을 도와주는 보고스트림으로 이걸써야 한글도 우리가 볼수있다
		InputStreamReader isr = new InputStreamReader(System.in);//scaner에서도 쓰인것처럼 시스템인은 입력을 받는다
		//이건 문자기반 스트림이다
		
		FileWriter fw = null; // 파일 출력용 문자 기반 스트림 
		
		
		try {
			//파일 출력용 문자 스트림 객체 생성
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int c;
			
			System.out.println("아무거나 입력하세요");
			
			
			
			//콘솔에서 입력할때 입력의 끝 표시는 Ctrl+z 키를 누르면 된다
			while((c = isr.read()) != -1) { 
				fw.write(c); //콘솔에서 입력받은 값을 파일에 출력하기
			}
			
			System.out.println("작업끝...");
			
			isr.close();
			fw.close();
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}






































