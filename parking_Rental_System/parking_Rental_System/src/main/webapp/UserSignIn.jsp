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


<title>Parking_Rental_System</title>
</head>
<body class="col" style="background-color: silver;">


	<!--  
<h1>OTP Verification Result</h1>
<p>${message }</p>
-->

	<nav class="navbar navbar-dark bg-primary">
		<div class="container-fluid">
			<span><img alt="10px" width="60px"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqPoGR5m0Rhjf-uJa-jF-Kfam-ActZxqnylA&usqp=CAU"></span>
			<a class="navbar-brand" href="#"></a> <a class="btn btn-dark"
				href="Parking.jsp">Home</a>

		</div>
	</nav>
	<div class="container">

		<div class="row">

			<div class="col">.</div>

			<div class="col-6">
				<div align="center">


					<form action="send-otp" method="post">

						<h3>Please enter email & Otp</h3>
						<br>
						<div>
							<div class="mb-3">
								<input type="email" name="email" placeholder="email"
									id="emailid" class="form-control"><br>
							</div>
							<button type="submit" value="send">SendOtp</button>
						</div>
					
					<br>
					
						<div>
							<div class="mb-3">
								<input type="text" name="emailOTP" placeholder="EnterOtp"
									class="form-control"><br>
							</div>
						</div>
						<button type="submit" value="send" href="UserSignIn.jsp">Submit</button>

					</form>





				</div>
			</div>

			<div class="col">.</div>

		</div>

	</div>

	<div style="text-align: center">
		<nav class="navbar-dark bg-primary">
			<div style="margin-top: 250px" class="footer">
				<small>@2023 Copyright &copy; xworkx.com</small>
			</div>

		</nav>
	</div>

</body>
</html>