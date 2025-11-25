<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="getproduct.jsp">
	<Label>ProductId:</Label><input type="text" name="pid" id="proid"/>
	<Label>Product Name:</Label><input type="text" name="pnm" id="pronm"/>
	<Label>Product Quantity:</Label><input type="text" name="qty" id="proqty"/>
	<Label>Product Price:</Label><input type="text" name="price" id="proprice"/>
	<button type="submit" name="btn" id="btn" value="add">Add product</button>  
				
</form>
</body>
</html>