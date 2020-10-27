package com.dxc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="student1")
public class student1 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer rollno;
	@Column (length=64)
private String name;
private double percentage;
private String department;


public student1()
{
	
}


public student1(String name, double percentage, String department) {
	super();
	this.name = name;
	this.percentage = percentage;
	this.department = department;
}


public Integer getRollno() {
	return rollno;
}


public void setRollno(Integer rollno) {
	this.rollno = rollno;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public double getPercentage() {
	return percentage;
}


public void setPercentage(double percentage) {
	this.percentage = percentage;
}


public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}


@Override
public String toString() {
	return "student1 [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + ", department=" + department
			+ "]";
}




}
