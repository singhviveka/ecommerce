package com.vivek.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vivek.ecommerce.model.Account;

@Component
public interface AccountRepo extends JpaRepository<Account, Integer>{

}
