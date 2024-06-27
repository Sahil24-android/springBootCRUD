package com.spring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.model.User;
import com.spring.demo.repository.StudentRepo;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepo studentRepository;
	
	public User saveDetails(User user) {
		User userDetails =  studentRepository.save(user);
		if (userDetails != null) {
			return userDetails;
		}else {
			return new User();
		}
	}
	
	public List<User> getUsers(){
		return studentRepository.findAll();
	}
}
