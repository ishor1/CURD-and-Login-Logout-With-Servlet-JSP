package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Student;
import com.Helper.ConnectionProvider;
import com.dao.StudentDao;

public class UpdateStudent extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String enroll=req.getParameter("enrollmentNo");
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String course=req.getParameter("course");
		int fees=Integer.parseInt(req.getParameter("fees"));
		StudentDao dao=new StudentDao(ConnectionProvider.getConnection());
		Student st=dao.readStudentById(id);
		if(st.getId()==id) {
			st.setEnrollment(enroll);
			st.setName(name);
			st.setAddress(address);
			st.setCourse(course);
			st.setFee(fees);
			dao.updateStudent(st, id);
			res.sendRedirect("index.jsp");
		}
		else {
			out.print("sorry !!!Student Details not updated.....");
		}
	}

}
