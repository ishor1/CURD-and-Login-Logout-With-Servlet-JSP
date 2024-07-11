package com.Entity;

public class Student {
private int id;
private String enrollment;
private String name;
private String address;
private String course;
private int fee;

public String getEnrollment() {
	return enrollment;
}
public void setEnrollment(String enrollment) {
	this.enrollment = enrollment;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public Student() {
	super();
}



public Student(String enrollment, String name, String address, String course, int fee) {
	super();
	this.enrollment = enrollment;
	this.name = name;
	this.address = address;
	this.course = course;
	this.fee = fee;
}
public Student(int id, String enrollment, String name, String address, String course, int fee) {
	super();
	this.id = id;
	this.enrollment = enrollment;
	this.name = name;
	this.address = address;
	this.course = course;
	this.fee = fee;
}



}
