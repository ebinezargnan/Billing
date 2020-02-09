package com.ebin.enterprise.billing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ebin.enterprise.billing.dao.ProductRepo;
import com.ebin.enterprise.billing.model.Product;
import com.ebin.enterprise.billing.service.ProductService;

@RestController
@RequestMapping("/enterprise")
public class BillingController {
	@Autowired
	ProductRepo repo;
	@Autowired
	ProductService productService;

	

	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@RequestMapping(value = "/product/{productID}", method = RequestMethod.GET)
	public String findByProduct(@PathVariable("productID") int productID) {
		return productService.findByProduct(productID);
	}

	@RequestMapping(value = "/listProduct", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@RequestMapping(value = "/product/{productID}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@PathVariable("productID") int productID, @RequestBody Product productDetails) {

		Product productResult = productService.updateProduct(productID, productDetails);
		if (productResult != null) {
			return ResponseEntity.ok(productResult);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/product/{productID}")
	public String deleteProduct(@PathVariable("productID") int productID) {
		return productService.deleteProduct(productID);
	}

}
