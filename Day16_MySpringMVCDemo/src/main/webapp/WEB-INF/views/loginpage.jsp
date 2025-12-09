<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${message}</h2>
<form action="${pageContext.request.contextPath}/login/validateUser" method="post">
	<label>Enter Your User Name</label>
	<input type="text" name="uname" id="un"><br/>
	<label>Enter Your Password</label>
	<input type="password" name="pass" id="ps"><br/>
	<button type="submit" name="login" id="login" value="login">Login</button>
	
</form>

<a href="registerme">Register me? </a> / <a href="#">Forgot password?</a>
</body>
</html>