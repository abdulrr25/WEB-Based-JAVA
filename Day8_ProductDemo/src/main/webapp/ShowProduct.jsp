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
	<form action="Placeorder.jsp">
		<button type="submit" id="placeorder" name="placeorder" >Place Order</button>
	</form>
	<c:forEach var="p" items=${plist}> <%--------for(Product p: plist --%>
	<div>
		<form action="AddtoCart">
			Product Id = ${p.pid}<br/>
			Product name = ${p.uname}<br/>
			Product price = ${p.price}<br/>
			<input type="hidden" name="pid" id="pid" value="${p.pid}">
			<input type="hidden" name="name" id="name" value="${p.uname}">
			<input type="hidden" name="price" id="price" value="${p.price}">
			Quantity: <input type="text" name="qty" id="qty">
			<button type="submit" name="btn1" id="btn1">Add to Cart</button>
			
			
		</form>
	</div>
	</c:forEach>


</body>
</html>