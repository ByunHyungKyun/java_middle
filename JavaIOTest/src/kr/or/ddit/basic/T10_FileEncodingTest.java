package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/*
 * OutputStreamWriter를 이용한 인코딩 처리예제
 */
public class T10_FileEncodingTest {
		/*
		 * OutputStreamWriter => OutputStream(바이트기반 출력용 객체)을
		 * 						Writer(문자기반의 출력용 객체)로 변환해주는 객체
		 * 					=> 이객체도 출력할때 '인코딩방식'을 지정해서 출력할수있다
		 */
	public static void main(String[] args) throws IOException {
		//키보드로 입력한 내용을 파일로 저장하는데,
		//out_utf8.txt 파일은 'utf-8'인코딩 방식으로 
		//out_ansi.txt 파일은 'ms949'인코딩 방식으로 저장한다.
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		//파일 출력용
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
		
		//보조스트림 객체 생성
		OutputStreamWriter osw1 = new OutputStreamWriter(fos1 , "utf-8"); //보조스트림은 기반스트림이 꼭 필요하다 ex)fos1
		OutputStreamWriter osw2 = new OutputStreamWriter(fos2 , "ms949");
		
		int c;
		
		System.out.println("아무거나 입력하시오");
		
		while ((c = isr.read()) != -1) {
			osw1.write(c);
			osw2.write(c);
		}
		
		System.out.println("작업완료...");
		
		isr.close();
		osw1.close();
		osw2.close();//보조 스트림만 닫아도 된다
		
	}
}































