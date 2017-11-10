<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC CRUD Operations</title>
</head>
<body>
	<h1>Upload Hotel Information</h1>
	
	<c:url value="/hotels/add" var="hotelAction" />
	<form:form method="POST" modelAttribute="hotel" action="${hotelAction}">
		<table>
			<c:if test="${!empty hotel.hotelName}">
				<tr>
					<td>Hotel ID:</td>
					<td>
						<form:input path="hotelId" disabled="true"/>
						<form:hidden path="hotelId"/>
					</td>
				</tr>
			</c:if>
			<tr>
				<td>Hotel Name:</td>
				<td><form:input path="hotelName"/></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city"/></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price"/></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><form:input path="rating"/></td>
			</tr>
			<tr>
				<td>
					<c:if test="${!empty hotel.hotelName}">
						<input type="submit" value="Update Hotel">
					</c:if>
					<c:if test="${empty hotel.hotelName}">
						<input type="submit" value="Add Hotel">
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
	
	<br>
	<br>
	
	<table>
		<tr>
			<th>Hotel Id</th>
			<th>Hotel Name</th>
			<th>City</th>
			<th>Price</th>
			<th>Rating</th>
			
			<th>Update</th>
			<th>Delete</th>
		</tr>
		
		<c:forEach items="${hotels}" var="htl">
			<tr>
				<td>${htl.hotelId}</td>
				<td>${htl.hotelName}</td>
				<td>${htl.city}</td>
				<td>${htl.price}</td>
				<td>${htl.rating}</td>
				
				<td><a href="<c:url value="/hotels/update/${htl.hotelId}" />">Update</a></td>
				<td><a href="<c:url value="/hotels/delete/${htl.hotelId}" />">Delete</a></td>
			</tr>		
		</c:forEach>
		
	</table>
	
</body>
</html>