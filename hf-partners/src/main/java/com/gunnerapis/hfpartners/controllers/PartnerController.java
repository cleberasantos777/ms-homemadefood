package com.gunnerapis.hfpartners.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunnerapis.hfpartners.entities.CustomerEntity;

@RestController
@RequestMapping("/test")
public class PartnerController {	
	
	@GetMapping("/one")
	CustomerEntity test() {		
		CustomerEntity customerEntity = new CustomerEntity("Cleber","Osasco");	
		List<CustomerEntity> list = new ArrayList<>();
		list.add(customerEntity);			
		return customerEntity;
	}

	@GetMapping("/two")
	List<CustomerEntity> test2() {
		
		CustomerEntity customerEntity = new CustomerEntity("Cleber","Osasco");
		CustomerEntity customerEntity2 = new CustomerEntity("Zé João","Carapicuíba");

		List<CustomerEntity> list = new ArrayList<>();
		
		list.add(customerEntity);
		list.add(customerEntity2);
		
		
		return list;
	}
	
}
