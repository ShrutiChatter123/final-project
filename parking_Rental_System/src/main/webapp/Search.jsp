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
		<a class="navbar-brand" href="#"></a> <a class="navbar-brand" href="#">X-workz</a>

	</div>
</nav>
<body class="col" style="background-color: silver;">

	<div class="container">

		<div class="row">

			<div class="col">.</div>

			<div class="col-6">
				<div align="center">


					<h3>SEARCH YOUR LOCATION TABLE</h3>

					<form method="get" action="search">

						location:<select name="location" id="location">

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
						</select>
						<button type="submit" value="search">Search</button>
					</form>

					<table class="table table-bordered border-primary">

						<thead>
							<tr>
								<th scope="col">id</th>
								<br>
								<th scope="col">location</th>
								<br>
								<th scope="col">vehicaltype</th>
								<br>
								<th scope="col">vehicalClassifications</th>
								<br>
								<th scope="col">terms</th>
								<br>
								<th scope="col">price</th>
								<br>
								<th scope="col">discount</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${list}" var="dto">

								<tr>
									<td>${dto.id}</td>
									<td>${dto.location}</td>
									<td>${dto.vehicaltype}</td>
									<td>${dto.vehicalClassifications}</td>
									<td>${dto.terms}</td>
									<td>${dto.price}</td>
									<td>${dto.discount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


				</div>
			</div>

			<div class="col">.</div>

		</div>

	</div>

	<div style="text-align: center">
		<nav class=" navbar-dark bg-primary">
			<div style="margin-top: 250px" class="footer">
				<small>@2023 Copyright &copy; xworkx.com</small>
			</div>

		</nav>
	</div>


</body>
</html>