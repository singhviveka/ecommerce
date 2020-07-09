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

import com.vivek.ecommerce.model.Account;
import com.vivek.ecommerce.repository.AccountRepo;


@RestController
@RequestMapping(value = "/user")
public class AccountContoller {
	  @Autowired
	  AccountRepo userRepo;
	  
	  @GetMapping(value = "/all")
	  List<Account> getAll() {
	    return userRepo.findAll();
	  }

	  @GetMapping(value = "/{id}")
	  Optional<Account> getUserById(@PathVariable int id) {
	    return userRepo.findById(id);
	  }

	  @PostMapping(value = "/insert")
	  Optional<Account> insert(@RequestBody Account user) {
	    userRepo.save(user);
	    return userRepo.findById(user.getId());
	  }

	  @PutMapping(value = "/update/{id}")
	  Optional<Account> update(@RequestBody Account user, @PathVariable int id) {
	    user.setId(id);
	    userRepo.save(user);
	    return userRepo.findById(id);
	  }

	  @DeleteMapping(value = "/delete/{id}")
	  String delete(@PathVariable int id) {
	    userRepo.deleteById(id);
	    return "Deleated";
	  }
}
