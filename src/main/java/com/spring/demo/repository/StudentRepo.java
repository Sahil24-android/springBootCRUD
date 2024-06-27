package com.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.User;

public interface StudentRepo extends JpaRepository<User, Long>{
	

}
