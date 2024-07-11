package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Student;

public class StudentDao {
	private Connection con;

	public StudentDao(Connection con) {
		this.con = con;
	}
	
	public boolean saveStudent(Student student) {
		String query="insert into student(enrollmentno, name, address, course, fees) values (?,?,?,?,?)";
		boolean check=false;
		try {
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, student.getEnrollment());
			psmt.setString(2, student.getName());
			psmt.setString(3, student.getAddress());
			psmt.setString(4, student.getCourse());
			psmt.setInt(5, student.getFee());
			psmt.executeUpdate();
			check=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return check;
		
	}
	public boolean deleteStudent(int id) {
		boolean check=false;
		try {
		PreparedStatement psmt=con.prepareStatement("delete from student where id=?");
		psmt.setInt(1, id);
		psmt.executeUpdate();
		check=true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return check;
	}
	
	public boolean updateStudent(Student st,int id) {
		boolean check=false;
		try {
			
		PreparedStatement psmt=con.prepareStatement("update student set enrollmentno=?,name=?,address=?,course=?,fees=? where id=?");
		psmt.setString(1, st.getEnrollment());
		psmt.setString(2,st.getName());
		psmt.setString(3, st.getAddress());
		psmt.setString(4, st.getCourse());
		psmt.setInt(5, st.getFee());
		psmt.setInt(6, id);
		psmt.executeUpdate();
		check=true;
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return check;
	}
	
	
	
	public List<Student> readStudent(){
		ArrayList<Student> list=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select *from Student");
			while(rs.next()) {
				Student s=new Student(rs.getInt("id"),rs.getString("enrollmentno"),rs.getString("name"),rs.getString("address"),rs.getString("course"),rs.getInt("fees"));
				list.add(s);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	public Student readStudentById(int id){
		Student s=new Student();
		try {
			Statement st=con.createStatement();
			ResultSet rs =st.executeQuery("select *from Student where id="+id);
			if(rs.next()) {
					s.setId(rs.getInt("id"));
				 s.setEnrollment(rs.getString("enrollmentno"));
				 s.setName(rs.getString("name"));
				 s.setAddress(rs.getString("address"));
				 s.setCourse(rs.getString("course"));
				 s.setFee(rs.getInt("fees"));
				
 
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
	
	
	
}
