<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>List Of Countries</title>
</head>
<body>
	<table>
		<tr>
			<th>Country</th>
			<th>UnMember Status</th>
			<th>Sovereignty Dispute</th>
			<th>More Info</th>
		</tr>
		<c:forEach var="country" items="${countries}">
		<tr>
			
			<td>${country.country}</td>
			<td>${country.unMemberStatus}</td>
			<td>${country.sovereigntyDispute}</td>
			<td>${country.moreInfo}</td>
		
		</tr>
		</c:forEach>
	</table>
</body>
</html>