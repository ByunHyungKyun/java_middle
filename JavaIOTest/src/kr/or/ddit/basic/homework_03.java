package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class homework_03 {
	
	private Scanner scan;
	private static Map<String,Hotel>  hotel;
	
	public  homework_03(){
		scan =new Scanner(System.in);
		hotel =new HashMap<String,Hotel>();
	}

	public void Hotelhomwork() {
		file();
		ing();
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");

		while (true) {
			displayMenu();
			int menuNum = scan.nextInt();
			switch (menuNum) {

			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				search();
				break;
			case 4:
				exit();
				System.out.println("이용해주셔서 감사합니다");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시입력해주시요");

			}
		}
	}
	
	public void exit() {
		
		try {
			ObjectOutputStream hotel2 = new ObjectOutputStream(new FileOutputStream("d:/D_Other/hotel.bin"));
			
			hotel2.writeObject(hotel); 
			hotel2.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("이용해주셔서 감사합니다.");
		System.exit(0);
	}

	public static void  file() {
		File hotel = new File("d:/D_Other/hotel.bin");
		if (hotel.exists()) { 
			return;
		}else { 
			try {
				if(hotel.createNewFile()) {
					System.out.println(hotel.getAbsolutePath()+"파일을 새로 만들었습니다.");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void ing()  {
		try {
			ObjectInputStream hoteling = new ObjectInputStream(new FileInputStream("d:/D_Other/hotel.bin"));
			Object obj = null; 
			
			while((obj = hoteling.readObject()) != null) {
				// 마지막에 다다르면 EOF 예외 발생함.
				Map hotel2 = (Map) obj;
				hotel=hotel2;
			}
			hoteling.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	private void delete() {
		
		System.out.println();
		System.out.println("체크아웃할 객실방번호를 입력하시오");
		System.out.println("예; 101");
		System.out.print("방번호 >>");
		
		String num=scan.next();
		
		if(hotel.remove(num) == null) {
			System.out.println(num+"방번호는 체크인이 된 방이 아닙니다");
			return;
		}else {
			System.out.println(num+"방을 체크아웃하였습니다.");
		}
		System.out.println("체크아웃 작업 완료....");
	}

	private void search() {

		Set<String> keySet = hotel.keySet();

		System.out.println();
		System.out.println("==========================================");
		System.out.println("이름\t방번호");
		if (keySet.size() == 0) {
			System.out.println("예약되어있는 방이 없습니다");
		} else {
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				String num = it.next();
				Hotel h = hotel.get(num);
				System.out.println(h.getNum() + "\t" + h.getName());

			}
		}

		System.out.println("==========================================");
		System.out.println("출력완료..... ");
	}

	private void insert() {

		System.out.println();
		System.out.println("하루 머무를 객실방번호를 입력하시오");
		System.out.println("예; 101");
		System.out.print("방번호 >>");

		String num = scan.next();

		if (hotel.get(num) != null) {
			System.out.println(num + "번호는 이미 예약이 되어있습니다");
			return;
		}

		System.out.println("투숙객 이름 >>");
		scan.nextLine();
		String name = scan.nextLine();

		hotel.put(num, new Hotel(num, name));
		System.out.println(name + "님 예약을 완료하였습니다");
	}

	private void displayMenu() {
		System.out.println();
		System.out.println("메뉴를 선택하시오.");
		System.out.print("1.체크인\t");
		System.out.print("2.체크아웃\t");
		System.out.print("3.객실상태\t");
		System.out.print("4.업무종료\t");

	}

	public static void main(String[] args) {
		new homework_03().Hotelhomwork();
	}
}


class Hotel implements Serializable{
	private String name; //투숙객 이름
	private String num; //투숙객 방번호 
	public Hotel(String name, String num) {
		super();
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", num=" + num + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
	
}