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

<script type="text/javascript">
	function forEmail() {
		var firstEmail = document.getElementById("email");
		console.log(firstEmail.value);
		var errMsg = document.getElementById("errEmail");

		if (firstEmail.value != ' ' && firstEmail.value.length > 5
				&& firstEmail.value.length < 40) {
			errMsg.innerHTML = ''
		} else {
			errMsg.innerHTML = 'please enter email'
			errMsg.style.color = 'red'
		}
	}
</script>

<script>
	function forPassword() {
		var firstPassword = document.getElementById("password");
		console.log(firstPassword.value);
		var errMsg = document.getElementById("errPassword");

		if (firstPassword.value != '' && firstPassword.value.length < 5
				&& firstPassword.value.length > 30) {
			errMsg.innerHTML = ''
		} else {
			errMsg.innerHTML = 'please enter password'
			errMsg.style.color = 'red'
		}
	}
</script>


<title>Parking_Rental_System</title>
</head>

<nav class="navbar navbar-dark bg-primary">
	<span><img alt="10px" width="60px"
		src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqPoGR5m0Rhjf-uJa-jF-Kfam-ActZxqnylA&usqp=CAU"></span>

	<a class="navbar-brand" href="#"></a> <a class="navbar-brand" href="Parking.jsp">Home</a>

	<div class="container-fluid"></div>

</nav>

<div align="center">
	<body  class="col" style="background-color: silver;">
		<h3>SignIn hear</h3>
	

		<div class="container">

			<div class="row">

				<div class="col">.</div>

				<div >
					<div align="center">


						<form method="post" action="admin">

							<div class="col-md-6">
								<br> <label for="inputEmail4" class="form-label">Email</label>
								<input type="text" onchange="forEmail()" class="form-control"
									id="email" name=email><span id="errEmail"></span>
							</div>


							<div class="col-md-6">
								<br> <label for="inputEmail4" class="form-label">Password</label>
								<input type="password" onchange="forPassword()"
									class="form-control" id="password" name=password><span
									id="errPassword"></span>
							</div>
								
								<br>
							<div>
								<input type="submit" value="signIn" class="btn btn-dark">
							</div>

						</form>

					</div>
				</div>

				<div class="col">.</div>

			</div>

		</div>

		<div style="text-align: center">
			<nav class="navbar-dark bg-primary">
				<div style="margin-top: 430px" class="footer">
					<small>@2023 Copyright &copy; xworkx.com</small>
				</div>

			</nav>
		</div>

	</body>
</div>
</html>