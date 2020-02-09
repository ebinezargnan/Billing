package com.ebin.enterprise.billing.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ebin.enterprise.billing.model.Product;
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
