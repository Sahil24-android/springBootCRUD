package com.spring.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.model.Grocery;
import com.spring.demo.repository.GroceryRepository;

@Service
public class GroceryService {

	
	@Autowired
	private GroceryRepository groceryRepository;
	
	public Grocery saveGrocery(Grocery grocery) {
		Grocery groceryItem =  groceryRepository.save(grocery);
		if (groceryItem != null) {
			return groceryItem;
		}else {
			return new Grocery();
		}
	}
	
	public List<Grocery> getProductByType(String productType){
		return groceryRepository.findByProductType(productType);
	}
	
	public List<Grocery> getAllProducts(){
		return groceryRepository.findAll();
	}
	
	public Optional<Grocery> getProductById(Long id) {
		return groceryRepository.findById(id);
	}
	
	public Boolean deleteItemById(Long id){
		groceryRepository.deleteById(id);
		return true;
	}
	
	
	
	
}
