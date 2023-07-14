<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
   <h1 style="text-align: center;" >Create New Ninja</h1>
  <div class="container">
    <form:form action="/ninjas/create" method="post" modelAttribute="newNinja" class="border rounded p-3" style="max-width: 500px;">
      <div class="form-group">
        <form:label path="first_name">First Name: </form:label>
        <form:input path="first_name" type="text" class="form-control" placeholder="Enter your first name"/>
        <form:errors path="first_name" />
      </div>
      <div class="form-group">
        <form:label path="last_name">Last Name: </form:label>
        <form:input  path="last_name" type="text" class="form-control"  placeholder="Enter your last name"/>
        <form:errors path="last_name" />
      </div>
      <div class="form-group">
        <form:label path="age">Age: </form:label>
        <form:input path="age" type="number" class="form-control" placeholder="Enter your age"/>
        <form:errors path="age" />
      </div>
      <div class="form-group">
        <form:label path="owner">Dojo: </form:label>
        <form:select path="owner" class="form-control">
  			<c:forEach var="eachDojo" items="${dojoList}">
  			<form:option value="${eachDojo.id}">
  			<c:out value="${eachDojo.name }"/>
  			<c:out value="${eachDojo.name }"/>
  			</form:option>
  			</c:forEach>c:forEach>
		</form:select>
      </div>
      <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
  </div>
  <a href="/dojos/new"><button class="btn btn-outline-primary">Home</button></a>
</html>

