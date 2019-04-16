<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Address Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>SRM Student Relationship Manager (Address)</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Address</h3>
		<form:form action="addAddress" modelAttribute="address" method="POST">
		
		
                
              <form:input path="studentId" />
            
			<table>
				<tbody>
					<tr>
						<td><label>Address One</label></td>
						<td><form:input path="addressOne" /></td>
					</tr>
					<tr>
						<td><label>City</label></td>
						<td><form:input path="city" /></td>
					</tr>
					<tr>
						<td><label>State</label></td>
						<td><form:input path="state" /></td>
					</tr>
					<tr>
						<td><label>Zip Code</label></td>
						<td><form:input path="zipCode" /></td>
					</tr>
					<tr>
						<td><label>Address Two</label></td>
						<td><form:input path="addressTwo" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save"></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>