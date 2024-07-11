package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Student;
import com.Helper.ConnectionProvider;
import com.dao.StudentDao;


public class SaveStudent extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out=res.getWriter();
		String rollNo=req.getParameter("enrollmentNo");
		String userName=req.getParameter("name");
		String userAddress=req.getParameter("address");
		String userCourse=req.getParameter("course");
		int userFees=Integer.parseInt(req.getParameter("fees"));

		Student st=new Student(rollNo,userName,userAddress,userCourse,userFees);
		StudentDao dao=new StudentDao(ConnectionProvider.getConnection());
		boolean check=dao.saveStudent(st);
		if(check) {
			res.sendRedirect("index.jsp");
			
		}
		else {
			out.print("sorry something went wrong....");
		}
		
	}

}
