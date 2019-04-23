<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style type="text/css">
		.failed {
			color: red;
		}
		.logout {
			color: blue;
		}
	</style>
</head>
<body>
	<h3>Login Page Sup Dog</h3>

	
	<form:form action="${contextPath}/authenticateTheUser" method="POST">
	<c:if test="${param.error !=null}">
		<i class="failed">Sorry! You have entered ivalid username/password</i>
	</c:if>
	

	<table>
		<tr>
			<td><label>User Name</label></td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td><input type="submit" name="Login"></td>
		</tr>
	</table>
		
	</form:form>

</body>
</html>