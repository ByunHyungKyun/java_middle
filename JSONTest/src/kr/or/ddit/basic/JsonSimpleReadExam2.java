package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 공공데이터 포털의 OPEN API 예제
 * (레시피 재료정보 가져오는 예제)
 * @author macween
 *
 */
public class JsonSimpleReadExam2 {
	private String svcKey = "Grid_20150407000000000218_1";  // 레시피 재료 정보 조회 서비스
	private String apiKey = "1fc477dccec4734d38340344f68683adab4e2f5090e63c373f42961fa5533265"; // 개인별 발급.
	private String startIdx = "1";  	// 레시피 재료 시작 순번
	private String endIdx = "5";		// 레시피 재료 종료 순번
	private String recipeId = "300";	// 래시피가 궁금한 음식 ID

	
	/**
	 * JSON
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private JSONObject getJSONObject() throws IOException, ParseException {
		URL url = new URL("http://211.237.50.150:7080/openapi/"+ apiKey
				+ "/json/"+ svcKey + "/"+startIdx +"/" + endIdx
				+"?AREA=%EC%B6%A9%EC%B2%AD");
		URLConnection urlConnection = url.openConnection();

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new InputStreamReader(urlConnection.getInputStream()));

		return (JSONObject)obj;
	}

	/**
	 * 시작
	 * @throws IOException
	 * @throws ParseException
	 */
	public void start() throws IOException, ParseException {


		JSONObject jsonfile = getJSONObject();

		JSONObject rootObj = (JSONObject) jsonfile.get(svcKey);

		long totalCnt = (long)rootObj.get("totalCnt"); // 전체 레시피 재료 수

		endIdx = totalCnt + ""; // 레시피 재료 마지막 순번 설정
		//-----------------------------------------------------------------------
		// 구해온 전체 재료수를 이용하여 다시 요청함.


		jsonfile = getJSONObject();

		rootObj = (JSONObject) jsonfile.get(svcKey);

		JSONObject result = (JSONObject)rootObj.get("result");
		String code = (String)result.get("code");

		if(code.equals("INFO-000")) { // 정상 상태이면...

			JSONArray list = (JSONArray)rootObj.get("row");

//			for(Object tempObj : list) {
//
//				JSONObject tempJson = (JSONObject) tempObj;
//
//				System.out.println("순번 : " + tempJson.get("ROW_NUM"));
//				System.out.println("레시피ID : " + tempJson.get("RECIPE_ID"));
//				System.out.println("재료명 : " + tempJson.get("IRDNT_NM"));
//				System.out.println("용량 : " + tempJson.get("IRDNT_CPCTY"));
//				System.out.println("재료구분 : " + tempJson.get("IRDNT_TY_NM"));
//
//				System.out.println("-------------------------");
//			}


			@SuppressWarnings("unchecked")
			Iterator<JSONObject> it = list.iterator();

			while(it.hasNext()){

				JSONObject tempJson = it.next();

				System.out.println("도매시장 경매일자 : " + tempJson.get("ROW_NUM"));
				System.out.println("공영 도매시장명 : " + tempJson.get("SN"));
				System.out.println("공영 도매시장 내 법인명 : " + tempJson.get("AREA"));
				System.out.println("공영 도매시장코드 : " + tempJson.get("FARM_NM"));
				System.out.println("공영도매시장 법인코드 : " + tempJson.get("RPRSNTV"));
				System.out.println("품목명 : " + tempJson.get("FOND_DE"));
				System.out.println("품목 코드 : " + tempJson.get("FRAM_AR"));
				System.out.println("품종 명 : " + tempJson.get("BRD_LVSTCK_CO"));
				System.out.println("품종 코드 : " + tempJson.get("PRDCTN_QY"));
				System.out.println("등급 코드 : " + tempJson.get("FARM_INTRCN"));
				System.out.println("규격 코드 : " + tempJson.get("ADDR"));
				System.out.println("규격 코드 : " + tempJson.get("TLPHON_NO"));
				System.out.println("규격 코드 : " + tempJson.get("HMPG"));
				System.out.println("규격 코드 : " + tempJson.get("RDNMADR"));
				System.out.println("규격 코드 : " + tempJson.get("NW_ZIP"));
				System.out.println("규격 코드 : " + tempJson.get("LA"));
				System.out.println("규격 코드 : " + tempJson.get("LO"));
				
				System.out.println("-------------------------");
			}
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		new JsonSimpleReadExam2().start();
	}
}
