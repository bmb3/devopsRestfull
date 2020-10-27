package com.dxc.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.Dao.Student1Repository;
import com.dxc.entity.student1;

@Service
@Transactional
public class Student1Service 
{
	@Autowired
	private static Student1Repository repo;
	
    public List<student1> getAllStudents(){
    	List<student1> allStudents=new ArrayList<student1>();
    	repo.findAll().forEach(allStudents::add);
    	return allStudents;
    }
	
	public static student1 addStudent(student1 student)
	 {
		return repo.save(student);
	 }
	 
	 public void save(student1 student) 
	{
		repo.save(student);
	}
	
	public student1 get(Integer rollno) 
	{
		return repo.findById(rollno).get();
	}
	
	
	public student1 updateStudent(Integer Rollno, student1 student)
	{
		student1 updatedStudent=new student1();
    	Integer reqRollno = Rollno;
		String name = student.getName();
		Double percentage = student.getPercentage();
		String department = student.getDepartment();
		updatedStudent.setRollno(reqRollno);
		updatedStudent.setName(name);
		updatedStudent.setPercentage(percentage);
		updatedStudent.setDepartment(department);
		return repo.save(updatedStudent);
    }
	
	
	public void delete(Integer rollno) 
	{
		repo.deleteById(rollno);
	}
}
