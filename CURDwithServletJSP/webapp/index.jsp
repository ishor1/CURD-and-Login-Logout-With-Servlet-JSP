<%@page import="java.util.ArrayList"%>
<%@page import="com.Entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDao,com.Helper.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%
	Student std=(Student)session.getAttribute("student");
	
	if(std==null){
		response.sendRedirect("home.jsp");
	}
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index Page</title>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
	<%@ include file="navbar.jsp" %>

	<!-- form start -->
	<div class="container d-flex flex-wrap justify-content-center">
		<div class="form-div border mt-3 p-3 mx-5">
			<h2 class="text-center">Student Details</h2>
			<hr>
			<form action="saveStudent" method="Post">
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
				<div class="mb-1">
					<label for="exampleInputPassword1" class="form-label">Address</label>
					<input type="text" name="address" class="form-control"
						id="exampleInputPassword1">
				</div>
						<div class="mb-1">
					<label for="exampleInputPassword1" class="form-label">course</label>
					<input type="text" name="course" class="form-control"
						id="exampleInputPassword1">
				</div>
				<div class="mb-1">
					<label for="exampleInputPassword1" class="form-label">Fees</label>
					<input type="text" name="fees" class="form-control"
						id="exampleInputPassword1">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
		<div class="showData border mt-3 p-3">
			<h3 class="text-center">Show All Student</h3>
			<hr>
			<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Sno</th>
						<th scope="col">RollNo</th>
						<th scope="col">Name</th>
						<th scope="col">Address</th>
						<th scope="col">Course</th>
						<th scope="col">Fees</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<%
					StudentDao dao = new StudentDao(ConnectionProvider.getConnection());
					List<Student> list = dao.readStudent();
							int i=1;
					for (Student st : list) {
					%>


					<tr>
						<th scope="row"><%=i++ %></th>
						<td><%=st.getEnrollment()%></td>
						<td><%=st.getName()%></td>
						<td><%=st.getAddress()%></td>
						<td><%=st.getCourse() %>
						<td><%=st.getFee()%></td>
						<td><a class="btn btn-sm btn-warning text-white" href="EditStudent.jsp?id=<%=st.getId()%>">
						edit
						<i class="fa-solid fa-pencil"></i></a></td>
						
						<td><a class="btn btn-sm btn-danger" href="delete?id=<%=st.getId()%>">delete</a></td>
					</tr>




					<%
					}
					%>
				</tbody>
			</table>
			</div>
		</div>

	</div>
	<!-- form end -->

	
	
	</div>
	</div>





</body>
</html>