<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%  // 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
    	if (session.getAttribute("signedUser") == null) {
    	  String redirectUrl = request.getContextPath()+"/HW/main/login.do";
    	response.sendRedirect(redirectUrl); 
    } 
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/HW/board/insert.do" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>글 제목 : </td>
				<td><input type="text" name="boardTitle" value=""></td>
			</tr>
			<tr>
				<td>글 내용: </td>
				<td><input type="text" name="boardContent" value=""></td>
			</tr>
				<td>첨부파일</td>
				<td><input type="file" name="atchFile"></td>
			</tr>
		</table>
		<input type="submit" value="글 등록">
	</form>
</body>
</html>