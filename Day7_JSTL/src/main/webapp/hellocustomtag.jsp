<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="hello"  uri="/mytaglib"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String fname="Abdul";
	String lname ="Rahman";
	
%>
<h1>Hello we are designing custom tags</h1>
 <hello:myhellotag fname="<%=fname%>" lname="<%=lname%>"></hello:myhellotag> 
<hello:calculatedata num1="${param.num1}" num2="${param.num2}"></hello:calculatedata>
</body>
</html>