package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferUnderflowException;

public class homework_02 {
	public static void main(String[] args) throws FileNotFoundException {
		
		try {
			FileInputStream fis = new FileInputStream("d:/D_Other/Tulips.jpg");
			FileOutputStream fos = new FileOutputStream("d:/D_Other/복사본_Tulips.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis,5);
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			
					
					
					
			int c= 0;
			
			while((c=bis.read()) != -1) {
				bos.write(c);
			}
			
			bos.flush();
			bis.close();
			bos.close();
			System.out.println("작업 끝...");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
