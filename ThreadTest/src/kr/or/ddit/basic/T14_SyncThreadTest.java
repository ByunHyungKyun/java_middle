package kr.or.ddit.basic;

public class T14_SyncThreadTest {
	public static void main(String[] args) {
	
		ShareObject sObj = new ShareObject();
		
		WorkerThread th1 = new WorkerThread("1번스레드", sObj);
		WorkerThread th2 = new WorkerThread("2번스레드", sObj);
		
		th1.start();
		th2.start();
		
	}
}

//공통으로 사용할 객체
class ShareObject {
	private int sum = 0;
	
	//동기화 하는 방법1 : 메서드 자체에 동기화 처리하기
	//여기가 크리티컬섹션이 뜨는 메서드이다. 결과값이겹치게 나오는곳
	//public synchronized void add() {//synchronized를 붙여주면 동기화가 자동으로 된다
	  public synchronized void add() {
		  //동기화 하는 방법2 : 동기화 블럭으로 설정하기
		  synchronized (this) { //공유하는 객체를 알려주는 건데 지금 여기서는 쉐어객체 곧 자신을 알려줘야하기 때문에 this를 썼다.
		for (int i = 0; i <1000000000; i++) {} //동기화처리 전까지의 시간벌기용
			int n = sum;
			n += 10; //10증가
			sum = n;
			
		System.out.println(Thread.currentThread().getName()+"합계: "+sum); //현재 쓰레드 객체의 이름을 가지고 온다
		  }
	}
	
	
	public int getSum() {
		return sum;
	}
}


//작업을 수행하는 스레드 클래스 
class WorkerThread extends Thread {
	ShareObject sObj;
	
	public WorkerThread (String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();
		}
	}
}































































































