package kr.or.ddit.basic;

import java.util.concurrent.ThreadFactory;

public class T13_ThreadStopTest {
/*
 * Thread의 stop()메서드를 호출하면 스레드가 바로 멈춘다 .
 * 이때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서 
 * 나중에 실행되는 프로그램에 영향을 줄수있다
 * 그래서 현재는 stop()메서드는 비추천(Deprecated)으로 되어있다
 */
	public static void main(String[] args) {
		
		ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		//th.stop(); 이건 자바에서 웬만하면 실행하지 말라는 뜻으로 줄이 그어진다.
		
		th.setStop(true); //우리가 만든 메서드를 실행시킨것
		//상태 플래그 값을 이용한 종료방법
		
		
		//interrupt()메서드를 이용한 스레드 멈추기
		ThreadStopEx2 th2 = new ThreadStopEx2();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		th2.interrupt();// 인터럽트 호출
	}
}

class ThreadStopEx1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("스레드 처리중...");
		}
		System.out.println("자원 정리 중 ...");
		System.out.println("실행 종료.");
		
	}
}


// interrupt()메서드를 이용하여 스레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread {
	
	@Override
	public void run() {
		/*
		 * 방법1 ==> sleep()메서드나 join()메서드 등을 사용했을 때 interrupt()메서드를
		 * 			호출하면 InterruptedException이 발생한다
		 */
		/*
		try {
			while(true) {
				System.out.println("스레드 처리중 ...");
				Thread.sleep(1);
			}
		} catch (InterruptedException ex) {} //인터럽트를 발생시켜서 예외처리하게 한다, 그래서 while문을 빠져나오게 된다
		*/
		
		//방법2 = > interrupt()메서드가 호출되었는지 검사하기 
		while(true) {
			System.out.println("스레드 처리중...");
			
			
			
			//검사 방법1 => 스레드의 인스턴스 객체용 메서드를 이용하는 방법
			/*if(this.isInterrupted()) {//interrupt()메서드가 호출되면 true
				System.out.println("인스턴스용 isInterrupted()");
				break;
			}*/
			
			//검사방법2 = > 스레드의 정적 메서드를 이용하는 방법,누구나 호출할수있는 메서드 스태틱메서드이다.왜냐하면 2번호출하면 안되기 때문에
			//상태값을 갖고오면 바뀌기 때문에 2번 호출하면 계속 false이다. 
			if(Thread.interrupted()){//interrupted()가 호출되면 true 
				System.out.println("정적 메서드 interrupted()");
				break;
			}
		}
		
		System.out.println("자원 처리중 ...");
		System.out.println("실행 종료.");
	}
}




















































































