package kr.or.ddit.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpFileSender {
	public static final int DEFAULT_BUFFER_SIZE = 1000;
	
	public static void main(String[] args) {
		String serverIp = "127.0.0.1";
		int port = 8888;
		
		File file = new File("d:/D_Other/Tulips.jpg");
		
		DatagramSocket ds = null;
		if(!file.exists()) {
			System.out.println("파일이 존재하지않습니다");
			System.exit(0);
		}
		
		
		long fileSize = file.length();
		long totalReadBytes = 0;
		
		double startTime = 0;
		try {
			
			ds = new DatagramSocket();
			InetAddress serverAddr = InetAddress.getByName(serverIp); //서버주소를 요구하기 떄문에 만든다
			
			startTime = System.currentTimeMillis();
			
			String str = "start";//전송 시작 알림. 준비하라는 의미로 보내는 것이다.
			DatagramPacket dp = new DatagramPacket(str.getBytes(),str.getBytes().length,serverAddr,port);
			//getBytes()은 바이트 배열이다. 그래서 length을 쓸수있는것이다.
			
			ds.send(dp);
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			
			//총 파일 사이즈 정보를 알려줌 
			str = String.valueOf(fileSize);
			dp = new DatagramPacket(str.getBytes(),str.getBytes().length,serverAddr,port);
			ds.send(dp);
			//여기까지는 시작을 알려주고 파일의 길이를 알려줬다.

			
			while(true) {
				try {
					Thread.sleep(10);//패킷 전송간의 간격을 주기 위해서...
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				
				int readBytes = fis.read(buffer,0,buffer.length);
				
				if(readBytes == -1) {
					break;
				}
				
				//읽어온 파일 내용 패킷에 담기
				dp = new DatagramPacket(buffer, readBytes,serverAddr,port);
				
				ds.send(dp);
				
				totalReadBytes += readBytes;
				System.out.println("In propress : "
						+totalReadBytes+"/"
						+fileSize+" Bytes ("
						+(totalReadBytes*100/fileSize)
						+"%)");
			}
			//파일을 다보냈다.
			
			
			double endTime = System.currentTimeMillis();
			double diffTime = (endTime-startTime)/1000;
			double transferSpeed = (fileSize/1000)/diffTime;
			
			System.out.println("걸린 시간: "+diffTime+" 초");
			System.out.println("평균전송속도 : "+transferSpeed+" KB/s");
			
			str = "end";//전송이 완료되었음을 알림.
			dp = new DatagramPacket(str.getBytes(),str.getBytes().length,serverAddr,port);
			ds.send(dp);
			
			
			
			System.out.println("전송완료...");
			
			fis.close();
			ds.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}



































