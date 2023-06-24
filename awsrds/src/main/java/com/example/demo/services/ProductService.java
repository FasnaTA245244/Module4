package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.RepositoryIFace;
import com.example.demo.resource.Product;

public class ProductService {
	@Autowired
	RepositoryIFace repo;

	public Product getproduct(long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Product> getProducts() {
		return repo.findAll();
	}

	public Product add(Product product) {
		Product p=repo.save(product);
		return p;
	}

}
