<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Student Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>SRM Student Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Student</h3>
		<form:form action="saveStudent" modelAttribute="student" method="POST">
		
		
                
               <form:hidden path="id" />
            
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
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