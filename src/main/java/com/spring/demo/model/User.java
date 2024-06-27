package com.spring.demo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(nullable = false)
	private String firstName;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String age;
	
	public String getAge() {
		return age;
	}
	
	private String date = getCurrentDateTime();
	
	 public static String getCurrentDateTime() {
		 Date now = new Date();
	        
	        // Define the desired date-time format
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	        // Format the current date-time
	        return formatter.format(now);
	    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAge(String age) {
		this.age = age;
	}

	private String lastName;
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User() {
		super();
	}
	
	
	private Integer isDelete = 0;
	
	

	public User(Long id, String firstName, String age, String lastName,Integer isDelete) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.lastName = lastName;
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	
	
	
	
	
}
