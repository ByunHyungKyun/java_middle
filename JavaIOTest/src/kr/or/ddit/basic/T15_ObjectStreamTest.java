package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

/*
 * 객체 입출력 보조 스트림 예제(직렬화와 역직렬화)
 */
public class T15_ObjectStreamTest {
	public static void main(String[] args) {
		
		//Member 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("일지매", 30, "경기");
		Member mem3 = new Member("이몽룡", 40, "강원");
		Member mem4 = new Member("성춘향", 50, "광주");
		
		try {
			//객체를 파일에 저장하기
			
			//출력용 스트림 객체 생성
			ObjectOutputStream oos = 
					new ObjectOutputStream(
							new BufferedOutputStream(//이건 보조 스트림,이건 없어도 기능을 하지만 버퍼기능을 추가해 준것이다
									new FileOutputStream("d:/D_Other/memobj.bin")));
			
			//쓰기 작업
			oos.writeObject(mem1);//직렬화
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			System.out.println("쓰기 작업완료");
			oos.close();
			
			//==========================================================================
			//저장한 객체를 읽어와 출력하기
			
			//입력용 스트림 객체 생성
			ObjectInputStream ois = 
					new ObjectInputStream(
							new BufferedInputStream(
									new FileInputStream("d:/D_Other/memobj.bin")));
			Object obj = null;
			
			try {
				while((obj = ois.readObject()) != null) {//역직렬화 ,readObject실행하는 순간 역직렬화가 시작한다 
					//마지막에 다다르면 EOF 예외 발생함
					Member mem= (Member) obj;
					System.out.println("이름 : "+mem.getName());
					System.out.println("나이 : "+mem.getAge());
					System.out.println("주소 : "+mem.getAddr());
					System.out.println("-------------------------");
				}
				ois.close();	
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
			//더이상 읽어올 객체가 없으면 예외발생함.
			System.out.println("출력 작업 끝...");
		}
	}
}



/*
 * 회원정보VO
 */
class Member implements Serializable { //타입이 바뀌는 것이다,따로 기능을 하지않는다,들어가서 보면 아무것도 없다
	//자바는 Serializable 인터페이스를 구현한 클래스만 직렬화 할수 있도록 제한하고 있음
	//구현 안하면 직렬화작업시 java.io.NotSerializableExecption 예외발생!!
	
	/*
	 * transient => 직렬화가 되지 않을 멤버 변수에 지정한다
	 * 				(static 필드도 직렬화가 되지 않는다)
	 * 				직렬화가 되지 않는 멤버 변수는 기본값으로 저장된다
	 * 				(참조형 변수 : null, 숫자형 변수 : 0)
	 */
	
	private  String name;
	private transient int age; //나이는 변하기 때문에 transient을 이용해주는데 위에 나온것처럼 적렬화 안한다
	private String addr;
	
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}




































