package com.spring.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.ResponseObject;
import com.spring.demo.model.User;
import com.spring.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
//		if(user.getAge() == null|| user.getFirstName() == null || user.getLastName() == null) {
//			return  new ResponseObject(HttpStatus.BAD_REQUEST,"Unable To Save",null);
//		}else {
//		 User userDetails = studentService.saveDetails(user);
//		
//			 ResponseObject object = new ResponseObject(HttpStatus.OK,"Saved Successfully",userDetails);
//			 return object;
//		 }
	 HashMap<String, Object> response = new HashMap<>();
		try {
			User userDetails = studentService.saveDetails(user);
			response.put("succes", userDetails);
		return new ResponseEntity<Object>(userDetails, HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			
			response.put("succes", "internal error");
			
			return new ResponseEntity<Object>(response, HttpStatus.ACCEPTED);
			

		}
	
	}
	
	@GetMapping("/getUser")
	public List<User> getUsers(){
		return studentService.getUsers();
	}
}
