package com.dxc.Dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.dxc.Dao.Student1Repository;
import com.dxc.entity.student1;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class Student1Tests
{
@Autowired
private Student1Repository repo;

@Test
@Rollback(false)
@Order(1)
public void testCreateStudent1()
{
	student1 student=new student1("bmb",70,"TCE");
	student1 savestudent1 = repo.save(student);
	
	assertNotNull(savestudent1);
}

@Test
@Order(2)
public void testFindStudentByNameExist()
{
	String name = "bmb";
	student1 student = repo.findByName(name);
	
	assertThat(student.getName()).isEqualTo(name);
}

@Test
@Order(3)
public void testFindStudentByNameNotExist()
{
	String name = "bmb1";
	student1 student = repo.findByName(name);
	
	assertNull(student);
}

@Test
@Rollback(false)
@Order(4)
public void testUpdateStudent()
{
	String name = "yyy";
	student1 student = new student1(name,88,"ECE");
	student.setRollno(5);
	repo.save(student);
	
	student1 updatestudent = repo.findByName(name);
	assertThat(updatestudent.getName()).isEqualTo(name);
}
@Test
@Order(5)
public void testListsStudents()
{
	List<student1> students = (List<student1>) repo.findAll();
	for(student1 student : students)
		System.out.println(student);
		
	assertThat(students.size()).isGreaterThan(0);
}
@Test
@Rollback(false)
@Order(6)
public void testDeleteStudent()
{
	Integer rollno = 3;
	boolean isExistBeforeDelete = repo.findById(rollno).isPresent();
	repo.deleteById(rollno);
	
	boolean notExistAfterDelete = repo.findById(rollno).isPresent();
	assertTrue(isExistBeforeDelete);
	assertFalse(notExistAfterDelete);
}

}
