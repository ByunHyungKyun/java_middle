package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T09_MapTest {

	public static void main(String[] args) {
		
		/*
		 * Map => key값과 value값을 한 쌍으로 관리하는 객체
		 * => key값은 중복을 허용하지 않고 순서가 없다 (set의 특징)
		 * => value값은 중복을 허용한다 
		 */
		
		Map<String , String> map = new HashMap<String,String>();
		
		//자료 추가 --> put(key값,value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-1234");
		
		System.out.println("map=> "+map);
		
		//자료수정 => 데이터를 저장할때 key값이 같으면 나중에 입력한 값이 저장된다 
		//=>put(수정할 key값,새로운value값)
		map.put("addr","서울");
		System.out.println("map=> "+map);
		
		//지료삭제 => remove(삭제할 key값)
		map.remove("name");
		System.out.println("map=> "+map);
		
		//자료읽기 => get(key값)
		System.out.println("addr = "+map.get("addr"));
		System.out.println("=====================================================");
		
		
		
		//key값들을 읽어와 자료를 출력하는 방법
		
		//방법1=>keySet()메서드 이용하기 
		//ketSet()메서드=>Map의key값들만 읽어와 set형으로 변환한다 
		Set<String> keySet = map.keySet();
		
		System.out.println("Iterator를 이용한 방법");
		
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key=it.next();
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("--------------------------------------------------");
		
		//방법2=> set형의 데이터를 향상된 for문 으로 처리해도 된다 
		System.out.println("향상된 for문을 이용한 방법");
		for (String key : keySet) {
			System.out.println(key+" : "+map.get(key));
		}
		System.out.println("--------------------------------------------------");
		
		//방법3=>  value값만 읽어와 출력하기 => values()메서드 이용하기 
		System.out.println("value()메서드 이용한 방법");
		for (String vlaue : map.values()) {
			System.out.println(vlaue);
		}
		System.out.println("--------------------------------------------------");
		
		//방법4 => map에는 entry하는 내부 class가 만들어져 있다
		//이entry클래스는 key와 value라는 멤버변수로 구성되어 있다 
		//map에서 이 entry클래스들을 set형식으로 저장하여 관리한다 
		
		//entry객체 전체를 가져오기(가져온 entry들은 set형식으로 되어 있다)
		//=>entryset()메서드를 이용하여 가져온다 
		Set<Map.Entry<String, String>> mapSet=map.entrySet();
		
		//가져온 entry객체들을 순서대로 처리하기 위해서 Iterator객체로 변환 
		Iterator<Map.Entry<String,String>> entryIt =mapSet.iterator();
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key값 : "+entry.getKey());
			System.out.println("value값: "+entry.getValue());
			System.out.println();
		}
		
		
	
		
		
		
		
		
		
		
		
		
		
		

	}

}
