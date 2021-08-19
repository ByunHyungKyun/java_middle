package kr.or.ddit.basic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadHomeWork {
	static int realRank = 0;
	public static void main(String[] args) {
		Horse[] horse = new Horse[] {
				
				new Horse("1번말"),
				new Horse("2번말"),
				new Horse("3번말"),
				new Horse("4번말"),
				new Horse("5번말"),
				new Horse("6번말"),
				new Horse("7번말"),
				new Horse("8번말"),
				new Horse("9번말"),
				new Horse("10번말")
		};
		
		
		Runnig runnig = new Runnig(horse);
		
		for (int i = 0; i < horse.length; i++) {
			horse[i].start();
		}
		
		runnig.start();
		
		for (Horse horse2 : horse) {
			try {
				horse2.join();
				runnig.join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("경기 끝...");
		System.out.println("------------------------");
		System.out.println();
		
		Arrays.sort(horse);
		
		System.out.println("-------------경기 결과-------------");
		for (Horse horse2 : horse) {
			System.out.println(horse2.getRank()+"등! "+horse2.getHname());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String hname; //말 이름 
	private int rank;//말 등수 
	private int jone;//말 현재 위치
	
	
	public Horse (String hname) {
		this.hname = hname;
		
	}

	public String getHname() {
		return hname;
	}


	public void setHname(String hname) {
		this.hname = hname;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}



	public int getJone() {
		return jone;
	}


	public void setJone(int jone) {
		this.jone = jone;
	}


	@Override
	public int compareTo(Horse rank) {
		
		return  new Integer(this.getRank()).compareTo(rank.getRank());
	}
	
	
	@Override
	public void run() {
		
		for (int i = 1; i <=50; i++) {
			jone = i;
			try {
				Thread.sleep((int)(Math.random()*300+200));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(getName()+"도착!!!");
		ThreadHomeWork.realRank++;
		rank = ThreadHomeWork.realRank;
	}
}


class Runnig  extends Thread {
	private Horse[] horse ;
	
	public Runnig (Horse[] horse) {
		this.horse = horse;
	}
	
	
	
	@Override
	public void run() {
		while(ThreadHomeWork.realRank != 10) {
			System.out.println("");
			System.out.println("");
			for (int i = 0; i < 10; i++) {
				System.out.println(horse[i].getName()+" : ");
				for (int j = 1; j <=50; j++) {
					if( horse[i].getJone()==j) {
						System.out.print(">>");
					}else {
						System.out.print("-");
						
					}
				}
			}
		}
	}
}































