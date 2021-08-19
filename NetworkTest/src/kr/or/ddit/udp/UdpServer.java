package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	private DatagramSocket socket;
	
	public void start() throws IOException {
		
		//포트 8888번을 사용하는 소켓을 생성한다.
		socket = new DatagramSocket(8888);
		
		//패킷 송수신을 위한 객체 변수 선언
		DatagramPacket inPacket, outPacket; //패킷을 쓸려면 배열을 선언해줘서 보내야한다
		
		byte[] inMsg = new byte[1];//패킷 수신용 바이트 데이터를 담기위해 공간을 1byte만 만들었기 떄문에 배열 길이도 1이다
		byte[] outMsg;			   //패킷 송신용
		
		while(true) {
			//데이터를 수신하기 위한 패킷을 생성한다
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			System.out.println("패킷 수신 대기중 ...");
			
			//패킷을 통해 데이터를 수신(receive)한다
			socket.receive(inPacket); //이부분이 블락된다 상대방이 데이터를 던져주면 완료가 된다.
			//상대방은 리시브를 하든안하든 던지기 떄문에 받을준비를 여기서 해야한다
			//클라이언트와 연결을 하는것은 아니다.마냥 기다리는 느낌이다.
			
			System.out.println("패킷 수신 완료.");
			
			//수신한 패킷으로 부터 client의 IP주소와 Port번호를 얻어온다.
			InetAddress addr = inPacket.getAddress();
			int port = inPacket.getPort();
			
			//서버의 현재 시간을 시분초 형태([hh:mm:ss])로 반환한다
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			
			//시간 문자열을 byte배열로 변환한다
			outMsg = time.getBytes();
			
			//패킷을 생성해서 client에게 전송(send)한다
			outPacket = new DatagramPacket(outMsg, outMsg.length,addr,port);
			socket.send(outPacket);//파일을 보내는 부분
		}
	}
	
	public static void main(String[] args) throws IOException {
		new UdpServer().start();
	}
}














