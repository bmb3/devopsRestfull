package com.dxc.Controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.Service.Student1Service;
import com.dxc.entity.student1;

@RestController
public class Student1Controller 
{
	@Autowired
	private Student1Service service;
	
	// RESTful API methods for Retrieval operations	
	@GetMapping("/student1")
	public List<student1> list() {
		return service.getAllStudents();
	}
	
	
	@GetMapping("/student1/{rollno}")
	public ResponseEntity<student1> get(@PathVariable Integer rollno) {
	    try {
	        student1 student = service.get(rollno);
	        return new ResponseEntity<student1>(student, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<student1>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	// RESTful API method for Create operation
	 @PostMapping("/student1")
	public void add(@RequestBody student1 createstudent) {
	    service.save(createstudent);
	}
	 
	 
	// RESTful API method for Update operation
	@PutMapping("/student1/{rollno}")
	public ResponseEntity<?> update(@RequestBody student1 updatestudent, @PathVariable Integer rollno) {
	    try {
	        student1 existProduct = service.get(rollno);
	        service.save(updatestudent);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	// RESTful API method for Delete operation
	@DeleteMapping("/student1/{rollno}")
	public void delete(@PathVariable Integer rollno) {
	    service.delete(rollno);
	}


}
