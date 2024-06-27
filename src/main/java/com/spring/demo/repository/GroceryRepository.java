package com.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.model.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
	
	public List<Grocery> findByProductType(String productType);

}
