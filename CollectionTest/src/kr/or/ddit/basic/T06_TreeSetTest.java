package kr.or.ddit.basic;

import java.util.SortedSet;
import java.util.TreeSet;

public class T06_TreeSetTest {

	public static void main(String[] args) {
		//HashSet은 데이터에 순서가  없으나 
		//TreeSet은 자동정렬 기능이 있다
		TreeSet<String> ts = new TreeSet<>();
		
		//영어 대문자를 문자열로 변환하여 TreeSet에 저장
		for (char ch='Z' ; ch>='A';ch--) {//정렬되는지 그냥 볼려고 거꾸로 넣은것 의미는 없다
			String temp = String.valueOf(ch);
			ts.add(temp);
		}
		
		System.out.println("TreeSet 자료: "+ts);
		
		//TreeSet에 저장된 자료중 특정한 자료보다 작은 자료를 찾아서 SortedSet으로
		//반환하는 메서드이다 
		//=>headSet(기준값) : 기본적으로 기준값은 포함시키지 않는다
		//=>headSet(기준값,논리값) : 논리값이 true이면 기준값을 포함시킨다
		SortedSet<String> ss1=ts.headSet("K");
		System.out.println("K이전 자료: "+ss1); //기준값 미포함
		System.out.println("K이전자료(기준값포함) : "
				+ts.headSet("K",true));
		//기준값보다 큰자료를 찾아 SortedSet으로 반환하는 메서드 
		//tailSet(기준값) : 기본적으로 기준값을 포함시킨다 
		//tailSet(기준값,논리값) : 논리값이 false이면 기준값을 포함시키지않는다
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K 이후자료: "+ss2);
		System.out.println("K 이후자료(기준값 미포함): "
				+ts.tailSet("K", false));
		//subSet(기준값1,기준값2) : 기준값1~기준값2 사이의 값을 가져온다
		//=> 기준값1 포함 기준값2 미포함
		//subSet(기준값1,논리값1,기준값2,논리값2)
		//==>각 기준값을 초함할지 여부를 설정한다(논리값이 true이면 포함 false이면 미포함 )
		System.out.println("K(포함) 부터  N(미포함) 까지" 
				+ ts.subSet("K", "N"));
		System.out.println("K(포함) 부터  N(포함) 까지"
				+ts.subSet("K", true,"N", true));
		System.out.println("K(미포함) 부터  N(미포함 ) 까지"
				+ts.subSet("K", false,"N", false));
		System.out.println("K(미포함) 부터  N(포함) 까지"
				+ts.subSet("K", false,"N", true));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
