package com.vivek.ecommerce.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.ecommerce.model.Inventory;
import com.vivek.ecommerce.repository.InventoryRepo;

@RestController
@RequestMapping(value = "/product")
public class InventoryController {
	  @Autowired
	  InventoryRepo productRepo;
	  
	  @GetMapping(value = "/all")
	  List<Inventory> getAll() {
	    return productRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<Inventory> getProductById(@PathVariable int id) {
	    return productRepo.findById(id);
	  }

	  @PostMapping(value = "/insert")
	  Optional<Inventory> insert(@RequestBody Inventory product) {
	    productRepo.save(product);
	    return productRepo.findById(product.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<Inventory> update(@RequestBody Inventory product, @PathVariable int id) {
	    product.setId(id);
	    productRepo.save(product);
	    return productRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
	    productRepo.deleteById(id);
	    return "Deleated";
	  }
}
