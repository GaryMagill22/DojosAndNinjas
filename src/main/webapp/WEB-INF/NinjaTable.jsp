<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Table</title>
</head>
<body>
<h1>Denver Location Ninjas</h1>
	<table>
		<thead>
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${ninjaList }">
				<tr>
					<td><c:out value="${eachNinja.id }"/></td>
					<td><a><c:out value="${eachNinja.first_name }" /></a></td>
					<td><a><c:out value="${eachNinja.age }" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>