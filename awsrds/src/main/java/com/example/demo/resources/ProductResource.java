package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/abc")
public class ProductResource {
	
	@Autowired
	ProductService service;
	@GetMapping("/retrieve/{ProductId}")
	public Product fetch(@PathVariable long Id) {
		return service.getproduct(Id);
	}

	@GetMapping
	@RequestMapping("/retrieve/all")
	public List<Product> fetchProducts(){
		return service.getProducts();
      }
	
	@PostMapping
	@RequestMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE,
									 produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> addProduct(@RequestBody Product product){
		Exception exception=null;
		Product tempProduct=null;
		try {
			tempProduct=service.add(product);
		}catch(Exception e) {
			exception=e;
		}
		 if(tempProduct!=null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
			}else {return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
		}
	}
}
