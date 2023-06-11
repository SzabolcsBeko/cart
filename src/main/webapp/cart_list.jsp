<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css" />
<title>List of Cart Items</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Cart Management</h1>
        <div id="form-container">
        <h2>
        	<a href="cart?action=new">Add New Item</a>
        	
        </h2>
        <table cellpadding="6">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>MegaPack</th>
                <th>Count</th>
                <th>Action</th>
            </tr>
            <c:forEach var="cart" items="${cartItems}">
                <tr>
                    <td><c:out value="${cart.id}" /></td>
                    <td><c:out value="${cart.name}" /></td>
                    <td><c:out value="${cart.price}" /></td>
                    <td><c:out value="${cart.megaPack}" /></td>
                    <td><c:out value="${cart.count}" /></td>
                    <td>
                    	<a href="cart?action=edit&id=<c:out value='${cart.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="cart?action=delete&id=<c:out value='${cart.id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
	    <div>
	        <c:forEach var="total" items="${total}">
	        	<p style="color:blue;">Cart total price:<c:out value="${total}" /></p>
	        </c:forEach>
	    </div>    
        <div>
	        <c:forEach var="discount" items="${discount}">
	        	<p style="color:blue;">Cart discount price:<c:out value="${discount}" /></p>
	        </c:forEach>
        </div>
        <div>
        	<c:forEach var="discountName" items="${discountName}">
        		<p style="color:blue;">DiscountType:<c:out value="${discountName}" /></p>
        	</c:forEach>
        </div>
        <div>
        	<c:forEach var="eurRate" items="${eurRate}">
        		<p style="color:blue;">EUR:<c:out value="${eurRate}" /></p>
        	</c:forEach>
        </div>
    </div>	
</body>
</html>

