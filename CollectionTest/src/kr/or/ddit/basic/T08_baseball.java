package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class T08_baseball {

	public static void main(String[] args) {

		HashSet<Integer> intRnd = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		int count = 0;

		while (intRnd.size() < 3) {// 데이터가 3개가 될때 까지 반복
			int num = (int) (Math.random() * 9 + 1);
			intRnd.add(num);
		}
		System.out.println("만들어진 난수들 : " + intRnd);
		
		List<Integer> intRndList = new ArrayList<Integer>(intRnd);
		Collections.shuffle(intRndList);
		
		int s1=intRndList.get(0);
		int s2=intRndList.get(1);
		int s3=intRndList.get(2);
		
		System.out.println("섞은 숫자 : "+s1+", "+s2+", "+s3);
		
		do {
			System.out.println("3자리 숫자를 입력하시오");
			System.out.println("첫번째 숫자 :  ");
			a = Integer.parseInt(sc.nextLine());
			System.out.println(" ");
			System.out.println("두번째 숫자 :  ");
			b = Integer.parseInt(sc.nextLine());
			System.out.println(" ");
			System.out.println("세번째 숫자 :  ");
			c = Integer.parseInt(sc.nextLine());
			System.out.println(" ");

			count++;

			int st = 0;
			int ba = 0;
			int ou = 0;

			if (a == s1) {st += 1;} 
			else if (a == s2) {ba += 1;} 
			else if (a == s3) {ba += 1;} 
			else {ou += 1;}
			
			if (b == s1) {ba += 1;} 
			else if (b == s2) {st += 1;} 
			else if (b == s3) {ba += 1;} 
			else {ou += 1;}
			
			if (c == s1) {ba += 1;} 
			else if (c == s2) {ba += 1;} 
			else if (c == s3) {st += 1;} 
			else {ou += 1;}

			System.out.println("입력하신 숫자=" + a + "와 " + b + "와 " + c + "의 결과는 "
					+ st + "S," + ba + "B," + ou + "O 입니다");
			System.out.println("");
			
		}while (a != s1 || b != s2 || c != s3);
		System.out.println("---------------------------------------------------");
		System.out.println("정답입니다^^ " + "총 시도 횟수는 " + count + "번입니다! "+ "당신의승리!");

		
	}
}
