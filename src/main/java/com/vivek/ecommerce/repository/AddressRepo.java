package com.vivek.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vivek.ecommerce.model.Address;

@Component
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
