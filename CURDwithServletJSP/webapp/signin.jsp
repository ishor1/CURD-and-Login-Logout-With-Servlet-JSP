<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in page</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container-fluid">
<div class="row">
<!-- form start -->
	<div class="container d-flex flex-wrap justify-content-center">
		<div class="form-div border mt-3 p-3 mx-5">
			<h2 class="text-center">signin Here</h2>
			<hr>
			<form action="signin" method="Post">
				<div class="mb-1">
					<label for="exampleInputEmail1" class="form-label">Enrollment
						Number:</label> <input type="text" name="enrollmentNo" class="form-control"
						aria-describedby="emailHelp">

				</div>
				<div class="mb-1">
					<label for="exampleInputPassword1" class="form-label">Name</label>
					<input type="text" name="name" class="form-control"
						id="exampleInputPassword1">
				</div>
			
				<div class="text-center">
					<button type="submit" class="btn btn-primary">sign in</button>
				</div>
			</form>
		</div>
		
			</div>
		</div>

	</div>
	<!-- form end -->
</body>
</html>