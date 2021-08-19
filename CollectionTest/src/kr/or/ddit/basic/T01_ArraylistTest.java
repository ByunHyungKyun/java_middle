package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01_ArraylistTest {
	public static void main(String[] args) {
		// Arraylist는 기본적인 사용법이 vector와 같다
		//DEFUALT_CAPACITY =10
		List list1 = new ArrayList();
		
		//add()메서드를 사용하여 더이터를 추가한다 
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		//size()=>데이터의 개수 
		System.out.println("size => "+list1.size());
		System.out.println("list1 =>" + list1);
		
		//get으로 데이터 꺼내오기 
		System.out.println("1번째 자료 : "+list1.get(1));
		
		//데이터 끼워넣기도 같다 
		list1.add(0,"zzz");
		System.out.println("list1 => "+list1);
		
		//데이터 변경하기 (set에서드 )
		String temp = (String) list1.set(0, "yyy");//변경하기 전값이 temp에 들어가게된다;set이 리턴값을 주기 때문에
		System.out.println("temp => "+temp);
		System.out.println("list1 => "+list1);
		
		//삭제하기 
		list1.remove(0);
		System.out.println("삭제 후 : "+list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제후 "+list1);
		System.out.println("==============================");
		
		//제너릭을 지정하여 선언할수있다 : 특정한 타입을 지정하는것이다 
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for (int i= 0 ; i<list2.size(); i++) {
			System.out.println(i+" : "+list2.get(i));
		}
		System.out.println("------------------------------------");
		for (String s : list2) {
			System.out.println(s);
		}
		System.out.println("------------------------------------");
		
		//contrains(비교객체): => 리스트에 '비교객체'가 있으면 true 없으면 false 리턴함 
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		System.out.println("------------------------------------");
		
		//toArray() : 리스트 안의 데이터를 배열로 변환하여 반환한다 
		//기본적으로 Object형 배열로 변환한다 
		Object[] strArr =list2.toArray();
		System.out.println("배열의 갯수 : "+strArr.length);
		
		//리스트의 제네릭타입에 맞는 자료형의 배열로 변환하는 방법
		//제네릭타입의 0개짜리 배열을 생서앟여 매개변수로 넣어준다 
		//=>배열의 크기가 리스트 크기보다 작으면 리스트의 크기에 맞는 배열을 넣어준다 
		String[] strArr2 = list2.toArray(new String[0]);
		System.out.println("strArr2의 개수"+strArr.length);
		
		//배열안에 있는 값을 지울때 잘못된 예 
		for (int i = 0; i < list2.size(); i++) {
			list2.remove(i);
		}
		System.out.println(list2.size());
		
		//배열안에 있는 값을 지울때 좋은 예
		for (int i = list2.size()-1; i >=0; i--) {
			list2.remove(i);
		}
		System.out.println(list2.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
