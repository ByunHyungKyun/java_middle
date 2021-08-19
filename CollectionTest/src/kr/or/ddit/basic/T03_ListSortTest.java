package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03_ListSortTest {
	public static void main(String[] args) {
		
		/*
		 * 정렬과 관련된 interface에는 comparable과 comparator 이렇게 2개가 있다 
		 * 
		 * 보통 객체 자체에 정렬기능을 넣기 위해서는 comparable을 구현하고 
		 * 정렬기준을 별도로 구현하고 싶은 경우에는 comparator를 구현하여 사용하면 된다
		 * 
		 * comparable은 compareto()메서드를 구현하고 
		 * comparator에서는 compare()메서드를 구현한다 
		 */
		
		List<String> list = new ArrayList<>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전: "+list);
		
		//정렬은 collections.sort() 메서드를 이용하여 정렬한다 
		//정렬은 기본적으로 '오른차순 정렬'을 수행한다 
		
		//정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서 
		//collections.sort()메서드에 인수로 넘겨주면 된다 
		
		Collections.sort(list); //오름차순 정렬
		System.out.println("정렬후: "+list);
		
		Collections.shuffle(list); //데이터를 섞어준다 
		System.out.println("자료 섞기 후: "+list);
		
		// 정렬방식을 결정하는 객체를 이용하여 정렬하기 --내림차순
		Collections.sort(list,new Desc());
		System.out.println("정렬후 : "+list);
		
		
	}

}

/**
 * 
 * 정렬방식을 결정하는 calss는 comparator라는 인터페이스를 구현해야 한다 
 * 이 comparator인터페이스는 compare()라는 메서드를 재정의 하여 구현한다 
 *
 */
class Desc implements Comparator<String>{
	/**
	 * compare()메서드의 반환값을 결정하는 방법
	 * ==> 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다(오름차순이 기본임)
	 * 
	 * -오름차순 정렬일 경우 
	 * ==> 앞의 값이 크면 양수, 같은면 0 , 앞의 값이 작으면 음수를 반환하도록 한다 
	 * 
	 * -String객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데 
	 * 이메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다 
	 * (Wrapper클래스와 Date,File클래스에도 구현되어있다 )
	 */
	public int compare(String str1, String str2) {
		return str1.compareTo(str2)*-1;
	}
}

