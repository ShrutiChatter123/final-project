<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Parking_Rental_System</title>
</head>

<script type="text/javascript">
function ajaxforuser() {
	console.log("ajaxforuser logged in");
	var location=document.getElementById("location").value;
	var vehicaltype=document.getElementById("vehicaltype").value;
	var vehicalClassifications=document.getElementById("vehicalClassifications").value;
	var terms=document.getElementById("terms").value;

	var url = "http://localhost:8082/parking_Rental_System/getpriceDiscount/" + location + "/" + vehicaltype + "/" + vehicalClassifications + "/" + terms;
	console.log(url);
	const xmlHttp=new XMLHttpRequest();
	xmlHttp.open("GET",url);
	xmlHttp.send();
	xmlHttp.onload=function(){
		document.getElementById("Display").innerHTML=this.responseText;
		console.log(this.responseText);
		var obj = JSON.parse(this.responseText);
		console.log(obj.price);
		console.log(obj.discount)
		document.getElementById("price").value=obj.price;
		document.getElementById("discount").value=obj.discount;
		var total = obj.price-((obj.price*obj.discount)/100);
		document.getElementById("total").value=total;
		console.log(total)

	}
		
}

</script>



<script type="text/javascript">

function EmailAjax() {
	
	console.log("EmailAjax login")
	var email=document.getElementById("emailid").value;
	var url="http://localhost:8082/parking_Rental_System/validateEmailForOpt/"+email;
	console.log(url);
	const xmlHttp=new XMLHttpRequest();
	xmlHttp.open("GET",url);
	xmlHttp.send();
	xmlHttp.onload=function(){
		console.log(this.responseText);
		document.getElementById("Display").innerHTML=this.responseText;
	}
		
}

</script>


<body class="col" style="background-color: silver;">
	<nav class="navbar navbar-dark bg-primary">
		<div class="container-fluid">
			<span><img alt="10px" width="60px"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqPoGR5m0Rhjf-uJa-jF-Kfam-ActZxqnylA&usqp=CAU"></span>
			<div style="margin-left: 100px">
				<a class="navbar-brand" href="#"></a> <a class="btn btn-dark"
					href="Parking.jsp">Home</a>
			</div>
		</div>

	</nav>
	<h3>User Information..</h3>
	<div class="container">
		<div class="row">
			<div class="col">.</div>

			<div class="col-6">

				<form method="post" action="user"  >
				
				<span  id="Display" >
				
				
				
				</span>
				
					<div class="mb-3">
						<input type="text" name="name" placeholder="name"
							class="form-control"><br>
					</div>

					<div class="mb-3">
						<input type="email" name="email" placeholder="email" id="emailid" onchange="EmailAjax()"
							class="form-control" >
					</div>

					<div class="mb-3">
						<input type="text" name="mobile" placeholder="mobile"
							class="form-control"><br>
					</div>
					<div class="mb-3">
						Location: <select name="location" id="location"
							class="form-select" aria-label="Default select example">
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
					</div>
					<div class="mb-3">
						vehicaltype:<select name="vehicaltype" id="vehicaltype"
							class="form-select" aria-label="Default select example">
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

						</select>
					</div>
					<div class="mb-3">
						vehical Classification:<select name="vehicalClassifications"
							id="vehicalClassifications" class="form-select"
							aria-label="Default select example">
							<option>select</option>
							<option value="two-wheeler(fuel)">two-wheeler(fuel)</option>
							<option value="two-wheeler(electric)">two-wheeler(electric)</option>
							<option value="four-wheeler(electric)">four-wheeler(electric)</option>
							<option value="four-wheeler(fuel)">four-wheeler(fuel)</option>

						</select>
					</div>

					<div class="mb-3">
						Term:<select name="terms" class="form-select" id="terms" onchange="ajaxforuser()"
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
					</div>

					<div class="mb-3">
						<label for="price" class="form-label"></label> price:<input type="text"
							class="form-control" id="price" name="price"  readonly="readonly"
							placeholder="price">
					</div>

					<div>
						<label for="discount" class="form-label"></label>discount: <input
							type="text" class="form-control"  id="discount" readonly="readonly"
							placeholder="Discount" aria-describedby="discount"
							name="discount">
						<div id="discount" class="form-text"></div>
					</div>
					
					<div class="mb-3">
						<label for="vehicalNumber" class="form-label"></label>vehicalNumber: <input type="text"
							class="form-control" id="vehicalNumber" name="vehicalNumber" 
							placeholder="vehicalNumber">
					</div>

					<div class="mb-3">
						<label for="total" class="form-label"></label>Total: <input type="text"
							class="form-control" id="total" value="${dto2.total}" name="total" 
							placeholder="total">
					</div>

					Aggrement:<input type="radio" name="aggrement" id="aggrement"  onchange="document.getElementById('saved').disabled=!this.checked">
					
					
					<br> <input type="submit" class="btn btn-dark" value="Save" id="saved" disabled="disabled" >

				</form>


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