package com.ebin.enterprise.billing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebin.enterprise.billing.dao.ProductRepo;
import com.ebin.enterprise.billing.model.Product;


@Service
public class ProductService {
	@Autowired
	ProductRepo productRepo;

	public String addProduct(Product product) {
		productRepo.save(product);
		return product + "  Inserted Successfully";

	}

	public String findByProduct(int productID) {
		Optional<Product> product = productRepo.findById(productID);
		if (product == null) {
			return "productID" + productID + " doesn't Exists";
		}
		return product + " Exists";
	}

	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	public Product findById(int productID) {
		Product product = productRepo.findById(productID).orElse(null);
		return product;
	}

	public Product updateProduct(int productID, Product product) {
		Product productResult = this.findById(productID);
		Product productEntity = null;
		if (checkProduct(productResult)) {
			productResult.setProductName(product.getProductName());
			productEntity = productRepo.save(productResult);
			
		}
		return productEntity;

	}
	public String deleteProduct(int productID) {
		Product productResult = this.findById(productID);
		if (checkProduct(productResult)) {
			productRepo.deleteById(productID);
			return productID + "  Deleted Successfully";
		} else {
			return "No ProductID:" + productID + " to be deleted";
		}
	}
	public boolean checkProduct(Product product) {

		if (product != null && !product.equals("")) {
			return true;
		} else {
			return false;
		}
	}
}
