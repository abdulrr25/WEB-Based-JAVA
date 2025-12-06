<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${message}</h1>
	<table border='2'>
	<tr>
	<th>Student Id</th>
	<th>Student Name</th>
	<th>Student Email</th>
	<th>Student Percentage</th>
	<th>Student Address</th>
	</tr>
	<c:forEach var="stud" items="${slist}">
	<tr>
	<td>${stud.sid}</td>
		<td>${stud.sname}</td>
		<td>${stud.email}</td>
		<td>${stud.percentage}</td>
		<td>${stud.address}</td>
		<td><a href="deletestudent/${stud.sid}">delete</a>/<a href="editStudent/${stud.sid}">edit</a></td>
	
	</tr>
	</c:forEach>
	</table>
	<a href="addstudent">Add Student</a>
</body>
</html>