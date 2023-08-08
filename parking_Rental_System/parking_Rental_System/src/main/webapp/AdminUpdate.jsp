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


<title>Parking_Rental_System</title>
</head>
<nav class="navbar navbar-dark bg-primary">
	<div class="container-fluid">
		<span><img alt="10px" width="60px"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqPoGR5m0Rhjf-uJa-jF-Kfam-ActZxqnylA&usqp=CAU"></span>
		<div style="margin-left: 100px">
		<a class="navbar-brand" href="#"></a> <a class="btn btn-dark" href="Parking.jsp">Home</a>
		<span
			style="color: black;">Admin Name:${dto1.name}</span>
	</div>
	</div>
	
</nav>
<body class="col" style="background-color: silver;">


	<div style="text-align: center">
	<h2>Enter reserve Information</h2>
	</div>
	<span style="color: green;">${sucess}</span>
	<span style="color: red">${error}</span>
	<span style="color: red">${dtoError}</span>

	<div class="container">
		<div class="row">
			<div class="col">.</div>
			<div class="col-6">

				<form method="post" action="update">

					Location: <select name="location" class="form-select"
						aria-label="Default select example">
						<option>select</option>
						<option value="Rajajinagar">Rajajinagar</option>
						<option value="BTM">BTM</option>
						<option value="Kengeri">Kengeri</option>
						<option value="Vijayanagr">Vijayanagr</option>
						<option value="Malleshwaram">Malleshwaram</option>
						<option value="megestic">megestic</option>
						<option value="chickpete">chickpete</option>
						<option value="K R Market">K R Market</option>
						<option value="RajarajeshwariNagar">RajarajeshwariNagar</option>

					</select> vehicaltype:<select name="vehicaltype" class="form-select" 
						aria-label="Default select example">
						<option>select</option>
						<option value="SUV">SUV</option>
						<option value="Hatchback">Hatchback</option>
						<option value="Station wagon">Station wagon</option>
						<option value="Sedan">Sedan</option>
						<option value="Minivan">Minivan</option>
						<option value="Crossover">Crossover</option>
						<option value="Coupe">Coupe</option>
						<option value="BMW">BMW</option>
						<option value="Maruthi800">Maruthi800</option>
						<option value="Bike">Bike</option>

					</select> vehical Classification:<select name="vehicalClassifications"
						class="form-select" aria-label="Default select example">
						<option>select</option>
						<option value="two-wheeler(fuel)">two-wheeler(fuel)</option>
						<option value="two-wheeler(electric)">two-wheeler(electric)</option>
						<option value="four-wheeler(electric)">four-wheeler(electric)</option>
						<option value="four-wheeler(fuel)">four-wheeler(fuel)</option>

					</select> Term:<select name="terms" class="form-select"
						aria-label="Default select example">
						<option>select</option>
						<option value="1-day">1-day</option>
						<option value="1-week">1-week</option>
						<option value="15-days">15-days</option>
						<option value="30-days">30-days</option>
						<option value="90-days">90-days</option>
						<option value="180-days">180-days</option>
						<option value="360-days">360-days</option>

					</select>

					<div>
						<label for="discount" class="form-label"></label> <input
							 class="form-control" id="discount" placeholder="Discount"
							aria-describedby="discount" name="discount">
						<div id="discount" class="form-text"></div>
					</div>

					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label"></label>
						<input type="price" class="form-control" id="price" name="price" placeholder="Price">
					</div>

					
					<input type="submit" class="btn btn-dark" value="Save">
				</form>

			</div>
			<div class="col">.</div>
		</div>
	</div>



	<div style="text-align: center">
		<nav class=" navbar-dark bg-primary">
				<div style="margin-top: 50px" class="footer">
					<small>@2023 Copyright &copy; ${dto1.email }</small>${dto1.loginTime}
				</div>
			
		</nav>
	</div>



</body>
</html>