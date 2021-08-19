package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class homework_01 {
	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			FileInputStream fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			FileOutputStream fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			
			int c= 0;
			
			while((c=fis.read()) != -1) {
				fos.write(c);
			}
			
			 fis.close();
	         fos.close();
	         System.out.println("작업 끝...");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
