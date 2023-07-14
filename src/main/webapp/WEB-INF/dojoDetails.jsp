<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center; margin: 20px;" >${dojo.name} Location Ninjas</h1>
	<table class="table table-bordered" style="width: 700px; margin: 0 auto;">
		<thead>
			<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${dojo.ownedNinjas }">
				<tr>
					<td><c:out value="${eachNinja.id }"/></td>
					<td><a href="#"><c:out value="${eachNinja.first_name }" /></a></td>
					<td><a href="#"><c:out value="${eachNinja.age }" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>