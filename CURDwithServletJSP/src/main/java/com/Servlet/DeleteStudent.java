package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Helper.ConnectionProvider;
import com.dao.StudentDao;

public class DeleteStudent extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao(ConnectionProvider.getConnection());
		boolean check=dao.deleteStudent(id);
		if(check) {
			res.sendRedirect("index.jsp");
		}
		else {
		out.print("Sorryt !Student not delete......");
		}
	
	
	
	}

}
