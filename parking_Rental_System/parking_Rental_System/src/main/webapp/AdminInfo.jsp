<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<title>Admin info</title>
</head>
<nav class="navbar navbar-dark bg-primary">
	<div class="container-fluid">
		<span><img alt="10px" width="60px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqPoGR5m0Rhjf-uJa-jF-Kfam-ActZxqnylA&usqp=CAU"></span>
		<div style="margin-left: 100px">
		<a class="btn btn-dark" href="Admin.jsp">Logout</a> <span
			style="color: black;">Admin Name:${dto1.name}</span>
	</div>
	</div>
</nav>

<body style="background-color: silver;">

	<div>
		<div style="text-align: left;">
			<!--  form action="update" method="post"> -->
				<a class="btn btn-dark" type="submit" href="AdminUpdate.jsp"
					role="submit">update info</a> 
				<a class="btn btn-dark "
					type="submit" href="Search.jsp" role="submit">View</a>
			<!-- </form> -->
		</div>

	</div>

	<div class="container">

		<div class="row">

			<div class="col">.</div>

			<div class="col-6">
				<div align="center">

					


				</div>
			</div>

			<div class="col">.</div>

		</div>

	</div>


		<div style="text-align: center">
			<nav class="navbar-dark bg-primary">
				<footer style="margin-top: 450px" class="footer">
					<small>@2023 Copyright &copy; xworkx.com</small>${dto1.loginTime}
				
				</footer>

			</nav>
		</div>

</body>


</html>

