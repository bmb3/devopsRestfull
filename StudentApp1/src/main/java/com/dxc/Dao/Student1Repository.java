package com.dxc.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.entity.student1;

public interface Student1Repository extends JpaRepository<student1, Integer> {

	public student1 findByName(String name);
}
