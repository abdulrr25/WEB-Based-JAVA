<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Confirmation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 40px;
        text-align: center;
    }
    .card {
        background-color: #fff;
        padding: 30px;
        margin: 0 auto;
        width: 50%;
        border-radius: 8px;
        box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    }
    h2 {
        color: #28a745;
        margin-bottom: 20px;
    }
    h3 {
        color: #333;
        margin-bottom: 15px;
    }
    h4, h5 {
        color: #555;
        margin-bottom: 10px;
    }
    .btn {
        display: inline-block;
        margin-top: 20px;
        padding: 12px 25px;
        background-color: #007BFF;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s ease;
    }
    .btn:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="card">
        <h2>HURRAY !! Your order has been placed successfully</h2>
        <h3>Your bill amount: Rs. ${param.tamt}</h3>
        <h4>Your order will be delivered in 2 days</h4>
        <h5>Thank you for visiting, do come again!</h5>

        <!-- Invalidate session after order -->
		<%
    System.out.println("Session is invalidated");
    session.invalidate(); %>        
        <c:remove var="cart" scope="session"/>
        <c:remove var="user" scope="session"/>

        <a href="Login.jsp" class="btn">Back to Login</a>
    </div>
</body>
</html>