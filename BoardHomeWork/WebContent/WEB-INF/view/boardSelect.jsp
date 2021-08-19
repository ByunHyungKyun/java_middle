<%@page import="kr.or.ddit.board.vo.AtchFileVO"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	BoardVO boardVO = (BoardVO)request.getAttribute("boardVO");
	List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Project HomeWar</title>
<script src='<%=request.getContextPath() %>/HW_main/js/jquery.js'></script>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/css/woocommerce-layout.css' type='text/css' media='all'/>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/css/woocommerce-smallscreen.css' type='text/css' media='only screen and (max-width: 768px)'/>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/css/woocommerce.css' type='text/css' media='all'/>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/css/font-awesome.min.css' type='text/css' media='all'/>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/style.css' type='text/css' media='all'/>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Oswald:400,500,700%7CRoboto:400,500,700%7CHerr+Von+Muellerhoff:400,500,700%7CQuattrocento+Sans:400,500,700' type='text/css' media='all'/>
<link rel='stylesheet' href='<%=request.getContextPath() %>/HW_main/css/easy-responsive-shortcodes.css' type='text/css' media='all'/>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=request.getContextPath() %>/HW_main/css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/HW_main/css/style.css"> <!-- Resource style -->
<script src="<%=request.getContextPath() %>/HW_main/js/modernizr.js"></script> 
<script src="<%=request.getContextPath() %>/HW_main/js/jquery-2.1.1.js"></script>
<script src="<%=request.getContextPath() %>/HW_main/js/main.js"></script> <!-- Resource jQuery -->
<script type="text/javascript">
jQuery(document).ready( function($) {
   
   var roll = 1;
   
   setInterval(function(){
      roll++;
      if (roll > 3) {roll = 1;}
      $("#hom").attr("src", "<%=request.getContextPath() %>/HW_main/IMG/ban" + roll + ".jpg");
   }, 2000);
   
   
   $(window).resize(function(){
      change();
   });
     function change(){
        var windowWidth = $(window).width();
        if(windowWidth < 980) {
           $('#byun').hide();
         } else {
            $('#byun').show();
         }
     }
});

</script>
<style type="text/css">
.aa {
   font-size: x-large;
   padding: 40px;
}

.menu-menu-1-container ul li {
   line-height: 97px;
}

.container-fluid>.navbar-collapse, .container-fluid>.navbar-header, .container>.navbar-collapse, .container>.navbar-header {
   background-color: black;
}

.topImg {
   background-image: url("/HW_main/IMG/5.jpg");
   background-repeat: no-repeat;
}

.topImg img {
   border-radius: 10px;
}


</style>
</head>
<body class="home page page-template page-template-template-portfolio page-template-template-portfolio-php">
  
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <li>
         <a href="#"></a></li>
        <li><a href="<%=request.getContextPath() %>/HW/main/login.do" style="font-size:large; color: white;"><span class="glyphicon glyphicon-log-in" ></span> LogIn</a></li>
      </ul>
    </div>
  </div>
  
