package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오
 * 
 * 컴퓨터의 가위 바위 보는 난수를 이용하여 구하고 ,
 * 사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다
 * 
 *  입력시간은 5초로 제한하고 카운트 다운을 진행한다
 *  5초안에 입력이 없으면 게임을 진것으로 처리한다
 *  
 *  5초안에 입력이 완료되면 승패를 출력한다
 *  
 *  결과예시)
 *  === 결과 ===
 *  컴 퓨  터 :	가위
 *  당	신 :	바위 
 *  결	과 :	당신이 이겼습니다
 */
public class T07_ThreadGame {
	public static boolean inputCheck = false;
	public static boolean inputCheck2 = false;
	
	public static void main(String[] args) {
		
		
		Thread th1 = new Data();
		Thread th2 = new Count();
		
		th1.start();
		th2.start();
	}
}

class Data extends Thread {
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("5초안에 가위,바위,보 중 하나를 입력하시오 ");
		
		T07_ThreadGame.inputCheck = true;
		int a = (int)((Math.random()*3)+1);
		if(T07_ThreadGame.inputCheck2 == true) {
			return;
		}
		
		switch (str) {
		
		case "가위":
			if(a==1) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	가위");
				System.out.println("당	신 :	가위 ");
				System.out.println("결	과 :	비겼습니다");
			}else if(a==2) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	바위");
				System.out.println("당	신 :	가위 ");
				System.out.println("결	과 : 당신이 졌습니다");
			}else {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	보");
				System.out.println("당	신 :	가위 ");
				System.out.println("결	과 :	당신이 이겼습니다");
			}
			
			break;
		case "바위":
			if(a==1) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	가위");
				System.out.println("당	신 :	바위 ");
				System.out.println("결	과 :	당신이 이겼습니다");
			}else if(a==2) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	바위");
				System.out.println("당	신 :	바위 ");
				System.out.println("결	과 :	비겼습니다");
			}else {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	보");
				System.out.println("당	신 :	바위");
				System.out.println("결	과 :	당신이 졌습니다");
			}
			
			break;
		case "보":
			if(a==1) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	가위");
				System.out.println("당	신 :	보");
				System.out.println("결	과 :	당신이 졌습니다");
			}else if(a==2) {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	바위");
				System.out.println("당	신 :	보");
				System.out.println("결	과 :	당신이 이겼습니다");
			}else {
				System.out.println("=== 결과 ===");
				System.out.println("컴 퓨  터 :	보");
				System.out.println("당	신 :	보 ");
				System.out.println("결	과 :	비겼습니다");
			}
			
			break;
		
			default : 
				System.out.println("잘못입력하셨습니다");
				break;
		}
	}
}


class Count extends Thread {
	@Override
	public void run() {
		for(int i = 5; i>=1;i--) {
			
			if(T07_ThreadGame.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(0); //프로그램을 종료시키는 명령
		System.out.println("5초가 지났습니다.당신의 패배");
		T07_ThreadGame.inputCheck2 = true;
	}
}

