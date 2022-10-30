<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일체크 JSP 페이지</title>
</head>
     fileCheck jsp페이지    
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String subject = request.getParameter("subject");

String fileName1 = request.getParameter("fileName1");
String originalName1 = request.getParameter("originalName1");
%>         
<h3>업로드 파일 확인</h3>
    올린 사람 :
<%=name%><br />
    제목 :
<%=subject%><br />
         

    파일1 다운로드 :
<a id="downA" href="#"><%=originalName1%></a>

<img src="originalName1">

<script type="text/javascript">        
	document.getElementById("downA").addEventListener("click", function(event) {
		event.preventDefault(); 
	    event.stopPropagation();                        
		var fName = encodeURIComponent("<%=fileName1%>");
			window.location.href = "fileDown1.jsp?file_name="+fName;
		});
</script>
