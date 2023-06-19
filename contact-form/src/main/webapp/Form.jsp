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

<script type="text/javascript">
	function forChar() {
		var firstName = document.getElementById("name");
		console.log(firstName.value);
		var errMsg = document.getElementById("errName");

		if (firstName.value != '' && firstName.value.length > 3
				&& firstName.value.length < 30) {
			errMsg.innerHTML = ''
		} else {
			errMsg.innerHTML = 'please enter name'
			errMsg.style.color = 'red'
		}
	}
</script>


<script type="text/javascript">
	function forEmail() {
		var firstEmail = document.getElementById("email");
		console.log(firstEmail.value);
		var errMsg = document.getElementById("errEmail");

		if (firstEmail.value != '' && firstEmail.value.length > 5
				&& firstEmail.value.length < 30) {
			errMsg.innerHTML = ''
		} else {
			errMsg.innerHTML = 'please enter email'
			errMsg.style.color = 'red'
		}
	}
</script>



</head>
<title>Insert title here</title>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a href="list">List</a>

			</div>
		</div>
	</div>
</nav>


<body style="background-color: silver;">

	<div>
		<a href="list">List all</a>
	</div>
	
	<br>
	
	<div>
	<a href="Search.jsp">Search hear</a>
	</div>

	<div class="container">

		<div class="row">

			<div class="col">.</div>

			<div class="col-6">
				<div align="center">


					<h1>Enter your contact details..</h1>


					<span style="color: green;">${msg}</span>

					<c:forEach items="${errors }" var="error">
						<span style="color: red;">${error.defaultMessage }</span>
					</c:forEach>


					<form method="post" action="form" enctype="multipart/form-data">

						<div class="col-md-6">
							<br> <label for="inputEmail4" class="form-label">Name</label>
							<input value="${dto.name}" type="text" onchange="forChar()"
								class="form-control" id="name" name=name> <span id="errName"></span>
						</div>


						<div class="col-md-6">
							<br> <label for="inputEmail4" class="form-label">Email</label>
							<input value="${dto.email}" type="text"   onchange="forEmail()"  class="form-control"
								id="email" name=email><span id="errEmail"></span>
						</div>


						<div class="col-md-6">
							<br> <label for="inputEmail4" class="form-label">MobileNo</label>
							<input value="${dto.mobileNo}" type="text" class="form-control"
								id="mobileNo" name=mobileNo>
						</div>

						<br>

						<div class="input-group">
							<br> <span class="input-group-text">Comments</span>
							<textarea class="form-control" aria-label="With textarea"
								id="comment" name="address"></textarea>
						</div>
						<br>
						<div>
							<input type="file" name="file">
						</div>
						<br>

						<div>
							<input type="submit" value="send">
						</div>

					</form>

				</div>
			</div>

			<div class="col">.</div>

		</div>

	</div>


</body>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</html>