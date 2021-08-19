package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONSimpleReadTest {

	public static void main(String[] args) throws IOException, ParseException {
		
		FileReader fr = new FileReader("d:/D_Other/myJsonFile.txt");
		
		JSONParser parser = new JSONParser(); //JSON형식을 읽을려면 parser을 써야한다
		
		Object obj = parser.parse(fr); //parse가 파라미터로 FileReader객체형식을 원하기 때문에 위에서 FileReader를 만들었다.
		
		JSONObject jsonFile = (JSONObject) obj;
		
		String name = (String)jsonFile.get("name");
		String job = (String)jsonFile.get("job");
		long age = (long) jsonFile.get("age"); //number를 받기 위long으로 처리해야한다 
		String addr = (String) jsonFile.get("addr");
		
		System.out.println("name : "+name);
		System.out.println("job : "+job);
		System.out.println("age : "+age);
		System.out.println("addr : "+addr);
		
		JSONArray list = (JSONArray) jsonFile.get("singerList");
		
		Iterator<JSONObject> it = list.iterator();
		
		JSONObject singer;
		while(it.hasNext()) {
			singer = it.next();
			System.out.printf("이름 : %s, \t성별: %s, \t나이: %d\n" 
						,singer.get("name")
						,singer.get("gender")
						,singer.get("age"));
		}
	}
}



















































