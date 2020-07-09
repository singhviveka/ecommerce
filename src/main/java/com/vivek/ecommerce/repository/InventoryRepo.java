package com.vivek.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vivek.ecommerce.model.Inventory;

@Component
public interface InventoryRepo extends JpaRepository<Inventory, Integer>{

}
