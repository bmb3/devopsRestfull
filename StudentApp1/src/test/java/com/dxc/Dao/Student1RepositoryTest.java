package com.dxc.Dao;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dxc.Controllers.Student1Controller;
import com.dxc.entity.student1;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Student1RepositoryTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
   Student1Controller student1controller;
	
	@Test
	public void getAllStudents() 
	{
	    try {
			mockMvc.perform(get("/student1").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

	
	



