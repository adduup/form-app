<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Address Info</title>
</head>
</html>
<body>

	<table>
	
		<tr>
			<th>Address One</th>
			<th>City</th>
			<th>State</th>
			<th>Zip Code</th>
			<th>Address2</th>

			<th>Return</th>
			<th>Delete</th>
			
		</tr>
		<c:forEach var="address" items="${addresses}">
		<c:url var="returnToForm" value="/student/list">
		

		</c:url>
		  <c:url var="deleteLink" value="/student/deleteAddress">
		<c:param name="addressId" value="${address.id}"/>
		</c:url>
		
		
			<tr>
				<td>${address.addressOne}</td>
				<td>${address.city}</td>
				<td>${address.state}</td>
				<td>${address.zipCode}</td>
				<td>${address.addressTwo}</td>
				
			
			

				<td>
					<a href="${returnToForm}">Return</a>
				</td>
				<td>
					<a href="${deleteLink}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>