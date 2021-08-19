package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "127.0.0.1";
		//자기 자신 컴퓨터를 나타내는 방법
		//Ip : 127.0.0.1
		//컴이름 : localhost
		
		System.out.println(serverIp + " 서버에 접속중 입니다");
		
		//소켓을 생성해서 서버에 연결을 요청한다 
		Socket socket = new Socket(serverIp,7777);//소켓생성과 서버를 연결하는 과정이 다 담겨있다
		//서버와 클라이언트의 객체가 각각 만들어질때까지 기다린다
		
		
		//연결이 되면 이후의 명령이 실행된다
		System.out.println("연결 되었습니다");
		
		//서버에서 보내온 메세지 받기 
		//메세지를 받기 위해 InputStream객체를 생성한다
		//Socket의 getInputStream()메서드를 이용
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		//서버로부터 받은 메세지 출력하기
		System.out.println("받은 메세지: "+dis.readUTF());
		//정규 UTF파일이 아닌 자체 UTF파일이라 보낼떄 writeUTF로 보냈음으로 읽을때도 .readUTF로 받아야 글씨가안꺠진다
		//정규UFT로 받으면 글씨가 깨진다
		
		System.out.println("연결종료.");
		
		dis.close();
		
	}
}
