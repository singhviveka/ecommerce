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
import com.vivek.ecommerce.model.ProductOrder;
import com.vivek.ecommerce.model.Account;
import com.vivek.ecommerce.repository.InventoryRepo;
import com.vivek.ecommerce.repository.ProductOrderRepo;
import com.vivek.ecommerce.repository.AccountRepo;

@RestController
@RequestMapping(value = "/order")
public class ProductOrderContoller {
	  @Autowired
	  ProductOrderRepo orderRepo;
	  @Autowired
	  InventoryRepo productRepo;
	  public static int assemblingRate = 100 ;
	  @GetMapping(value = "/all")
	  List<ProductOrder> getAll() {
	    return orderRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<ProductOrder> getOrderById(@PathVariable int id) {
	    return orderRepo.findById(id);
	  }

	  @PostMapping(value = "/insert")
	  Optional<ProductOrder> insert(@RequestBody ProductOrder order) {
		int totalPriceOfProduct =0;
		List<Inventory> products = order.getProducts();
		for(Inventory product : products) {
			Optional<Inventory> p = productRepo.findById(product.getId());
			totalPriceOfProduct += p.get().getPrice();
		}
		order.setTotalPriceOfProduct(totalPriceOfProduct);
		order.setAssemblingRate(assemblingRate);
	    orderRepo.save(order);
	    return orderRepo.findById(order.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<ProductOrder> update(@RequestBody ProductOrder order, @PathVariable int id) {
	    order.setId(id);
	    order.setAssemblingCharge(order.getAssemblingRate()*order.getAssemblingTimeInDays());
	    order.setTotalAmountToPay(order.getAssemblingCharge()+order.getTotalPriceOfProduct());
	    orderRepo.save(order);
	    return orderRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
	    orderRepo.deleteById(id);
	    return "Deleated";
	  }
}
