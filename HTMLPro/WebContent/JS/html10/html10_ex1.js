/**
 * 
 */
var pop;
	
function proc() {
		pop = window.open("http://google.com"); //prompt처럼 window를 생략하고 쓸수 있다
	}
	
function proc2() {
		pop.close(); //창을 닫는 메서드
	}
	
function showMsg() {
		//window.setTimeout();  =>window 생략가능
//	setTimeout(alertMsg, 3000); //파라미터를 넘길때는 함수의 괄호를 없애줘야하는데
//괄호를 넣으면 함수 실행이 되는거고 파라미터는 괄호를 없애면 된다
setTimeout(function () { //함수를 파라미터에 정의해줄수있다 무명함수로!
alert("타이머 썼어유");
	}, 3000);
	
}

/*function alertMsg() {
	alert("타이머 썼어유");
}*/

function changeBgColor() {
	setInterval(changeColor,2000);
	
}

function changeColor() {
	//랜덤으로 색을 만들어서 p태그의 배경을 넣어주기
	
	//1.랜덤 색 뽑기
	var r=0,g=0,b=0;
	r=Math.floor((Math.random()*256));
	g=parseInt((Math.random()*256));
	b=Math.floor((Math.random()*256));
	
	//2.p태그에 배경색 주기
	document.getElementById("pInterval").style.backgroundColor
	="rgb("+r+","+g+","+b+")";
	//<p id="pInterval" style="background-color: yellow;"> 
	//스크립트를 쓸때는 -이게 없고 대문자를 써준다
	// "red", "#ff0055","rgb(255,0,255)" 색을 부여해주는 방법
	
}















































