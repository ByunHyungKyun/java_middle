/**
 * 
 */


//get메서드 방식을 썼을때 주소와 얻고싶은 값의 순서를 넣으면 값을 리턴해주는 메소드(0번째 부터 시작)
function getValue(str) { 
	var url = location.href;
	
	var ckeck = url.substr(url.indexOf("?")+1);
	
	var arr = ckeck.split("&");
	
	var arr2;
	for(var i =0;i<arr.length;i++ ){
		if(arr[i].split("=")[0] == str){
			arr2 = arr[i].split("=");
		}
	}
	var result = decodeURI(arr2[1]);
	
	return result;
}



//val이 빈값이거나 null이거나 undefined이거인지 검사하는 메서드
function isEmpty(val){
	if(val == " "){
		return false;
	}else if(val == null){
		return false;
	}else if(val == undefined){
		return false;
	}else {
		return true;
	}
}



function chkRegExp(val, type){ //값과 어떤형식으로 할지 파라미터로 받는다
	//정규식 검사
	
	var id = /^[a-z가-힣0-9_]{8,20}$/;
	var pass = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$/;
	var name = /^[가-힣]{2,5}$/;
	var bir = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
	var phone =/^\d{3}\d{3,4}\d{4}$/; 
	var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
	
	
	if(id.equals(type)){
		if(val.match(id) == null ){
			return false;
		}else {
			return true;
		}
	}else if(pass.equals(type)){
		
		if(val.match(pass) == null ){
			return false;
		}else {
			return true;
		}
		
		
	}else if(name.equals(type)){
		
		if(val.match(name) == null ){
			return false;
		}else {
			return true;
		}
		
		
	}else if(bir.equals(type)){
		
		if(val.match(bir) == null ){
			return false;
		}else {
			return true;
		}
		
		
	}else if(phone.equals(type)){
		
		if(val.match(phone) == null ){
			return false;
		}else {
			return true;
		}
		
		
	}else if(email.equals(type)){
		
		if(val.match(email) == null ){
			return false;
		}else {
			return true;
		}
		
		
	}else {
		alert("파라미터값을 잘못입력하셨습니다");
	}
	
}




function format(val,type){ //어떤값을 형식에 맞게 바꿔주는것
	//val : 010-1234-1234 , 01012341234, 010-123412342 , 010 1234 1234
	//예를 들어 번호가 들어왔을때 하나의 번호형식으로 바꿔주는 것이다.
	
	if(type == "phone") {
		
		val = val.replaceAll("-","").replaceAll(" ","");//앞에있는것을 뒤에있는것으로 바꾼다
		val = val.replace(/(\d{3})(\d{3,4})(\d{4})/ , "$1$2$3"); //각 괄호에있는 값을 $에 맞게 바꿔준다는 뜻
		
		/*//2020-04-08
		val = val.replace(/(\d{3})(\d{3,4})(\d{4})/ , "$1-$2-$3"); 
		
		//2020/04/08
		val = val.replace(/(\d{3})(\d{3,4})(\d{4})/ , "$1/$2/$3"); 
		
		//2020년04월08일
		val = val.replace(/(\d{3})(\d{3,4})(\d{4})/ , "$1년$2월$3일");
		
		val = 010-1234-1234;*/
		
		return val;
	}
}













































