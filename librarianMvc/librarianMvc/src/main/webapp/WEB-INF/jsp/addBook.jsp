<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import = "java.util.*" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Add Book</title>
</head>
<body>
	<div style="padding: 5px; background: #f8f8ff;">
		<header style="text-align: right;">

			<form action="logout">
				<input type="submit" class="btn btn-primary" value="logout">
			</form>
		</header>
	</div>

	<div class="center">
		<h4 style="text-align: center;">Add Book Details</h4>
		<form class="container mt-3" style="height: 40px; width: 400px;"
			action="addForm" method="post">


			<div class="form-group">
				<label for="id">Book Code</label> <input type="text"
					class="form-control" name="id" id="id"
					placeholder="Enter the book code here.." required>
			</div>

			<div class="form-group">
				<label for="title">Book Name</label> <input type="text"
					class="form-control" name="title" id="title"
					placeholder="Enter the book name here.." required>
			</div>

			<div class="form-group">
				<label for="author">Author</label> &nbsp; &nbsp; <select
					name="author" id="author">
					<option  value="Robert Greene">Robert Greene</option>
					<option value="Jordan B Peterson">Jordan B Peterson</option>
					<option value="Robert Kiyosaki">Robert Kiyosaki</option>
					<option value="Dan Brown">Dan Brown</option>
				</select>
			</div>

			<div class="form-group">
				<label for="date">Date</label><%Date today = new Date ();
						
						
						%>
				<input type="text"
					class="form-control" name="date" id="date"
					value="${today}" > 
			</div>

			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Enter
					Book</button>
					
					 <a href="${pageContext.request.contextPath}/welcome" class = "btn btn-outline-danger">Back</a>
			</div>


		</form>
	</div>
</body>
</html>