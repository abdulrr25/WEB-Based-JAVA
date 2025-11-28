<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Set, com.demo.bean.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place Order</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f9fc;
        margin: 0;
        padding: 20px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    th, td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
    }
    th {
        background-color: #007BFF;
        color: #fff;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .total-row {
        font-weight: bold;
        background-color: #e9ecef;
    }
    .btn-container {
        text-align: center;
        margin-top: 30px;
    }
    button {
        background-color: #28a745;
        color: #fff;
        padding: 12px 25px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    button:hover {
        background-color: #218838;
    }
</style>
</head>
<body>
    <h2>Your Shopping Cart</h2>

    <!-- initialize total amount -->
    <c:set var="totamt" value="0" scope="page"/>

    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Order Qty</th>
            <th>Rs. Price </th>
            <th>Rs. Amount</th>
        </tr>

        <c:forEach var="p" items="${cart}">
            <c:set var="amount" value="${p.qty * p.price}" />
            <c:set var="totamt" value="${totamt + amount}" scope="page" />
            <tr>
                <td>${p.pid}</td>
                <td>${p.name}</td>
                <td>${p.qty}</td>
                <td>${p.price}</td>
                <td>${amount}</td>
            </tr>
        </c:forEach>

        <tr class="total-row">
            <td colspan="4">Total Bill Amount</td>
            <td>Rs. ${totamt}</td>
        </tr>
    </table>

    <div class="btn-container">
        <form action="Payment.jsp" method="post">
            <input type="hidden" name="tamt" value="${totamt}" />
            <button type="submit">Proceed to Payment</button>
        </form>
    </div>

</body>
</html>