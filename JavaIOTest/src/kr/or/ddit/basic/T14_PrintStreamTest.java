package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
 * 프린터 기능 제공 보조 스트림
 */
public class T14_PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		
		//PrintStream은 모든 자료형을 출력할수 있는 기능을 제공하는 OutputStream
		//의 서브클래스이다
		//PrintStream은 IOExeption을 발생시키지 않는다
		//println 및 print 등 메서드 호출시마다 autoflush 기능 제공됨 
		PrintStream out = new PrintStream(fos);//기반스트림이 있어야 사용가능해서 먼저 파일 스트림을 불러줬다
		out.print("안녕하세요,PrintStream입니다.\n");
		out.println("안녕하세요 PrintStream입니다2");
		out.println("안녕하세요 PrintStream입니다3");
		out.println(out); //객체출력
		out.println(3.14);
		
		/*
		 * PrintStream은 데이터를 문자로 출력하는 기능을 수행함(System.out)
		 * 향상된 기능의 PrintWriteer가 추가되었지만 계속 사용됨 
		 * 
		 * PrintWriter가 PrintStream보다 다양한 언어의  문자를 처리하는데 
		 *적합하다. 둘다 기본적으로 autoflush 기능이 꺼져 있음 
		 */
		
		
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2,"UTF-8"));
		
		pw.print("안녕하세요.PrintWriter 입니다\r\n"); //윈도우 체계에서는 \r\n 유닉스는 \n 맥은 \r 으로 한줄바꿈을 한다
		pw.println("안녕하세요 PrintWriter 입니다2");
		pw.println("안녕하세요 PrintWriter 입니다3");
		
		pw.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
