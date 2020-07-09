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

import com.vivek.ecommerce.model.Address;
import com.vivek.ecommerce.repository.AddressRepo;


@RestController
@RequestMapping(value = "/address")
public class AddressController {
	  @Autowired
	  AddressRepo addressRepo;

	  @GetMapping(value = "/all")
	  List<Address> getAll() {
	    return addressRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<Address> getAddressById(@PathVariable int id) {
	    return addressRepo.findById(id);
	  }

	  @PostMapping(value = "/insert")
	  Optional<Address> insert(@RequestBody Address address) {
	    addressRepo.save(address);
	    return addressRepo.findById(address.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<Address> update(@RequestBody Address address, @PathVariable int id) {
	    address.setId(id);
	    addressRepo.save(address);
	    return addressRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
	    addressRepo.deleteById(id);
	    return "Deleated";
	  }
}
