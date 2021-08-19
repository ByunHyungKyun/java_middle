package byun_yeonsb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class homework {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		while(true){
			System.out.println("==========================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("==========================");
			System.out.print("메뉴선택 :");
			int input = sc.nextInt();
			System.out.println("");
		switch(input){
		case 1:
			System.out.println("Lotto 구입 시작");
			System.out.println("(1000원에 로또번호 하나입니다.)");
			System.out.print("금액 입력 :");
			int money = sc.nextInt();
			
			int mon=money/1000;
			int na=money%1000;
			System.out.println("");
			if(1<=mon) {
				for(int i=0;i<mon;i++){
					HashSet<Integer> intRnd = new HashSet<Integer>();	
					while (intRnd.size() < 6) {
						int num = (int) (Math.random() * 45 + 1);
						intRnd.add(num);
					}
					System.out.println("로또번호"+(i+1)+" : " + intRnd);
				}
				System.out.println("");
				System.out.println("받은 금액은 "+money+"원이고 거스름돈은 "+na+"원입니다.");
				break;
			}else {
				System.out.println("금액이 부족합니다");
				System.out.println("금액을 다시 입력해주세요");
				break;
			}
		case 2:
		System.out.println("프로그램을 종료합니다");
		System.exit(2);
		break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
