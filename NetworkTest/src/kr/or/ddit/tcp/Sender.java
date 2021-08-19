package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/*
 * 소켓을 통해서 메세지를 보내는 역할을 담당한다.
 */
public class Sender extends Thread{
	private Scanner scan;
	private String name;
	private DataOutputStream dos;
	
	public Sender(Socket socket) {
		name = "[" + socket.getInetAddress()+" : "+socket.getLocalPort()+"]";
		scan = new Scanner(System.in);
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		while(dos != null) {//객체는 이미 위에 만들어졌기 때문에 무한루프ture를 쓴것처럼 돈다
			try {//무한루프를 하는이유는 계속 대화를 하기위해
				dos.writeUTF(name+" >>> "+scan.nextLine());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
