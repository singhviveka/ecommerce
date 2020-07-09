package com.vivek.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vivek.ecommerce.model.ProductOrder;

@Component
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer>{

}
