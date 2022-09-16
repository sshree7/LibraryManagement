<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Login Form</title>
<style>
#container {
	position: fixed;
	top: 50%;
	left: 50%;
	width: 30em;
	height: 18em;
	margin-top: -9em; /*set to a negative number 1/2 of your height*/
	margin-left: -15em;
}
</style>
</head>
<body>



	<div  class="container mt-5">

		<h3 class="text-center">Login Here..</h3>
		<p class="text-center"></p>

		<div  class="container mt-5" style="display: block;
    text-align: center;"><form style="display: inline-block;  height: 40px; width: 400px;" action="welcome" method="post">


			<div style="text-align:left;" class="form-group">
				<label  for="username">User Name</label> <input type="text"
					class="form-control" name="username" id="username"
					aria-describedby="emailHelp" placeholder="Enter User Name" required>
			</div>

			<div style="text-align:left;" class="form-group">
				<label for="password">User Password</label> <input type="password"
					class="form-control" name="password" id="password"
					aria-describedby="emailHelp" placeholder="Enter Password" required>
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Go</button>
			</div>


		</form></div>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>