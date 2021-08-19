package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class T12_homework {
	
	
	private Scanner scan;
	private Map<String,Hotel>  hotel;
	
	public  T12_homework(){
		scan =new Scanner(System.in);
		hotel =new HashMap<String,Hotel>();
	}

	public void Hotelhomwork() {
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
				System.out.println("이용해주셔서 감사합니다");
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시입력해주시요");

			}
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
		System.out.println("방번호\t이름");
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

		new T12_homework().Hotelhomwork();
	}

}

class Hotel{
	private String name; //투숙객 이름
	private String num; //투숙객 방번호 
	public Hotel(String name, String num) {
		super();
		this.name = name;
		this.num = num;
	}
	@Override
	public String toString() {
		return "Hotel [투숙객=" + name + ", 방번호=" + num + "]";
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