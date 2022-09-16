<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@page
	import="com.nagarro.training.librarianMvc.service.LibraryServiceImpl"%>
<%@page import="com.nagarro.training.librarianMvc.domain.User"%>
<%@page import="com.nagarro.training.librarianMvc.dto.BookDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jstl/core"%>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-validate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="en">
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
<title>Welcome</title>
</head>
<body>

	<div class="container mt-1" style="padding: 5px; background: #f8f8ff;">
		<header style="text-align: right;">

			<form action="logout">
				<input type="submit" class="btn btn-primary" value="logout">
			</form>
		</header>
	</div>


	<div class="container mt-1">
		<br>
		<h3 class="text-center">Book Listing..</h3>

		<p class="text-center"></p>

		<div style="text-align: right; padding-right: 30px;">
			<form action="addBook" method="post">

				<input type="submit" class="btn btn-primary" value="Add Book">

			</form>
		</div>
		<div class="container mb-5 mt-5">
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th style="text-align: center" scope="col">Book Code</th>
							<th style="text-align: center" scope="col">Book Name</th>
							<th style="text-align: center" scope="col">Author</th>
							<th style="text-align: center" scope="col">Date Added</th>
							<th style="text-align: center" scope="col">Actions</th>

						</tr>
					</thead>
					<tbody>

						<%
						LibraryServiceImpl libraryService = new LibraryServiceImpl();
						List<BookDto> bookList = libraryService.getAllBooks();
						for (final BookDto book : bookList) {
							int bookId = book.getId();
						%>


						<c:url var="deleteLink"
							value="${pageContext.request.contextPath}/delete/">
							<c:param name="id" value="${book.getId()}" />
						</c:url>
						<c:out value="${book.getId()}" />
						<tr>
							<td style="text-align: center"><%=book.getId()%></td>
							<td style="text-align: center"><%=book.getTitle()%></td>
							<td style="text-align: center"><%=book.getAuthor()%></td>
							<td style="text-align: center"><%=book.getDate()%></td>
							<td style="text-align: center"><a
								href="/editBook?id=<%=book.getId()%>" style="line-height: 10px;"
								class="btn btn-primary">Edit</a> <a
								href="delete?id=<%=book.getId()%>" style="line-height: 10px;"
								class="btn btn-danger">Delete</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>


		</div>

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