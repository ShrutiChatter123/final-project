<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<title>Search</title>
</head>
<body>

<h1>Search name</h1>
<form  method="get" action="search">

Name:<input type="text" name="name">

<input type="submit" value="Search" class="btn-sucess">

</form>


<table class="table">
<tr>
<th>name</th>
<th>email</th>
<th>mobileNo</th>
<th>file</th>


</tr>

<c:forEach items="${list}" var="dto">
<tr>
<td>${dto.name }</td>
<td>${dto.email }</td>
<td>${dto.mobileNo }</td>

</tr>


</c:forEach>

</table>





</body>
</html>