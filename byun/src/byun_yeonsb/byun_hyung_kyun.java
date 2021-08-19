package byun_yeonsb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class byun_hyung_kyun {

	public static void main(String[] args) {
		
		
		
		List<Student> stuList = new ArrayList<>();
		/*
		stuList.add(new Student(8,"박명수",98,54,34));
		stuList.add(new Student(9,"유재석",96,58,54));
		stuList.add(new Student(2,"정형돈",48,32,98));
		stuList.add(new Student(4,"하하",54,41,98));
		stuList.add(new Student(3,"노홍철",78,63,54));
		stuList.add(new Student(1,"조세호",86,13,46));
		stuList.add(new Student(5,"양세형",68,96,32));
		*/
		stuList.add(new Student(8,"박명수",getkor(),geteng(),getmath()));
		stuList.add(new Student(9,"유재석",getkor(),geteng(),getmath()));
		stuList.add(new Student(2,"정형돈",getkor(),geteng(),getmath()));
		stuList.add(new Student(4,"하하",getkor(),geteng(),getmath()));
		stuList.add(new Student(3,"노홍철",getkor(),geteng(),getmath()));
		stuList.add(new Student(1,"조세호",getkor(),geteng(),getmath()));
		stuList.add(new Student(5,"양세형",getkor(),geteng(),getmath()));
		
		
		System.out.println("정렬전-------------------------");
		for (Student student : stuList) {
			System.out.println(student);
		}
		System.out.println("=============================================");
		
		
		Collections.sort(stuList);
		
		System.out.println("학번 오름차순-------------------------");
		for (Student student : stuList) {
			System.out.println(student);
		}
		System.out.println("=============================================");
		
		
		System.out.println("점수합산");
		for (Student student : stuList) {
			int a = student.getEng()+student.getKor()+student.getMath();
			student.setSum(a);
		}
		
		for (Student student : stuList) {
			System.out.println(student);
		}
		System.out.println("=============================================");
		
		
		Collections.sort(stuList, new SortRankDesc());
		
		System.out.println("등수대로 정렬");
		int i =1;
		for (Student student : stuList) {
			student.setRank(i);
			System.out.println(student);
			i++;
		}
		System.out.println("=============================================");
		
		
		
	}

	public static int getkor() {
		
		
		return (int)(Math.random()*100)+1;
	}

	public static int geteng() {
		
		
		return (int)(Math.random()*100)+1;
	}

	
	public static int getmath() {
		
		
		return (int)(Math.random()*100)+1;
	}

	
}



class SortRankDesc implements Comparator<Student> {

	@Override
	public int compare(Student rank1, Student rank2) {

		if(rank1.getSum() == rank2.getSum()) {
			return  new Integer(rank1.getNum()).compareTo(rank2.getNum())*-1;
		}

		return new Integer(rank1.getSum()).compareTo(rank2.getSum()) * -1;
	}

}

class Student implements Comparable<Student>{
	private int  num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;

	public Student(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [학번=" + num + ", 이름=" + name + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math + ", 총점="
				+ sum + ", 등수=" + rank + "]";
	}

	@Override
	public int compareTo(Student stu) {

		return new Integer(this.getNum()).compareTo(stu.getNum());
	}
}