<div id="page">
   <div class="container">
      <header id="masthead" class="site-header">
      <div class="site-branding">
         <h1 class="site-title"><a href="index.html" rel="home"></a></h1>
         <h2 class="site-description"></h2>
      </div>
      <nav id="site-navigation" class="main-navigation">
      <button class="menu-toggle"><img alt="안나와.." src="<%=request.getContextPath() %>/HW_main/IMG/logo.jpg"></button>
      <a class="skip-link screen-reader-text" href="#content">Skip to content</a>
      <div class="menu-menu-1-container" onchange="dis()">
        <ul id="menu-menu-1" class="menu">
				<li>
				<a href="<%=request.getContextPath() %>/HW/video/pt.do" class="aa">PT</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/HW/video/bmi.do">BMI 계산기</a></li>
					<li><a href="#">운동 게시판</a></li>
					<li><a href="<%=request.getContextPath() %>/HW/video/video.do">운동 동영상</a></li>
					<li><a href="<%=request.getContextPath() %>/HW/video/exerfood.do">운동/식단</a></li>
				</ul>
				</li>
				<li>
				<a href="<%=request.getContextPath() %>/HW/prod/list.do" class="aa">쇼핑몰</a>
				<ul class="sub-menu">
					<li><a href="<%=request.getContextPath() %>/HW/prod/categoriSelect.do?prodCategori=1">운동 기구</a></li>
					<li><a href="<%=request.getContextPath() %>/HW/prod/categoriSelect.do?prodCategori=2">보조 식품</a></li>
					<li><a href="#">배송 문의</a></li>
					<li><a href="#">상품 문의</a></li>
				</ul>
				</li>
				<li id="byun"><a href="#"><img alt="안나와.." src="<%=request.getContextPath() %>/HW_main/IMG/logo.jpg" width="150" height="150"></a></li>
				<li>
				<a href="<%=request.getContextPath() %>/HW/board/list.do" class="aa">게시판</a>
				<ul class="sub-menu">
					<li><a href="#l">공지 사항</a></li>
					<li><a href="#">Q & A</a></li>
				</ul>
				</li>
				<li>
				<a href="<%=request.getContextPath() %>/HW/pay/memberex.do" class="aa">멤버쉽</a>
				<ul class="sub-menu">
					<li><a href="#">멤버쉽 소개</a></li>
					<li><a href="#">멤버쉽 결제</a></li>
				</ul>
				</li>
			</ul>
      </div>
      </nav>
      </header>

<body>
<table border="1">
		<tr>
			<td>게시글 번호 : <%=boardVO.getBoardNum() %></td>
				<td> </td>
		</tr>
		<tr>
			<td>게시글 제목 : <%=boardVO.getBoardTitle() %></td>
			<td> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp작성자 아이디 : <%=boardVO.getMemId() %> &nbsp&nbsp등록 날짜 : <%=boardVO.getBoardDate() %></td>
		</tr>
		
		<tr>
			<td>게시글 내용 : </td>
			<td><%=boardVO.getBoardContent() %></td>
		</tr>
		
		<tr>
			<td>첨부파일</td>
			<td>
				<%if(atchFileList != null){
					for(AtchFileVO atchFileVO : atchFileList){
				%>
					<div><a href="<%=request.getContextPath() %>/HW/board/filedownload.do?fileId=<%=atchFileVO.getAtchFileId() %>&fileSn=<%=atchFileVO.getFileSn() %>"><%=atchFileVO.getOrignlFileNm() %></a></div>			
				<% 
					}
				}
				%>
				
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<%=request.getContextPath() %>/HW/board/list.do">[목록]</a>
				<% 
				String sessionId = (String)session.getAttribute("signedUser");
				String memId = boardVO.getMemId();
				if(memId.equals(sessionId)){
					%>                 
				<a href="<%=request.getContextPath() %>/HW/board/update.do?boardNum=<%=boardVO.getBoardNum()%>">[게시글 수정]</a>
				<a href="<%=request.getContextPath() %>/HW/board/delete.do?boardNum=<%=boardVO.getBoardNum()%>">[게시글 삭제]</a>
					<% 
				}	
					%>
			</td>
		</tr>
	</table>
<!-- .container -->
   <footer id="colophon" class="site-footer">
   <div class="container">
      <div class="site-info">
         <h1 style="font-family: 'Herr Von Muellerhoff';color: #ccc;font-weight:300;text-align: center;margin-bottom:0;margin-top:0;line-height:1.4;font-size: 46px;">Hw</h1>
         copyright Homewar 2021-04-21<i class="fa fa-love"></i>
      </div>
   </div>   
   </footer>
   <a href="#top" class="smoothup" title="Back to top"><span class="genericon genericon-collapse"></span></a>
</div>

</body>
<!-- #page -->
<script src='<%=request.getContextPath() %>/HW_main/js/plugins.js'></script>
<script src='<%=request.getContextPath() %>/HW_main/js/scripts.js'></script>
<script src='<%=request.getContextPath() %>/HW_main/js/masonry.pkgd.min.js'></script>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>