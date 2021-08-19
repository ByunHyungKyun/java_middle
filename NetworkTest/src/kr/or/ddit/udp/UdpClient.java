package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class UdpClient {
	public void start() throws SocketException, IOException {
		
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		//데이터가 저장될 공간으로 byte배열을 생성한다(패킷 수신용)
		//패킷이 원하는 속성은 배열이기 때문에 배열로 만들어서 보내야 한다.
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg,1,serverAddress,8888); 
		//상대방에게 포트번호와 아이피를 알려줄려고 1byte 의미없는거하나보낸다
		
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.send(outPacket);//전송
		datagramSocket.receive(inPacket); //수신 서버시간을 받기위해
		
		System.out.println("현재 서버 시간 => "
					+new String(inPacket.getData()));
		//getData()는 바이트배열로 반환해주는데 String클래스에 배열을 문자열로 바꿔주는 메서드가있다.
		
		datagramSocket.close();//소켓 종료
	}
	
	public static void main(String[] args) throws SocketException, IOException {
		new UdpClient().start();
	}
}
