<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Catalog</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f7f9fc;
    margin: 0;
    padding: 20px;
}

.placeorder-btn {
    display: block;
    margin: 20px auto 30px auto;
    padding: 12px 25px;
    background-color: #007BFF;
    color: #fff;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
.placeorder-btn:hover {
    background-color: #0056b3;
}

h2 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

.product-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
}

.product-card {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    width: 280px;
    padding: 20px;
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
    text-align: center;
    transition: transform 0.2s ease;
}
.product-card:hover {
    transform: translateY(-5px);
}

.product-card h3 {
    margin: 10px 0;
    color: #007BFF;
}

.product-card p {
    margin: 5px 0;
    color: #555;
}

.qty-input {
    width: 60px;
    padding: 5px;
    margin: 10px 0;
    text-align: center;
}

.add-btn {
    background-color: #28a745;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    font-size: 14px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}
.add-btn:hover {
    background-color: #218838;
}
</style>
</head>
<body>

    <h2>Available Products</h2>

    <c:if test="${not empty cart}">
        <form action="Placeorder.jsp" method="post">
            <button type="submit" class="placeorder-btn">Place Order</button>
        </form>
    </c:if>

    <div class="product-container">
        <c:forEach var="p" items="${plist}">
            <div class="product-card">
                <form action="addtocart" method="post">
                    <h3>${p.name}</h3>
                    <p><strong>ID:</strong> ${p.pid}</p>
                    <p class="price"><strong>Price:</strong> Rs. ${p.price}</p>

                    <input type="hidden" name="pid" value="${p.pid}" />
                    <input type="hidden" name="pname" value="${p.name}" />
                    <input type="hidden" name="price" value="${p.price}" />

                    <label for="qty-${p.pid}">Quantity:</label>
                    <input type="number" id="qty-${p.pid}" name="qty" class="qty-input" min="1" required />

                    <br />
                    <button type="submit" class="add-btn">Add to Cart</button>
                </form>
            </div>
        </c:forEach>
    </div>

</body>
</html>
