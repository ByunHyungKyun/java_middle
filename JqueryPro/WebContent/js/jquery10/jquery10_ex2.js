/**
 * 
 */
function makeTable2(param){
	var arr = param.getElementsByTagName("CD");
	var str = "<table border='1' style='border-collapse: collapse;"
		+"text-align: center;' width='700' >";
		str +="<tr style='background-color: blue; color:white;'>";
		str +="<th>제목</th>";
		str +="<th>가수 이름</th>";
		str +="<th>국가</th>";
		str +="<th>회사</th>";
		str +="<th>가격</th>";
		str +="<th>년도</th>";
		str +="</tr>";
		for(var obj of arr){
			str += "<tr>";
			for(var i = 0 ; i<6;i++){
				if($(obj).children().eq(i).html() == null){
					str +="<td style='background-color: black; color:white;'>값이 없음</td>";
					continue;
				}
				str += "<td>"+$(obj).children().eq(i).html()+"</td>";
			}
			str += "</tr>";
		}
		str +="</table>";
		$("#divResult").html(str);
}


function fnXmlTable2() {
	$.ajax({
		url : "cd_catalog1.xml"
		/* ,type : "get"//"post"
		,data : {} */
		,dataType : "xml" //데이터를 받아올게 xml이기 때문에 타입은xml이다 
		,success : function(data){
				console.log(data); //객체를 받아온다.data가 document형식으로
				console.log(data.getElementsByTagName("CATALOG"));
				//document.getElementsByTagNam() 태그네임을 가져오는 방법
				console.log(data.getElementsByTagName("CD"));
				console.log(data.getElementsByTagName("ARTIST"));
				/* childNodes
				children */ //자식요소를 가져오는 방법
				
				makeTable2(data);
				
				
			}
		,error : function(xhr){
			console.log(xhr);
			alert("오류발생");
		}
	});
	
	
}
function makeTable(param){
	/*var arr1 = param.getElementsByTagName("TITLE");
	var arr2 = param.getElementsByTagName("ARTIST");
	var arr3 = param.getElementsByTagName("COUNTRY");
	var arr4 = param.getElementsByTagName("COMPANY");
	var arr5 = param.getElementsByTagName("PRICE");
	var arr6 = param.getElementsByTagName("YEAR");
	*/
	/*var str = "<table border='1' style='border-collapse: collapse;"
		+"text-align: center;' width='700' >";
		str +="<tr style='background-color: blue; color:white;'>";
		str +="<th>제목</th>";
		str +="<th>가수 이름</th>";
		str +="<th>국가</th>";
		str +="<th>회사</th>";
		str +="<th>가격</th>";
		str +="<th>년도</th>";
		str +="</tr>";
		for(var i = 0 ; i < arr1.length;i++){
			str += "<tr>";
				str += "<td>"+arr1[i].innerHTML+"</td>"
				+"<td>"+arr2[i].innerHTML+"</td>" 
				+"<td>"+arr3[i].innerHTML+"</td>" 			
				+"<td>"+arr4[i].innerHTML+"</td>" 
				+"<td>"+arr5[i].innerHTML+"$</td>" 
				+"<td>"+arr6[i].innerHTML+"년</td>"
				+"</tr>";
		}
		 str +="</table>";
		$("#divResult").html(str);*/
	var arr = param.getElementsByTagName("CD");
	
	var str = "<table border='1' style='border-collapse: collapse;"
		+"text-align: center;' width='700' >";
		str +="<tr style='background-color: blue; color:white;'>";
		str +="<th>제목</th>";
		str +="<th>가수 이름</th>";
		str +="<th>국가</th>";
		str +="<th>회사</th>";
		str +="<th>가격</th>";
		str +="<th>년도</th>";
		str +="</tr>";
		
		for(var obj of arr){
			
			/*console.log(obj);
			console.log($(obj).children());
			console.log($(obj).children().eq(0));
			console.log($(obj).children().eq(0).html());*/
			
			str += "<tr>";
				str += "<td>"+$(obj).children().eq(0).html()+"</td>"
				+"<td>"+$(obj).children().eq(1).html()+"</td>" 
				+"<td>"+$(obj).children().eq(2).html()+"</td>" 			
				+"<td>"+$(obj).children().eq(3).html()+"</td>" 
				+"<td>"+$(obj).children().eq(4).html()+"$</td>" 
				+"<td>"+$(obj).children().eq(5).html()+"년</td>"
				+"</tr>";
		}
		str +="</table>";
		$("#divResult").html(str);
	
		
}



