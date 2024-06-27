package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.model.Grocery;
import com.spring.demo.model.ResponseObject;
import com.spring.demo.service.GroceryService;


@RestController
@RequestMapping("/product")
public class GroceryController {
	
	@Autowired
	private GroceryService groceryService;

	@GetMapping("/getProductByType")
	public ListResponseGrocery getProductDetails(@RequestParam String productType){
		try {
			List<Grocery> groceryList = groceryService.getProductByType(productType);
			return new ListResponseGrocery(HttpStatus.OK, "Data Found" ,groceryList);
		}catch(Exception e) {
			return new ListResponseGrocery(HttpStatus.BAD_REQUEST, "Not Fount",null );
			
		}
	}
	
	
	@GetMapping("/getProduct")
	public ListResponseGrocery getAllProduct(){
		try {
			List<Grocery> groceryList = groceryService.getAllProducts();
			return new ListResponseGrocery(HttpStatus.OK, "Data Found" ,groceryList);
		}catch(Exception e) {
			return new ListResponseGrocery(HttpStatus.BAD_REQUEST, "Not Fount",null );
			
		}
	}
	

	
	
	
	
	@PostMapping("/addProduct")
	public ResponseObject addProduct(@RequestBody Grocery grocery){
		 try {
			 Grocery groceryDetails = groceryService.saveGrocery(grocery);
				 return new ResponseObject(HttpStatus.OK, "Product Added Successfully" , groceryDetails);
		 }catch(Exception e){
			 return new ResponseObject(HttpStatus.BAD_GATEWAY, "Enable To Add Product",null);
		 }
	}
	
	@GetMapping("/{id}")
	public ResponseObject getProductById(@PathVariable Long id) {
		try {
			Grocery grocery = groceryService.getProductById(id).orElse(null);
			return new ResponseObject(HttpStatus.OK, "Fetch Successfully", grocery);
			
		}catch(Exception e) {
			return new ResponseObject(HttpStatus.BAD_GATEWAY, "Enable To get Product",null);
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseObject updateProductById(@PathVariable Long id,@RequestBody Grocery item) {
		try {
			ResponseObject object = getProductById(id);
			if(object.getObj() !=null) {
				Grocery old = (Grocery) object.getObj();
				old.setProductName(item.getProductName() !=null && !item.getProductName().equals("") 
						? item.getProductName()  : old.getProductName());
				old.setProductPrice(item.getProductPrice() !=null && !item.getProductPrice().equals("") 
						? item.getProductPrice()  : old.getProductPrice());
				old.setProductType(item.getProductType() !=null && !item.getProductType().equals("") 
						? item.getProductType()  : old.getProductType());	
			groceryService.saveGrocery(old);
			return new ResponseObject(HttpStatus.OK, "updated Successfully", old);
			}
		
		}catch(Exception e) {
			return new ResponseObject(HttpStatus.BAD_GATEWAY, "Enable To update Product",null);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public ResponseObject deleteProductById(@PathVariable Long id) {
		try {
			ResponseObject object = getProductById(id);
			if(object.getObj() !=null) {
				groceryService.deleteItemById(id);
				return new ResponseObject(HttpStatus.OK, "Deleted Successfully", object.getObj());
			}else {
				return new ResponseObject(HttpStatus.NOT_FOUND, "Product Not Found for "+ id,null);
			}
			
		}catch(Exception e) {
			return new ResponseObject(HttpStatus.BAD_GATEWAY, "Enable To delete Product",null);
		}
	}
	
	
	


class ListResponseGrocery {

	
	private HttpStatus responseCode;
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	
	
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	private List<Grocery> data;
	public List<Grocery> getData() {
		return data;
	}
	public void setData(List<Grocery> data) {
		this.data = data;
	}
	public ListResponseGrocery(HttpStatus responseCode, String msg, List<Grocery> data) {
		super();
		this.responseCode = responseCode;
		this.msg = msg;
		this.data = data;
	}
	public ListResponseGrocery() {
		super();
	}
	
}
	
}


