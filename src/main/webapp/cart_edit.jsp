<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css" />
<title>Add new Item</title>
</head>
<body>
	<div class="survey-page">
        <h1 id="title">Cart Item Management</h1>
        <div id="form-container">
           <p id="description">
              Edit Cart Items
           </p>
           <h2>
        	<a href="cart">List All Cart Items</a> &nbsp;&nbsp;&nbsp;
	       </h2>
           <c:if test="${cart != null}">
				<form action="cart?action=update" method="post">
	        </c:if>
	        <c:if test="${cart == null}">
				<form action="cart?action=insert" method="post">
	        </c:if>
	        <c:if test="${cart != null}">
       			<input type="hidden" name="id" class="input-field" value="<c:out value='${cart.id}'/>"/> 
        	</c:if>
              <div class="formRow">
                 <label id="name-label" class="label-cls" for="name">* Name: </label>
                 <div class="input-col">
                    <input autofocus type="text" name="name" id="name" class="input-field" value="<c:out value='${cart.name}'/>"
                    placeholder="Enter product name" required >  
                 </div>
              </div>
              <div class="formRow">
                 <label id="number-label" class="label-cls" for="price">* Price: </label>
                 <div class="input-col">
                    <input type="number" name="price" id="number"  class="input-field" value="<c:out value='${cart.price}'/>"
                    placeholder="Enter item price" > 
                 </div>
              </div>
              <div class="formRow">
                 <label id="email-label" class="label-cls" for="megaPack">* MegaPack: </label>
                 <div class="input-col">
                    <input type="text" name="megaPack" id="megaPack" class="input-field" value="<c:out value='${cart.megaPack}'/>"
                    required placeholder="Enter item megaPack" >
                 </div>
              </div>
              <div class="formRow">
                 <label id="email-label" class="label-cls" for="count">* Count: </label>
                 <div class="input-col">
                    <input type="text" name="count" id="count" class="input-field" value="<c:out value='${cart.count}'/>"
                    required placeholder="Enter item count" >
                 </div>
              </div>
              <button id="submit" type="submit">Submit</button>
              <!--<button id="cancel" type="cancel">Cancel</button> -->
           </form>
        </div>
      </div>
     </div>
      
</body>
</html>