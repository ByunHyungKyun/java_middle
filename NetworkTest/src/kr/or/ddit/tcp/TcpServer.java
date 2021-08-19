package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		
		
		//TCP 소켓 통신을 하기 위해  ServerSocket객체 생성
		ServerSocket server = new ServerSocket(7777); //서버포트를 넣는곳(1~1024까지는 예약이 되어있는 서버이다.그이후의 번호를 입력)
		System.out.println("서버가 접속을 기다립니다");
		
		//accept()메서드는 client에서 연결 요청이 올때 까지 계속 기다린다
		//연결 요청이 오면 Socket객체를 생성해서 Client의 Socket과 연결한다
		Socket socket = server.accept(); //연결이 되어야 객체가 만들어지는거 기억해라!!
		//accept()로 인해 연결이 올때까지 block이되어 스레드가 꺼지지않는다
		
		
		
		//이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : "+socket.getInetAddress());
		
		//client에 메세지 보내기
		
		//OutputStream객체를 구성하여 전송한다 
		//접속한 Sockwt의 getOutputStream()메서드를 이용하여 구한다
		OutputStream out = socket.getOutputStream();//상대방한테 정보를 보내는 메서드
		
		DataOutputStream dos = new DataOutputStream(out);//기본타입을 위해 DATA보조스트림을 쓰는것이다
		dos.writeUTF("어서 오세요...");//메세지 보내기  //DATA보조스트림을 써야 writeUTF()을 쓸수있다
		System.out.println("메제시를 보냈습니다");
		
		dos.close();
		
		server.close();
		
		
	}
}
