package Enum;

import javax.swing.Painter;



public class T04_GenericMethodTest {
	public static void main(String[] args) {

		Pair<Integer,String> p1 =new Pair<>(1,"홍길동");
		Pair<Integer,String> p2 =new Pair<Integer,String>(1,"홍길동");
		
		//구체적 타입을 명시적으로 지정(생량가능)
		boolean result1=Util.<Integer,String>compare(p1,p2);
		
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임");//둘다 같아서 동일하다고 나온다
		}else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님");
		}
		
		Pair<String,String> p3= new Pair<String,String>("001","홀길동");
		Pair<String,String> p4= new Pair<String,String>("002","홀길동");
		
		boolean result2 = Util.compare(p3, p4); //<String,String>이 생략되어 있다.
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
			
		}else {
			System.out.println("논리(의미)적으로 동일한 객체가 아님");//키값이 달라서 false가 나온다	
		}
		
		//제네릭 메서드 테스트
		p1.<String,Integer>displarAll("키", 180);
	}
}



class Util{
	/*
	 * 제네릭 메서드<T,R> R method(T t)
	 * 
	 * 파라키너 타입과 리턴타입으로 타입 파라미터를 가지는 메서드
	 * 
	 * 선언방법 : 리턴 타입 앞에 <> 기호를 추가하고 타입 문자를 기술후 사용함 
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 * 
	 */
	
public static <K,V> boolean compare(Pair<K,V>p1,Pair<K,V>p2) {
		boolean keyCompare =p1.getKey().equals(p2.getKey());
		boolean valueCompare =p1.getKey().equals(p2.getKey());
		
		return keyCompare && valueCompare;
	}
}

/*
 * 멀티타입<K, V>을 가지는 제너릭 클래스 
 * @param<K>
 * @param<V>
 */


class Pair<K,V> {
	private K key;
	private V value;
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

	
	// 키와 값을 모두 출력
public <K, V> void displarAll(K key, V val) {
		System.out.println(key + " : " + val.toString());
	}

}


























































