<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
    

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">



</head>
<body>

<h1>This is your table information</h1>

<table class="table" id="customer">
<tr>

<th>name</th>
<th>email</th>
<th>mobileNo</th>
<th>file</th>

</tr>

<c:forEach items="${dtos}" var="dto">
<tr>
<td>${dto.name}</td>
<td>${dto.email}</td>
<td>${dto.mobileNo}</td>



 <td><a target="_blank" href="fileDownload?FileName=${dto.fileName }&contentType=${dto.contentType}">${dto.fileName}</a></td>

</tr>


</c:forEach>


</table>
</body>
</html>