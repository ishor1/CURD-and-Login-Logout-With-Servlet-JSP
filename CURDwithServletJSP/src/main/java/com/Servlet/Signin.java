package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Entity.Student;
import com.Helper.ConnectionProvider;
import com.dao.UserDao;

public class Signin extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out=res.getWriter();
		String enrollmentNo=req.getParameter("enrollmentNo");
		String userName=req.getParameter("name");
	
		UserDao dao=new UserDao(ConnectionProvider.getConnection());
		Student student=dao.UserByNameAndEnrollmentNo(userName, enrollmentNo);
		if(student !=null && student.getName()!=null) {
HttpSession session=req.getSession();
session.setAttribute("student", student);
			
			res.sendRedirect("index.jsp");
			
		}
		else {
			out.print("sorry something went wrong....");
		}
		
		
		
	}
}