function fnXmlTable() {
	$.ajax({
		url : "cd_catalog.xml"
		/* ,type : "get"//"post"
		,data : {} */
		,dataType : "xml" //데이터를 받아올게 xml이기 때문에 타입은xml이다 
		,success : function(data){
				console.log(data); //객체를 받아온다.data가 document형식으로
				console.log(data.getElementsByTagName("CATALOG"));
				//document.getElementsByTagNam() 태그네임을 가져오는 방법
				console.log(data.getElementsByTagName("CD"));
				console.log(data.getElementsByTagName("ARTIST"));
				/* childNodes
				children */ //자식요소를 가져오는 방법
				
				makeTable(data);
				
				
			}
		,error : function(xhr){
			console.log(xhr);
			alert("오류발생");
		}
	});
	
	
}



function fnXml2() {
		$.ajax({
			url : "cd_catalog.xml"
			/* ,type : "get"//"post"
			,data : {} */
			,dataType : "xml" //데이터를 받아올게 xml이기 때문에 타입은xml이다 
			,success : function(data){
					console.log(data); //객체를 받아온다.data가 document형식으로
					console.log(data.getElementsByTagName("CATALOG"));
					//document.getElementsByTagNam() 태그네임을 가져오는 방법
					console.log(data.getElementsByTagName("CD"));
					console.log(data.getElementsByTagName("ARTIST"));
					/* childNodes
					children */ //자식요소를 가져오는 방법
					
					makeTitleList(data);
					
					
				}
			,error : function(xhr){
				console.log(xhr);
				alert("오류발생");
			}
		});
	}

	function makeTitleList(param) {
		var arr = param.getElementsByTagName("TITLE");
		/* console.log(arr[0]);
		console.log(arr[0].childNodes[0]);
		console.log(arr[0].childNodes[0].nodeValue); //최종 값을 가져오는 방법 */
		//[HTML 교재10 - DOM 순회] pdf 참고
		
		var str = "";
		for(var i = 0 ; i < arr.length;i++){
			str += (i+1)+"번째 : "+arr[i].childNodes[0].nodeValue+"<br>"; //arr돌떄만 i가 필요 노드는 0번째!
		}
		$("#divResult").html(str);
		
	}
	
	
	
	
	
	
	
	
	
	
	function fnXml() {
		$.ajax({
			url : "cd_catalog.xml"
			/* ,type : "get"//"post"
			,data : {} */
			,dataType : "xml" //데이터를 받아올게 xml이기 때문에 타입은xml이다 
			,success : function(data){
					console.log(data); //객체를 받아온다.data가 document형식으로
					console.log(data.getElementsByTagName("CATALOG"));
					//document.getElementsByTagNam() 태그네임을 가져오는 방법
					console.log(data.getElementsByTagName("CD"));
					console.log(data.getElementsByTagName("ARTIST"));
					/* childNodes
					children */ //자식요소를 가져오는 방법
					
					makeArtistList(data);
					
					
				}
			,error : function(xhr){
				console.log(xhr);
				alert("오류발생");
			}
		});
	}


	function makeArtistList(param) {
		//param == document
		
		var arr = param.getElementsByTagName("ARTIST"); //태그네임 안에 있는 HTML을 가져와야하기 때문에 innerHTML을 쓴다
		var str = "";
		for(var i = 0 ; i < arr.length;i++){
			str += (i+1)+"번째 : "+arr[i].innerHTML+"<br>";
		}
		$("#divResult").html(str);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	function fnJsonObj(){
		$.ajax({
			url : "/JqueryPro/html/sample/data_json_obj.txt"
			,dataType : "json" //text가 json형식이여서 꼭 써줘야 한다
			,success : function(data){
				/* console.log(data);
				console.log(data.name); */
				
				var str = "";
				str += "이름 : "+data.name +"<br>" //html로 넣기 떄문에 br태그를 쓰는것이다.
					+ "나이 : "+data.age	+"<br>"			
					+ "성별 : "+data.gender +"<br>"
					+ "직업 : "+data.job;
				
				$("#divResult").html(str);
			}
		});
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/* 	function fnJsonList(){
		$.ajax({
			url : "/JqueryPro/html/sample/data_json_list.txt"
			,dataType : "json"
			,success : function(data){
				//1번째 회원
				//이름 : 
				//나이 : 
				var str = "";
				 for(var i = 0;i<data.length;i++){
					var obj = data[i];
					str += (i+1)+"번째 회원"+"<br>"
					+"이름 : "+obj.name +"<br>" 
					+ "나이 : "+obj.age	+"<br>"			
					+ "성별 : "+obj.gender +"<br>"
					+ "직업 : "+obj.job+"<br><br>";
				} 
				 $("#divResult").html(str);
			}
			
		});
			
	} */
	

	function fnJsonList(){
		$.ajax({
			url : "/JqueryPro/html/sample/data_json_list.txt"
			,dataType : "json"
			,success : function(data){
				//1번째 회원
				//이름 : 
				//나이 : 
				var str = "<table border='1' style='border-collapse: collapse;"
							+"text-align: center;' width='300' >";
					str +="<tr style='background-color: purple; color:white;'>";
					str +="<th>순번</th>";
					str +="<th>이름</th>";
					str +="<th>나이</th>";
					str +="<th>성별</th>";
					str +="<th>직업</th>";
					str +="</tr>";
				 for(var i = 0;i<data.length;i++){
					var obj = data[i];
					str += "<tr>";
					str += "<td>"+(i+1)+"</td>"
					+"<td>"+obj.name+"</td>" 
					+"<td>"+obj.age+"</td>" 			
					+"<td>"+obj.gender+"</td>" 
					+"<td>"+obj.job+"</td>" 
					+"</tr>";
				} 
				 str +="</table>";
				 $("#divResult").html(str);
			}
			
		});
			
	}
	
	
	
	
	
	function fnJsonArr(){
		$.ajax({
			url : "/JqueryPro/html/sample/data_json_arr.txt"
			,dataType : "json"
			,success : function(data){
				var str = "";
				 str +="<ol>";
 				for(var i = 0;i<data.length;i++){
					str += "<li>"+data[i]+"</li>";
 				} 
				 
				/* $.each(data,function(idx){
 					str += "<li>"+data[i]+"</li>";
 				}); */
 				
				 str +="</ol>";
 				$("#divResult").html(str);
			}
			
			,error : function(data){
				console.log(data);
			}
			
			
		});
	}
	
	
	function fnText() {
		$.ajax({
			//url : "../sample/data_text.txt" 상대경로
			url : "/JqueryPro/html/sample/data_text.txt" //루트경로
			,type : "get"
			,date : {}
			,dataType : "text"
			,success : function(data){
				//아래 둘다 무관. text이기 때문에
				//$("#divResult").text(data);
				$("#divResult").html(data);
			}
			
		});
	}




	function fnGet() {
		//submit 실행 
		var fm = document.getElementById("fm"); //<form>
		fm.action = "html1.html?userId=test01&password=asdf"; //url세팅
		fm.method = "post";
		fm.submit();//<form>이 submit타입으로 바뀌는 것이다
	}
	
	
	
	
	function fnAjax() {
		$.ajax({
			url : "intro.html"
			,type : "GET"
			/* ,data : ""
			,datatype : "" */
			,success : function(data){
				$("#divResult").html(data);
			}
			,error : function(){
			
			}
			
		});
		
	}