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
    <title>Create Dojo</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
   <h1 style="text-align: center;" >Create New Dojo</h1>
   <div class="container" style="margin: 0 auto;" >
    <form:form class="border rounded p-3" style="width: 500px;" action="/dojos/create" method="post" modelAttribute="newDojo">
      <div class="form-group">
        <form:label path="name"> Name </form:label>
        <form:input  path="name" type="text" class="form-control"  placeholder="Enter your name"/>
        <form:errors path="name" />
      </div>
      <button type="submit" class="btn btn-outline-primary">Create</button>
    </form:form>
  </div>
  <a href="/ninjas/new" ><button class="btn btn-outline-primary">Create Ninja</button></a>
</body>
</html>

